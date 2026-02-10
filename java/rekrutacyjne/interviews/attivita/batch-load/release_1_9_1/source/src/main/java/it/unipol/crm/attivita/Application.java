package it.unipol.crm.attivita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
@ComponentScan({"it.unipol.crm.attivita", "it.unipol.crm.logger"})
@EnableAsync
public class Application {
    public static void main (String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

