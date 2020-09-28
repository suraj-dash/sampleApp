package com.moviedb.app.model;

import java.util.List;

public class Movie {
	private Integer movieId;
	private String name;
	private String year;
	private List<MovieCategory> categories;
	private List<Cast> cast;
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<MovieCategory> getCategories() {
		return categories;
	}
	public void setCategories(List<MovieCategory> categories) {
		this.categories = categories;
	}
	public List<Cast> getCast() {
		return cast;
	}
	public void setCast(List<Cast> cast) {
		this.cast = cast;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}
