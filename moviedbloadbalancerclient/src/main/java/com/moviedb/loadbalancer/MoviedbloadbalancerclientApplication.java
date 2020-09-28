package com.moviedb.loadbalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.moviedb.loadbalancer.config.SimpleFeignConfig;

@SpringBootApplication
@EnableFeignClients("com.moviedb.loadbalancer")
@EnableDiscoveryClient
@RibbonClient(name = "com.moviedb.search.app", configuration = SimpleFeignConfig.class)
public class MoviedbloadbalancerclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviedbloadbalancerclientApplication.class, args);
	}

}
