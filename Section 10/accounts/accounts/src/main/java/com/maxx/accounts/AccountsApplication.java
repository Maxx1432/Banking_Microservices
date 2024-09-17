package com.maxx.accounts;

import com.maxx.accounts.dto.AccountsContactInfoDto;
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
@EnableFeignClients
/*@ComponentScans({@ComponentScan("com.maxx.accounts.controller")})
@EnableJpaRepositories("com.maxx.accounts.repository")
@EntityScan("com.maxx.accounts.model")
 */
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Account microservice REST API Documentation",
				description = "Maxx Bank Accounts microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Maxx",
						email = "itssmaxx@gmail.com",
						url = "blank"
				),
				license = @License(
						name = "Apache 2.0",
						url = "blank"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Maxx Bank Accounts microservice REST API Documentation",
				url = "blank"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
