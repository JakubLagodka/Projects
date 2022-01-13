package pl.lagodka.vacationapplication.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vacation {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String type;

    private Integer number_of_days;
}
