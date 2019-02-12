package com.pramati.customerrequest.requesttracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.pramati.customerrequest.*")
@EntityScan(basePackages = "com.pramati.customerrequest.pojo")
@EnableJpaRepositories("com.pramati.customerrequest.repository")

public class RequestTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestTrackingApplication.class, args);
	}

}
