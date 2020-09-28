package com.moviedb.loadbalancer.proxy;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moviedb.loadbalancer.config.SimpleFeignConfig;

import feign.QueryMap;

@FeignClient(name="com.moviedb.search.app")
@RibbonClient(name = "com.moviedb.search.app")
public interface ApiProxy {
	@RequestMapping(value = "/api/v1/search",method=RequestMethod.GET)
	public String searchMovie(@QueryMap Map<String, String> parameters);

}
