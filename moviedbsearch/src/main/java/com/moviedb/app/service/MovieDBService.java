package com.moviedb.app.service;

import java.util.List;

import com.moviedb.app.model.Movie;
import com.moviedb.app.model.SearchRequest;

public interface MovieDBService {
	public List<Movie> searchMovie(SearchRequest searchRequest) throws Exception;
}
