package it.unipol.crm.attivita.batch.mapper;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Implementation of spring's {@link org.springframework.jdbc.core.RowMapper}, which uses
 * annotations {@link javax.persistence.Column} for mapping information. If property would
 * not have this annotation, it will be always null. <br><br>
 *
 * {@link Column#name()} value, cannot be null and must be equal to column name.<br>
 * <code>T</code> type must have no-argument constructor.
 */
@Slf4j
public class ColumnAnnotationRowMapper<T> implements RowMapper<T> {

    private final Class<T> mappedClass;
    private final List<Field> columnFields;

    public ColumnAnnotationRowMapper(Class<T> mappedClass) {
        Assert.notNull(mappedClass, "T class cannot be null!");
        this.mappedClass = mappedClass;
        this.columnFields = FieldUtils.getFieldsListWithAnnotation(this.mappedClass, Column.class);
    }

    @Override
    public T mapRow(ResultSet resultSet, int i) {

        T newObject = BeanUtils.instantiateClass(this.mappedClass);

        columnFields.forEach(f -> {
            Column column = f.getAnnotation(Column.class);
            validateColumnName(f, column);
            getValueAndUpdateField(resultSet, newObject, f, column);
        });

        return newObject;

    }

    private void getValueAndUpdateField(ResultSet resultSet, T newObject, Field f, Column column) {
        try {
            Object columnValue = null;
            if (f.getType().equals(BigInteger.class)){
                //DB2 is not supporting BigInteger in result set so here is manual handling of this type
                Long longValue = resultSet.getObject(column.name(), Long.class);
                if( longValue != null){
                    columnValue = BigInteger.valueOf(longValue);
                }
            }else {
                columnValue = resultSet.getObject(column.name(), f.getType());
            }

            if(resultSet.wasNull()){
                log.debug("Actual column value was NULL, but driver inserted default value. Previous value: {}", columnValue);
                columnValue = null;
            }

            log.debug("Found value {} for field {}.{} updating...", columnValue, mappedClass.getSimpleName(), f.getName());

            FieldUtils.writeField(newObject, f.getName(), columnValue, true);

        } catch (SQLException | IllegalAccessException e) {
            log.error("Error while mapping field {}.{}", mappedClass.getName(), f, e);
            throw new RuntimeException("Error while mapping field " + mappedClass.getSimpleName() + "." + f.getName(), e);
        }
    }

    private void validateColumnName(Field f, Column column) {

        if (StringUtils.isEmpty(column.name())) {

            log.warn("Field {}.{} has Column annotation, but without column name", mappedClass.getName(), f.getName());
            throw new RuntimeException("Field " + mappedClass.getName() + "." + f.getName() + " has Column annotation, but without column name");
        }
    }
}
