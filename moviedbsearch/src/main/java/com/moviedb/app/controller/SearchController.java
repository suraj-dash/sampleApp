package com.moviedb.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moviedb.app.model.Cast;
import com.moviedb.app.model.Movie;
import com.moviedb.app.model.MovieCategory;
import com.moviedb.app.model.Person;
import com.moviedb.app.model.SearchRequest;
import com.moviedb.app.model.SearchResponse;
import com.moviedb.app.service.MovieDBService;

@RestController
@RequestMapping("/api/v1")
public class SearchController {
	@Autowired
	MovieDBService movieDBService;
	/*@RequestMapping(value = "/search",method=RequestMethod.GET)
	public String searchMovie(HttpServletRequest request) {
		System.out.println("in post method");
		List<Movie> movies = null;
		String movieName = request.getParameter("movieName");
		System.out.println("movieName>>>"+movieName+"<<<<<<<");
		String actorName = request.getParameter("actorName");
		System.out.println("actorName>>>"+actorName+"<<<<<<");
		String directorName = request.getParameter("directorName");
		System.out.println("directorName>>>"+directorName+"<<<<<<");
		String producerName = request.getParameter("producerName");
		System.out.println("producerName>>>"+producerName+"<<<<<<");
		String year = request.getParameter("year");
		System.out.println("year>>>"+year+"<<<<<<");
		String categoryName = request.getParameter("categoryName");
		System.out.println("categoryName>>>"+categoryName+"<<<<<<");
		try {
			SearchRequest searchRequest = null;
			if((movieName != null && !movieName.equals("")) || (actorName!=null && !actorName.equals("")) || (directorName != null && !directorName.equals("")) || (producerName != null && !producerName.equals("")) || (year != null && !year.equals("")) || (categoryName != null && !categoryName.equals(""))) {
				searchRequest = new SearchRequest();
				searchRequest.setActorName(actorName);
				searchRequest.setCategoryName(categoryName);
				searchRequest.setCategoryName(movieName);
				searchRequest.setDirectorName(directorName);
				searchRequest.setProducerName(producerName);
			}
			
			movies = movieDBService.searchMovie(searchRequest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new GsonBuilder().create();
		gson.toJson(movies);
		return gson.toJson(movies);
	}*/
	@RequestMapping(value = "/search",method=RequestMethod.POST,consumes = "application/json", produces="application/json" )
	public String searchMoviePost(HttpServletRequest request, @RequestBody SearchRequest searchRequest) {
		List<Movie> movies = null;
		List<SearchResponse> respList = new ArrayList<SearchResponse>();
		try {
			movies = movieDBService.searchMovie(searchRequest);
			for(Movie movie : movies) {
				SearchResponse resp = new SearchResponse();
				resp.setMovieId(movie.getMovieId());
				resp.setName(movie.getName());
				resp.setYear(movie.getYear());
				StringBuffer actorList = new StringBuffer("");
				StringBuffer directorList = new StringBuffer("");
				StringBuffer producerList = new StringBuffer("");
				for(Cast cast : movie.getCast()) {
					Person person = cast.getPerson();
					if(cast.getRole() != null && cast.getRole().getRoleId() ==1) {
						actorList.append(person.getName()+" ");
					} else if(cast.getRole() != null && cast.getRole().getRoleId() ==2) {
						directorList.append(person.getName()+" ");
					} else if(cast.getRole() != null && cast.getRole().getRoleId() ==3){
						producerList.append(person.getName()+" ");
					}
				}
				resp.setActor(actorList.toString());
				resp.setDirector(directorList.toString());
				resp.setProducer(producerList.toString());
				StringBuffer categoryList = new StringBuffer("");
				for (MovieCategory category: movie.getCategories()) {
					categoryList.append(category.getCategoryName() +" ");
				}
				resp.setCategory(categoryList.toString());
				respList.add(resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new GsonBuilder().create();
		return gson.toJson(respList);
	}
}
