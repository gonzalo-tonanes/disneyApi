package com.alk.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alk.core.entity.DisneyCharacter;
import com.alk.core.entity.Movie;
import com.alk.core.repository.RepositoryCharacterDisney;

@Service
public class CharacterDisneyServiceImpl implements CharacterDisneyService {

	@Autowired
	private RepositoryCharacterDisney repo;
	
	@Override
	public void addCharacter(DisneyCharacter c) {
		
		repo.save(c);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<DisneyCharacter> findAll() {
	
		return repo.findAll();
	}

	@Override
	public void deleteChar(DisneyCharacter c) {
		repo.delete(c);
		
	}

	@Override
	public DisneyCharacter findChar(DisneyCharacter c) {
		
		return repo.findById(c.getId()).orElse(null);
	}

	@Override
	public List<DisneyCharacter> findByAge(int age) {
		
		return repo.findByAge(age);
	}

	@Override
	public Optional<DisneyCharacter> findByName(String name) {
		
		return repo.findByName(name);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DisneyCharacter> findByMovies(List<Movie> movie) {
		
		return repo.findByMoviesIn(movie);
	}

	
	
	

}
