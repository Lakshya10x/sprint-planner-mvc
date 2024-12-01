package com.project.sprintplanner.sprint_planner.sprint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.project.sprintplanner")
public class SprintPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintPlannerApplication.class, args);
	}

}
