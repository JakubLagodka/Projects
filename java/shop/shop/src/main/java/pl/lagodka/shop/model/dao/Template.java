package pl.lagodka.shop.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(indexes = @Index(name = "idx_name", columnList = "name", unique = true))
public class Template {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String subject;

    @Column(columnDefinition = "text")
    private String body;
}
