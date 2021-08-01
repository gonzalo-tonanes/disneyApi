package com.alk.core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alk.core.entity.Genre;
import com.alk.core.entity.Movie;

public interface RepositoryMovie extends JpaRepository<Movie, Integer>{

	
	Optional<Movie> findByTitle(String name);
	
	List<Movie> findByGenreIn(List<Genre> genres);
	
	List<Movie> findByOrderByTitleAsc();
	
	List<Movie> findByOrderByTitleDesc();
	
	
}
