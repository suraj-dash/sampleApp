package com.moviedb.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.moviedb.app.model.MovieCategory;

public class CategoryMapper implements RowMapper<MovieCategory> {

	@Override
	public MovieCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		MovieCategory movieCategory  = new MovieCategory();
		movieCategory.setCategoryId(rs.getInt("movie_category_id"));
		movieCategory.setCategoryName(rs.getString("category_name"));
		return movieCategory;
	}

}
