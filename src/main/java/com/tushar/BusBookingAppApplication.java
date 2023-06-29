package com.tushar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.tushar.property.FileStorageProperties;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class BusBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusBookingAppApplication.class, args);
	}

	 @Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.tushar.controller")).build();
	   }
	 
	 @Bean
	    public RestTemplate getRestTemplate() {
	        return new RestTemplate();
	    }
}
