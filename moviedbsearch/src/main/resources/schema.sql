create table movie_category(
	category_id integer primary key,
	category_name varchar(20) not null
);
create table role(
	role_id integer primary key,
	role_name varchar(20) not null
);
create table person(
	person_id integer primary key,
	person_name varchar(50) not null
);
create table movie(
	movie_id integer primary key,
	movie_name varchar(50) not null,
	year integer not null
);
create table movie_category_mapping(
	movie_category_id integer primary key,
	movie_id integer not null,
	category_id integer not null
);
create table movie_cast(
	movie_cast_id integer primary key,
	movie_id integer not null,
	person_id integer not null,
	role_id integer not null
);