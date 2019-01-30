package com.pramati.customerrequest.RequestTracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan(basePackages ="com.pramati.customerrequest.*")
public class RequestTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestTrackingApplication.class, args);
	}
	

}

