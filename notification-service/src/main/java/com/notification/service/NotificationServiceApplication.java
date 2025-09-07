package com.notification.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
public class NotificationServiceApplication {
public static void main(String[] args) {
	//SpringApplication app =new  SpringApplication.run(NotificationServiceApplication.class, args);
    SpringApplication app = new SpringApplication(NotificationServiceApplication.class);
	app.setAdditionalProfiles("local");   // ✅ Local profile active
    app.run(args);
}
}
