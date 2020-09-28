package com.moviedb.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.moviedb.app.model.Cast;
import com.moviedb.app.model.Person;
import com.moviedb.app.model.Role;

public class CastMapper implements RowMapper<Cast>{

	@Override
	public Cast mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Cast cast = new Cast();
		Person person = new Person();
		cast.setCastId(rs.getInt("movie_cast_id"));
		person.setPersonId(rs.getInt("person_id"));
		person.setName(rs.getString("person_name"));
		cast.setPerson(person);
		Role role = new Role();
		role.setRoleId(rs.getInt("role_id"));
		role.setRoleName(rs.getString("role_name"));
		cast.setRole(role);
		return cast;
	}

}
