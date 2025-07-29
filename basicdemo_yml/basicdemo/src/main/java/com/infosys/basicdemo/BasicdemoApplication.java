package com.infosys.basicdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicdemoApplication implements CommandLineRunner {

	@Value("${app.name}")
	private String appName;
	@Value("${server.port}")
	private int portNo;

	public static void main(String[] args) {
		SpringApplication.run(BasicdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("app name is: "+appName);
		System.out.println("app is running on port no : "+portNo);
	}
}
