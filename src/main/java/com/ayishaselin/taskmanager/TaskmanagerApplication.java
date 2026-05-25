package com.ayishaselin.taskmanager;//Spring must detect:controllers,repositories,entities ,automatically.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //enables auto-configuration, component scanning, and Spring Boot configuration.”
public class TaskmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);//It starts the Spring Boot application and initializes all configurations and embedded server.”
	}

}
