package com.upgrad.mavgrad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MavgradApplication {
	public MavgradApplication(){
		System.out.println("*********** MavgradApplication ***********");
	}
	public static void main(String[] args) {
		SpringApplication.run(MavgradApplication.class, args);
	}

}
