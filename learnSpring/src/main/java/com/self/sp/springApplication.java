package com.self.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jj.controller")
public class springApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(springApplication.class, args);
	}

}
