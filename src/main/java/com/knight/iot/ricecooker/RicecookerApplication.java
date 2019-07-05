package com.knight.iot.ricecooker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RicecookerApplication {
	public static final Logger logger = LoggerFactory.getLogger("com.knight.iot.ricecooker");

	public static void main(String[] args) {
		SpringApplication.run(RicecookerApplication.class, args);
	}

}
