package com.alk.core.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.alk.core.dto.CharacterDisneyFullDTO;
import com.alk.core.dto.CharacterDisneySimpleDTO;
import com.alk.core.dto.MovieSimpleDTO;
import com.alk.core.entity.DisneyCharacter;
import com.alk.core.entity.Movie;

public class ToCharacterDTO {

	private static int id;
	private static String name;
	private static String story;
	private static int age;
	private static double weight;
	private static String image;
	private static List<MovieSimpleDTO> moviesDTO;
	
	
	public static List<CharacterDisneyFullDTO> createCharactersFullDTO(List<DisneyCharacter> characters) {

		List<CharacterDisneyFullDTO> chars = new ArrayList<CharacterDisneyFullDTO>();
		
		CharacterDisneyFullDTO c;
		for (DisneyCharacter dc : characters) {
			id = dc.getId();
			name = dc.getName();
			story = dc.getStory();
			age = dc.getAge();
			weight = dc.getWeight();
			image = dc.getImage();
			moviesDTO= new ArrayList<MovieSimpleDTO>();
			moviesDTO= movieToMovieDTO(dc.getMovies());
			c = new CharacterDisneyFullDTO(id, name, image, age, weight, story,moviesDTO);
			chars.add(c);
		}

		return chars;

	}
	
	private static List<MovieSimpleDTO> movieToMovieDTO(List<Movie> movies){
		
		List<MovieSimpleDTO> moviesDTO= new ArrayList<MovieSimpleDTO>();
		for (Movie m : movies) {
			moviesDTO.add(new MovieSimpleDTO(m.getTitle(),m.getImage(),m.getCreationDate()));
		}
		return moviesDTO;
	}
	

	public static CharacterDisneyFullDTO createCharFullDTO(DisneyCharacter dc) {

		name = dc.getName();
		image = dc.getImage();
		story = dc.getStory();
		age = dc.getAge();
		weight = dc.getWeight();
		id = dc.getId();
		moviesDTO= movieToMovieDTO(dc.getMovies());

		return new CharacterDisneyFullDTO(id, name, image, age, weight, story,moviesDTO);

	}
	
	
	public static List<CharacterDisneySimpleDTO> createCharactersSimpleDTO(List<DisneyCharacter> characters) {

		List<CharacterDisneySimpleDTO> charsSimpleDTO = new ArrayList<CharacterDisneySimpleDTO>();
		
		charsSimpleDTO = characters.stream()
				.map( c ->
				new  CharacterDisneySimpleDTO(c.getName(),c.getImage())
				)
				.collect(Collectors.toList());

		return charsSimpleDTO;

	}
	
	
	public static CharacterDisneySimpleDTO charSimpleDTO(DisneyCharacter character){
		
		name= character.getName();
		image= character.getImage();
		
		return new CharacterDisneySimpleDTO(name,image);
		
		
	}
}
