package com.coforge.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Entry Point
@SpringBootApplication  //@Configuration(bean obj) + @EnableAutoConfiguration() + @Component Scan Configuration
public class SbEmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbEmsApplication.class, args);
	}

}
