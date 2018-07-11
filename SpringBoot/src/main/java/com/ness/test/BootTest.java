package com.ness.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ness.*")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class BootTest {
	public static void main(String[] args) {
		SpringApplication.run(BootTest.class, args);
	}
}
