package com.healthmgmt.app;

import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableSwagger2WebMvc
public class HealthmanagmentServicesApplication {

	 private static final Logger logger = LoggerFactory.getLogger(HealthmanagmentServicesApplication.class);
	 @Autowired
	    private static Environment env;
	public static void main(String[] args) {
		
		String dburl = System.getenv().getOrDefault("DB_URL", "Environment variable not set");
		System.out.println("DB URL : "+dburl); 
		
		logger.info("{}", System.getenv("DB_URL"));
	       
		
		Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
        	
        	logger.trace("{}", envName+"="+env.get(envName));
        	
        }
        
		
		//System.out.println("DB URL env java home: "+env.getProperty("JAVA_HOME")); 
		
		
		
		SpringApplication.run(HealthmanagmentServicesApplication.class, args);
	}

}
