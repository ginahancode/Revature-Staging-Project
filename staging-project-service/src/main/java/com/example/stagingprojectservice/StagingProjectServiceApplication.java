package com.example.stagingprojectservice;

import com.example.stagingprojectservice.entities.Order;
import com.example.stagingprojectservice.entities.Product;
import com.example.stagingprojectservice.entities.User;
import com.example.stagingprojectservice.repositories.OrderRepo;
import com.example.stagingprojectservice.repositories.ProductRepo;
import com.example.stagingprojectservice.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StagingProjectServiceApplication {

	@Autowired
	public ProductRepo productRepo;

	@Autowired
	public UserRepo userRepo;

	@Autowired
	public OrderRepo orderRepo;

	public static void main(String[] args) {
		SpringApplication.run(StagingProjectServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner() {
		return args -> {
			Product p1 = new Product("Angular Shirt", "Shirt", "Angular", "XL", "M", 100, 10.99, "https://i.imgur.com/WjGe80V.png", "Description");
			productRepo.save(p1);

			Order o1 = new Order(1);
			orderRepo.save(o1);
		};
	}

	@Bean
	public CommandLineRunner runnerTwo() {
		return args -> {
			User u1 = new User("username", "password","Admin", "jdoe@mail.com", "John", "Doe", "123 Bird Ave", "Austin", "TX", 12345);
			userRepo.save(u1);
		};
	}
}
