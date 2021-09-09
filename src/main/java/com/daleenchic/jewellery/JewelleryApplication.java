package com.daleenchic.jewellery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JewelleryApplication {

	public static void main(String[] args) {
		SpringApplication.run(JewelleryApplication.class, args);
	}
}
