package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableFeignClients
public class GatewayServerApp {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApp.class, args);
	}

}