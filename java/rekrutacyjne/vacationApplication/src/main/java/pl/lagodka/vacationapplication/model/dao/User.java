package pl.lagodka.vacationapplication.model.dao;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users", indexes = @Index(name = "idx_login", columnList = "login", unique = true))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String login;

    private String password;
}
