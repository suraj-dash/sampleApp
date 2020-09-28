package com.moviedb.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.moviedb.app.model.Cast;
import com.moviedb.app.model.Movie;
import com.moviedb.app.model.MovieCategory;
import com.moviedb.app.model.SearchRequest;

@Repository
public class MovieDBDaoImpl implements MovieDBDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	//@Cacheable(value="movies")
	public List<Movie> searchMovie(SearchRequest searchRequest) throws Exception{
		System.out.println("in searchMovies");
		boolean filterFlag = false;
		StringBuffer whereclause = null;
		StringBuffer query = new StringBuffer("select mov.movie_id,mov.movie_name,year from movie mov");
		if(searchRequest != null) {
			
			if((searchRequest.getActorName() != null && !searchRequest.getActorName().equals("") ) || (searchRequest.getDirectorName() != null && !searchRequest.getDirectorName().equals("")) || (searchRequest.getProducerName() != null && !searchRequest.getProducerName().equals(""))) {
				query.append(" inner join movie_cast mc on mov.movie_id = mc.movie_id");
				query.append(" inner join person p on p.person_id=mc.person_id");
				filterFlag = true;
			}
			if(searchRequest.getCategoryName() != null && !searchRequest.getCategoryName().equals("")) {
				query.append(" inner join movie_category_mapping mcm on mcm.movie_id = mov.movie_id");
				query.append(" inner join movie_category mcat on mcm.category_id = mcat.category_id");
				filterFlag = true;
			}
			
			
			if(searchRequest.getActorName() != null && !searchRequest.getActorName().equals("") ) {
				if(whereclause == null) {
					whereclause = new StringBuffer(" ");
				} else {
					whereclause.append(" and ");
				}
				whereclause.append(" mc.role_id = 1 and p.person_name like '%"+searchRequest.getActorName()+"%'");
			}
			if(searchRequest.getDirectorName() != null && !searchRequest.getDirectorName().equals("")) {
				if(whereclause == null) {
					whereclause = new StringBuffer(" ");
				} else {
					whereclause.append(" and ");
				}
				whereclause.append(" mc.role_id = 2 and p.person_name like '%"+searchRequest.getDirectorName()+"%'");
			}
			if(searchRequest.getProducerName() != null && !searchRequest.getProducerName().equals("")) {
				if(whereclause == null) {
					whereclause = new StringBuffer(" ");
				} else {
					whereclause.append(" and ");
				}
				whereclause.append(" mc.role_id = 3 and p.person_name like '%"+searchRequest.getProducerName()+"%'");
			}
			if(searchRequest.getCategoryName() != null && !searchRequest.getCategoryName().equals("")) {
				if(whereclause == null) {
					whereclause = new StringBuffer(" ");
				} else {
					whereclause.append(" and ");
				}
				whereclause.append(" mcat.category_name like '%"+searchRequest.getCategoryName()+"%'");
			}
			if(searchRequest.getMovieName() != null && !searchRequest.getMovieName().equals("")) {
				if(whereclause == null) {
					whereclause = new StringBuffer(" ");
				} else {
					whereclause.append(" and ");
				}
				whereclause.append(" mov.movie_name like '%"+searchRequest.getMovieName()+"%'");
			}
			if(searchRequest.getYear() != null && !searchRequest.getYear().equals("")) {
				if(whereclause == null) {
					whereclause = new StringBuffer(" ");
				} else {
					whereclause.append(" and ");
				}
				whereclause.append(" mov.year like '%"+searchRequest.getYear()+"%'");
			}
		}
		if(whereclause != null) {
			query.append(" where");
			query.append(whereclause.toString());
		}
		System.out.println("query>>>>"+query.toString());
		List<Movie> movies =  jdbcTemplate.query(query.toString(), new MovieMapper());
		for (Movie movie : movies) {
			movie.setCast(getCast(movie.getMovieId()));
			movie.setCategories(getCategories(movie.getMovieId()));
		}
		return movies;
	}
	
	private List<Cast> getCast(Integer movieId) throws Exception{
		StringBuffer query = new StringBuffer("select mc.movie_cast_id, mc.movie_id, mc.person_id, mc.role_id, p.person_name, r.role_name from movie_cast mc inner join person p on mc.person_id = p.person_id inner join role r on r.role_id = mc.role_id inner join movie mov on mov.movie_id = mc.movie_id and mov.movie_id = "+movieId);
		
		List<Cast> casts =  jdbcTemplate.query(query.toString(), new CastMapper());
		return casts;
	}
	private List<MovieCategory> getCategories(Integer movieId) throws Exception{
		StringBuffer query = new StringBuffer("select mcm.movie_category_id,mc.category_name from movie_category_mapping mcm inner join movie_category mc on mc.category_id = mcm.movie_category_id inner join movie mov on mcm.movie_id = mov.movie_id and mov.movie_id = "+movieId);
		
		List<MovieCategory> movieCategories =  jdbcTemplate.query(query.toString(), new CategoryMapper());
		return movieCategories;
	}
}
