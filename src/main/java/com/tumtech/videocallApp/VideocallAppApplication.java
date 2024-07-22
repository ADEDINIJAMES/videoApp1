package com.tumtech.videocallApp;

import com.tumtech.videocallApp.service.UserService;
import com.tumtech.videocallApp.users.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideocallAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideocallAppApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(
			UserService userService
	) {
		return  args -> {
			userService.register(Users.builder()

							.username("James")
							.email("james@Gmail.com")
							.password("james1")
					.build());

			userService.register(Users.builder()

					.username("Peter")
					.email("peter@Gmail.com")
					.password("james1")
					.build());

			userService.register(Users.builder()

					.username("Busayo")
					.email("busayomi@Gmail.com")
					.password("james1")
					.build());
		};
	}

}
