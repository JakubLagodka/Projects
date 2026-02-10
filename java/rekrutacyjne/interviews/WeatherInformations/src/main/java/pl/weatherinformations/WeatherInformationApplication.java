package pl.weatherinformations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WeatherInformationApplication {

    static void main( String[] args ) {
        SpringApplication.run( WeatherInformationApplication.class, args );
    }

}
