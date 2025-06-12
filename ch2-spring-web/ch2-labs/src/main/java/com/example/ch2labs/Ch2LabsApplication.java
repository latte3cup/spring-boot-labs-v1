package com.example.ch2labs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Ch2LabsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ch2LabsApplication.class, args);
	}

}
