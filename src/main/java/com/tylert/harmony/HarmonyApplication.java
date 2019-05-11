package com.tylert.harmony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * HarmonyLauncher: this is where JavaFX and Spring Boot are launched
 * 
 * @author tyler
 *
 */
@SpringBootApplication
public class HarmonyApplication {

	/**
	 * main method, start of execution
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(HarmonyApplication.class, args);
	}
}
