package com.negen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.negen")
public class SpringbootShiroTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootShiroTutorialApplication.class, args);
	}

}
