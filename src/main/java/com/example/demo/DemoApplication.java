package com.example.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public RouteBuilder routeBuilder() {
		return new RouteBuilder() {
			public void configure() throws Exception {
				from("timer:hello?period={{timer.period}}")
						.bean(DemoApplication.class, "updateMessage")
						.log("${body}");
			}
		};
	}

	public String updateMessage(@Header(Exchange.TIMER_FIRED_TIME) String firedTime) {
		return "Got event: " + firedTime;
	}
}
