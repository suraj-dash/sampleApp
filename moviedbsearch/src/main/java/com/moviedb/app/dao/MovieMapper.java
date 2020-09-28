package com.moviedb.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.moviedb.app.model.Movie;

public class MovieMapper implements RowMapper<Movie>{

	@Override
	public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Movie movie = new Movie();
		movie.setMovieId(rs.getInt("movie_id"));
		movie.setName(rs.getString("movie_name"));
		movie.setYear(rs.getString("year"));
		return movie;
	}

}
