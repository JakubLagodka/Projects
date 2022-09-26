package com.lagodka.santa;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
public class Price {
    @CsvBindByPosition(position = 0)
    private Long id;
    @CsvBindByPosition(position = 1)
    private String currency;
    @CsvBindByPosition(position = 2)
    private BigDecimal ask;
    @CsvBindByPosition(position = 3)
    private BigDecimal bid;
    @CsvBindByPosition(position = 4)
    private String timestamp;
}
