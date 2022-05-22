package com.awardega.GuessDrawnValue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.awardega.GuessDrawnValue")
@EnableAutoConfiguration(exclude= DataSourceAutoConfiguration.class)
@EntityScan("com.awardega.GuessDrawnValue.entities")
public class GuessDrawnValueApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuessDrawnValueApplication.class, args);
	}

}
