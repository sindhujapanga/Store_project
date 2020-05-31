package com.store.ManagerService;


import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
@EnableCircuitBreaker
public class ManagerServiceApplication {
	
	@Bean
	public ModelMapper initializeModelMapper()
	{
		return new ModelMapper(); 
	}
	
	
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(ManagerServiceApplication.class, args);
	}
	@Bean
	public Docket SwaggerConfig () {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.store"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo( ) {
		return new ApiInfo("Retail Store", "description", "version",
							"termsOfServiceUrl", 
							new springfox.documentation.service.Contact("store", "url", "email.com"),
							"license", "licenseUrl",Collections.emptyList());
	}
		

}
