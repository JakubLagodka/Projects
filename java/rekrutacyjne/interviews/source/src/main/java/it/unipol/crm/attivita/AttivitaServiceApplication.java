package it.unipol.crm.attivita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan({"it.unipol.crm.attivita", "it.unipol.crm.logger"})
public class AttivitaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttivitaServiceApplication.class, args);
    }
}
