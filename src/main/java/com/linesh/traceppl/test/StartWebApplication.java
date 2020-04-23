package com.linesh.traceppl.test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages = "com.linesh")
public class StartWebApplication extends SpringBootServletInitializer{
	
     public static void main(String[] args) {
        SpringApplication.run(StartWebApplication.class, args);
    }
     
     @Override
     protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
         return builder.sources(StartWebApplication.class);
     }
     
   /*  @Bean
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
     }*/
 }