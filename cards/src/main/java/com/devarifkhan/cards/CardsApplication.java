package com.devarifkhan.cards;

import com.devarifkhan.cards.dto.CardsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.devarifkhan.cards.controller") })
@EnableJpaRepositories("com.devarifkhan.cards.repository")
@EntityScan("com.devarifkhan.cards.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Cards microservice REST API Documentation",
                description = "ArifBank Cards microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Ariful Islam",
                        email = "aidevstack@gmail.com",
                        url = "https://www.aidevstack.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.aidevstack.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "ArifBank Cards microservice REST API Documentation",
                url = "https://www.aidevstack.com/swagger-ui.html"
        )
)
@EnableConfigurationProperties(value={CardsContactInfoDto.class})
public class CardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardsApplication.class, args);
    }

}
