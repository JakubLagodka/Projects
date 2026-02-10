package it.unipol.crm.sinistro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"it.unipol.crm.sinistro", "it.unipol.crm.logger"})
public class SinistriServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinistriServiceApplication.class, args);
    }
}
