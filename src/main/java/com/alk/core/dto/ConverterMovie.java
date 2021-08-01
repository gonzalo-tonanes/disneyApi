package com.alk.core.dto;

import com.alk.core.entity.Movie;


public class ConverterMovie {

	public ConverterMovie() {
	
	}

	public static MovieFullDTO toMovieDTO(Movie m){

		
		return new MovieFullDTO(m.getId(),m.getTitle(),m.getImage(),m.getCreationDate(),m.getQualification(),null);
	}
	
	
}
