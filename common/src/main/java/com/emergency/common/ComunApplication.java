package com.emergency.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ComunApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComunApplication.class, args);
	}

}
