package com.vmw.rpm.springbootdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDockerApplication {

	public static void main(String[] args) {
		System.out.println("Hello World");
		SpringApplication.run(SpringbootDockerApplication.class, args);
	}

}
