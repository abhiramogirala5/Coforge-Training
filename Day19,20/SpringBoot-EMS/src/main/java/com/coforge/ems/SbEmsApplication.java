package com.coforge.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//Entry Point
@SpringBootApplication  //@Configuration(bean obj) + @EnableAutoConfiguration() + @Component Scan Configuration
@EnableDiscoveryClient
@EnableFeignClients
public class SbEmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbEmsApplication.class, args);
	}

}
