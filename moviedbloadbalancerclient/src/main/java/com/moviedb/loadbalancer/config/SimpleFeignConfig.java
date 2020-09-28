package com.moviedb.loadbalancer.config;

import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

import feign.codec.Encoder;
import feign.form.FormEncoder;

@Configuration
public class SimpleFeignConfig {
	@Bean
    public ServerList<Server> ribbonServerList() {
        // return new ConfigurationBasedServerList();
        StaticServerList<Server> staticServerList = new StaticServerList<>((new Server("localhost", 8082)),
                new Server("localhost", 8083));
        return staticServerList;
    }
}
