package com.linesh.test;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan ("com.linesh.*")
@EnableAutoConfiguration
@SpringBootApplication
public class Application extends SpringBootServletInitializer{
	
     public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
 }