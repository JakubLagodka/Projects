package pl.lagodka.shop.model.dao;

import javax.persistence.*;

@Entity
public class Template {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String subject;

    @Lob
    private String body;
}
