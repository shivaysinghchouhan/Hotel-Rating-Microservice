package com.review;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
@ComponentScan({"com.review"})
public class ReviewMainClass {
public static void main(String[] args) {
	SpringApplication.run(ReviewMainClass.class, args);
}
}
