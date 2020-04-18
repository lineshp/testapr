package com.linesh.traceppl.test;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
@ComponentScan ("com.linesh.*")
@EnableAutoConfiguration
@SpringBootApplication
public class Application extends SpringBootServletInitializer{
	
     public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
     
     @Bean
     public RequestContextListener requestContextListener() {
         return new RequestContextListener();
     }
     
    @Bean
 	public RestTemplate restTemplate(RestTemplateBuilder builder) {
 		return builder.build();
 	}
      
     @Override
     public void onStartup(ServletContext servletContext) throws ServletException {
         super.onStartup(servletContext);
         servletContext.addListener(new RequestContextListener());
     }
 }