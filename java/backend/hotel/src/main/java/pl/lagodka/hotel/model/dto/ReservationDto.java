package pl.lagodka.hotel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReservationDto {
    private Long id;

    private Date startDate;

    private Date endDate;

    private int numberOfDays;

    private double price;

    private boolean paid;
}
