package com.sprint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Indicates that this class is a "OnlinePlantNurseryApplication", is the main
 * program for the sprint project "Online Plant Nursery Application" In this
 * project we created the entities class, service interfaces, serviceImpl
 * classes implements service class, controller classes, repository interfaces.
 * Handle the exception , provides web security. We used
 * mappings,configurations, rest controller ,autowired
 * 
 * @Date
 * @Start Date 21.092021
 * @End Date 28-09-2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 **/

@SpringBootApplication
public class OnlinePlantNurseryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinePlantNurseryApplication.class, args);
		System.out.println("Working...");
	}

}
