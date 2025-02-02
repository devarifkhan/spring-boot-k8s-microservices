package com.devarifkhan.accounts;

import com.devarifkhan.accounts.dto.AccountContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.devarifkhan.accounts.controller") })
@EnableJpaRepositories("com.devarifkhan.accounts.repository")
@EntityScan("com.devarifkhan.accounts.model")*/
@EnableConfigurationProperties(value={AccountContactInfoDto.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "ArifBank Accounts microservice REST API Documentation",
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
				description =  "ArifBank Accounts microservice REST API Documentation",
				url = "https://www.aidevstack.com/swagger-ui.html"
		)
)
@EnableFeignClients
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
