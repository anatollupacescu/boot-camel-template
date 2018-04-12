package com.example.demo;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
    public AWSCredentials credentials(@Value("${awsAccessKey}") String awsAccessKey,
                                      @Value("${awsAccessKeySecret}") String awsAccessKeySecret) {
        return new BasicAWSCredentials(awsAccessKey, awsAccessKeySecret);
    }
}