package com.emergency.demand.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemandQueryApplication {
    @PostConstruct
	private void registerEvents(){
	}
	public static void main(String[] args) {
		SpringApplication.run(DemandQueryApplication.class, args);
	}

}
