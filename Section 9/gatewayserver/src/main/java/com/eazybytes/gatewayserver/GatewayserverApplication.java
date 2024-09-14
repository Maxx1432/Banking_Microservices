package com.eazybytes.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@Bean
	public RouteLocator maxxBankRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
						.route(p -> p
								.path("/maxxbank/accounts/**")
								.filters( f -> f.rewritePath("/maxxbank/accounts/(?<segment>.*)","/${segment}")
										.addResponseHeader("X-Response-Time",LocalDateTime.now().toString()))
								.uri("lb://ACCOUNTS")) // It should be in Upper Case because it will match with Eureka service Registery
					.route(p -> p
							.path("/maxxbank/loans/**")
							.filters( f -> f.rewritePath("/maxxbank/loans/(?<segment>.*)","/${segment}")
									.addResponseHeader("X-Response-Time",LocalDateTime.now().toString()))
							.uri("lb://LOANS")) // It should be in Upper Case because it will match with Eureka service Registery
					.route(p -> p
							.path("/maxxbank/cards/**")
							.filters( f -> f.rewritePath("/maxxbank/cards/(?<segment>.*)","/${segment}")
									.addResponseHeader("X-Response-Time",LocalDateTime.now().toString()))
							.uri("lb://CARDS")).build(); // It should be in Upper Case because it will match with Eureka service Registery


	}


}
