package com.moviedb.loadbalancer.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moviedb.loadbalancer.proxy.ApiProxy;

@RestController
@RequestMapping("/api/v1")
public class LoadBalancerClientController {
	@Autowired
	ApiProxy apiProxy;
	@RequestMapping(value = "/search",method=RequestMethod.GET)
	public String searchMovie(HttpServletRequest request) {
		Map<String, String> parameters = new LinkedHashMap<String,String>();
		        parameters.put("actorName", request.getParameter("actorName"));
		        parameters.put("movieName", request.getParameter("movieName"));
		        parameters.put("directorName", request.getParameter("directorName"));
		        parameters.put("producerName", request.getParameter("producerName"));
		        parameters.put("year", request.getParameter("year"));
		        parameters.put("categoryName", request.getParameter("categoryName"));
		return apiProxy.searchMovie(parameters);
	}
}
