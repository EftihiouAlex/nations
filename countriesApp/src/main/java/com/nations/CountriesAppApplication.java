package com.nations;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.nations.dao")
@SpringBootApplication
public class CountriesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountriesAppApplication.class, args);
	}
}
