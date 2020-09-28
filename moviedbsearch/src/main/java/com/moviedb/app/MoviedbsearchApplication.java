package com.moviedb.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableCaching
@SpringBootApplication
@EnableDiscoveryClient
public class MoviedbsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviedbsearchApplication.class, args);
	}

}
