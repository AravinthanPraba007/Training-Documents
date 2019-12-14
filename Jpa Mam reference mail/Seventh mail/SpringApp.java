package com.cts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

  
@SpringBootApplication  
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
@EnableJpaAuditing
public class SpringApp {
	    public static void main(String[] args) {  
	        SpringApplication.run(SpringApp.class, args);  
	    }  
	}  