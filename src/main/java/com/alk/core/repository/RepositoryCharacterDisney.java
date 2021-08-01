package com.alk.core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alk.core.entity.DisneyCharacter;
import com.alk.core.entity.Movie;

@Repository
public interface RepositoryCharacterDisney extends JpaRepository<DisneyCharacter, Integer> {

	
	List<DisneyCharacter> findByAge(int age);
	
	List<DisneyCharacter> findByMoviesIn(List<Movie> movie);
	
	Optional<DisneyCharacter> findByName(String name);
	
}
