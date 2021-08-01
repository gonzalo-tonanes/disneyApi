package com.alk.core.converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.alk.core.dto.CharacterDisneySimpleDTO;
import com.alk.core.dto.MovieFullDTO;
import com.alk.core.dto.MovieSimpleDTO;
import com.alk.core.entity.DisneyCharacter;
import com.alk.core.entity.Movie;

public class ToMovieDTO {

	private static int id;
	private static int qualification;
	private static String title;
	private static String image;
	private static Date date;
	private static List<MovieFullDTO> moviesFullDTO;
	
	
	public static MovieFullDTO createFullMovieDTO(Movie movie){
		
		List<CharacterDisneySimpleDTO> charsSimpleDTO= createCharSimpleDTO(movie.getCharacters());
		return new MovieFullDTO(movie.getId(),movie.getTitle(),movie.getImage(),movie.getCreationDate(),movie.getQualification(),charsSimpleDTO);
		
		
	}
	
	public static List<MovieFullDTO> listMoviesFullDTO(List<Movie> movies){
		
		
		moviesFullDTO= movies.stream().map(
				mov -> new MovieFullDTO(mov.getId(), mov.getTitle(),
				mov.getImage(),mov.getCreationDate() , mov.getQualification(),
				createCharSimpleDTO(mov.getCharacters()))).collect(Collectors.toList());
		
		return moviesFullDTO;
	}
	
	private static List<CharacterDisneySimpleDTO> createCharSimpleDTO(List<DisneyCharacter> characters){
		
		return characters.stream().map(ch -> new CharacterDisneySimpleDTO(ch.getName(),ch.getImage())).collect(Collectors.toList());
		
	}
	
	public static List<MovieSimpleDTO> createMoviesSimpleDTO(List<Movie> movies){
		
		List<MovieSimpleDTO> simpleMovieDTO= new ArrayList<MovieSimpleDTO>();
		
		simpleMovieDTO= movies.stream()
				.map( mov -> new MovieSimpleDTO(mov.getTitle(), mov.getImage(), mov.getCreationDate() ))
				.collect(Collectors.toList());
				
		return simpleMovieDTO;
	} 
}
