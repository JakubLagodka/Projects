package pl.lagodka.shop.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer",new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .info(new Info()
                        .title("Shop Api")
                        .description("This is an application for operating an online store. The application was written in Java using Spring Boot and PostgreSQL as a database. It allows user to review products and add it to basket and order products from basket. To perform this operation user has to login. It also allows you to generate report of products in the form of selected files. Application is tested by unit and integration tests.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .email("jakub.lagodka.pl@gmail.com")
                                .url("https://github.com/JakubLagodka/Projects/tree/master/shop")
                                .name("Jakub Łagódka")));
    }
}
