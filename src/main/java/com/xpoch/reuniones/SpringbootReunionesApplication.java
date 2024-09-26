package com.xpoch.reuniones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;

@SpringBootApplication
public class SpringbootReunionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootReunionesApplication.class, args);
	}

	//ServerProperties.compression.enabled=true;
}
