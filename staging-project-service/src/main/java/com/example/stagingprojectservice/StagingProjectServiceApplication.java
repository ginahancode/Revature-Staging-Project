package com.example.stagingprojectservice;

import com.example.stagingprojectservice.entities.Product;
import com.example.stagingprojectservice.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StagingProjectServiceApplication {

	@Autowired
	public ProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(StagingProjectServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner runner() {
		return args -> {
			Product p1 = new Product("Angular Shirt", "Shirt", "Angular", "XL", "M", 100, 10.99, "imageURL");
			productRepo.save(p1);
		};
	}
}
