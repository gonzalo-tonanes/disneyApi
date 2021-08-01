package com.alk.core.service;

import java.util.List;
import java.util.Optional;

import com.alk.core.entity.Genre;
import com.alk.core.entity.Movie;

public interface MovieService {

	
	public void addMovie(Movie m);
	
	public List<Movie> findAll();
	
	public void deleteMovie(Movie m);
	
	public Movie findMovie(Movie m);
	
	public Optional<Movie> findByName(String name);
	
	public List<Movie> findByGenre(List<Genre> genres);
	
	public List<Movie> findByNameDesc();
	
	public List<Movie> findByNameAsc();
}
