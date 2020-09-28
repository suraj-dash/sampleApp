package com.moviedb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviedb.app.dao.MovieDBDao;
import com.moviedb.app.model.Movie;
import com.moviedb.app.model.SearchRequest;
@Service
public class MovieDBServiceImpl implements MovieDBService {
	@Autowired
	MovieDBDao movieDBDao;
	@Override
	public List<Movie> searchMovie(SearchRequest searchRequest) throws Exception {
		// TODO Auto-generated method stub
		return movieDBDao.searchMovie(searchRequest);
	}
	public MovieDBDao getMovieDBDao() {
		return movieDBDao;
	}
	public void setMovieDBDao(MovieDBDao movieDBDao) {
		this.movieDBDao = movieDBDao;
	}

}
