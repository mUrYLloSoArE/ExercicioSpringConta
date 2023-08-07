package com.example.projetoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.projetoSpring")
public class ProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringApplication.class, args);
	}

}
