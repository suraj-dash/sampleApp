package com.moviedb.app.tests;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviedb.app.MoviedbsearchApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MoviedbsearchApplication.class)
class MoviedbsearchApplicationTests {
	@Autowired
	private transient TestRestTemplate restTemplate;
	private transient HttpHeaders headers;
	private transient HttpEntity<?> entity;
	@Test
	public void shouldGetAllMovies() throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		entity = new HttpEntity<Object>("{\"movieName\":null,\"categoryName\":null,\"year\":null,\"actorName\":null,\"directorName\":null,\"producerName\":null}",headers);

		ResponseEntity<String> res = restTemplate.postForEntity("/api/v1/search", entity, String.class);
		//ResponseEntity<String> res = restTemplate.getForEntity("/api/v1/search", String.class);
		assertThat(res.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(res.getBody(), notNullValue());

	}
	@Test
	public void shouldSearchByName() throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		entity = new HttpEntity<Object>("{\"movieName\":\"Avengers\",\"categoryName\":null,\"year\":null,\"actorName\":null,\"directorName\":null,\"producerName\":null}",headers);

		ResponseEntity<String> res = restTemplate.postForEntity("/api/v1/search", entity, String.class);
		//ResponseEntity<String> res = restTemplate.getForEntity("/api/v1/search", String.class);
		assertThat(res.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(res.getBody(), notNullValue());

	}
	
	@Test
	public void shouldSearchByActorName() throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		entity = new HttpEntity<Object>("{\"movieName\":\"Avengers\",\"categoryName\":null,\"year\":null,\"actorName\":\"Robert\",\"directorName\":null,\"producerName\":null}",headers);

		ResponseEntity<String> res = restTemplate.postForEntity("/api/v1/search", entity, String.class);
		//ResponseEntity<String> res = restTemplate.getForEntity("/api/v1/search", String.class);
		assertThat(res.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(res.getBody(), notNullValue());

	}

}
