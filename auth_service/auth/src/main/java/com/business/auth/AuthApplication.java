package com.business.auth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.business.auth.user.User;
import com.business.auth.user.UserRepository;

@SpringBootApplication
@EnableEurekaClient
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialUserData(UserRepository repository) {
		return (args) -> {
			User user = new User("angkhana.lil94@gmail.com",
					"angkhana",
					"1234",
					"ADMIN");
			repository.save(user);
		};
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
