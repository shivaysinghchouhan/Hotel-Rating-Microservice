package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
@EnableEurekaClient
@EnableAutoConfiguration
@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = "com.user")
public class UserMainClass {
public static void main(String[] args) {
	SpringApplication.run(UserMainClass.class, args);
}
}
