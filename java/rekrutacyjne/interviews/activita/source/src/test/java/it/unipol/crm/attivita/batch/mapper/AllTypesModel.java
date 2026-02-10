package it.unipol.crm.attivita.batch.mapper;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ALL_TYPES_MODEL")
public class AllTypesModel {

    @Id
    @Column(name = "BIG_INTEGER")
    private BigInteger bigInteger;

    @Column(name = "BIG_DECIMAL")
    private BigDecimal bigDecimal;

    @Column(name = "A_LONG")
    private Long aLong;

    @Column(name = "A_INTEGER")
    private Integer integer;

    @Column(name = "STRING")
    private String string;

    @Column(name = "FLAG")
    private Boolean aBoolean;

    @Column(name = "SQL_TIMESTAMP")
    private Timestamp timestamp;

    @Column(name = "SQL_DATE")
    private Date date;

    @Column(name = "LOCAL_DATE_TIME")
    private LocalDateTime localDateTime;

    @Column(name = "EMPTY_BIG_INTEGER")
    private BigInteger emptyBigInteger;

    @Column(name = "EMPTY_LONG")
    private Long emptyLong;

}
