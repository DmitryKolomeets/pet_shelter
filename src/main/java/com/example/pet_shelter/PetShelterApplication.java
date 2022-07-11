package com.example.pet_shelter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;





@SpringBootApplication
@EnableCaching
public class PetShelterApplication {


	public static void main(String[] args) {
		SpringApplication.run(PetShelterApplication.class, args);
	}

}
