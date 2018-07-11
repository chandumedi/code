package com.ness.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.ness.util.FileStorageProperties;

@SpringBootApplication
@ComponentScan(basePackages= {"com.ness.service","com.ness.dao","com.ness.controller","com.ness.interceptors"})
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@EnableConfigurationProperties({FileStorageProperties.class})
public class BootTest {
	public static void main(String[] args) {
		SpringApplication.run(BootTest.class, args);
	}
}
