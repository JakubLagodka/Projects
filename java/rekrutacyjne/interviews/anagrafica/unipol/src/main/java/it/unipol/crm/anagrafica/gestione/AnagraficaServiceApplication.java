package it.unipol.crm.anagrafica.gestione;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan({"it.unipol.crm.anagrafica", "it.unipol.crm.logger"})
@EnableFeignClients
@EnableCaching
@EnableScheduling
public class AnagraficaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnagraficaServiceApplication.class, args);
    }
}
