package com.moviedb.app.model;

public class Cast {
	private Integer castId;
	private Person person;
	private Role role;
	public Integer getCastId() {
		return castId;
	}
	public void setCastId(Integer castId) {
		this.castId = castId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
