package com.moviedb.app.dao;

import com.moviedb.app.model.SearchRequest;

import java.util.List;

import com.moviedb.app.model.Movie;
public interface MovieDBDao {
	public List<Movie> searchMovie(SearchRequest searchRequest) throws Exception;
}
