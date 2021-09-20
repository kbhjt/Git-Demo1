package com.nchu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.nchu.mapper")
@EnableScheduling
public class EpidemicSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpidemicSystemApplication.class, args);
	}

}
