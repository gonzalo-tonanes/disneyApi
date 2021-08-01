package com.alk.core.service;

import java.util.List;
import java.util.Optional;

import com.alk.core.entity.DisneyCharacter;
import com.alk.core.entity.Movie;

public interface CharacterDisneyService  {

	public void addCharacter(DisneyCharacter c);
	
	public List<DisneyCharacter> findAll();
	
	public void deleteChar(DisneyCharacter c);
	
	public DisneyCharacter findChar(DisneyCharacter c);
	
	public List<DisneyCharacter> findByAge(int age);
	
	public Optional<DisneyCharacter> findByName(String name);
	
	public List<DisneyCharacter> findByMovies(List<Movie> movie);
}
