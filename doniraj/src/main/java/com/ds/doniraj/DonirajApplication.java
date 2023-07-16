package com.ds.doniraj;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.ds.doniraj")
public class DonirajApplication {

	public static void main(String[] args) {

		SpringApplication.run(DonirajApplication.class, args);
		}
	}


