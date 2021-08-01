package com.alk.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alk.core.entity.Genre;
import com.alk.core.entity.Movie;
import com.alk.core.repository.RepositoryMovie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private RepositoryMovie repo;
	
	@Override
	public void addMovie(Movie m) {
		repo.save(m);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> findAll() {
		return repo.findAll();
	}

	@Override
	public void deleteMovie(Movie m) {

		repo.delete(m);
	}

	@Override
	public Movie findMovie(Movie m) {
		
		return repo.findById(m.getId()).orElse(null);
	}

	@Override
	public Optional<Movie> findByName(String name) {
		
		return repo.findByTitle(name);
	}

	@Override
	public List<Movie> findByGenre(List<Genre> genres) {
		
		return repo.findByGenreIn(genres);
	}

	@Override
	public List<Movie> findByNameDesc() {
		
		return repo.findByOrderByTitleDesc();
	
	}

	@Override
	public List<Movie> findByNameAsc() {
		
		return repo.findByOrderByTitleAsc();
	}

	

}
