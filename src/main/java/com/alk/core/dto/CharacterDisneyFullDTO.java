package com.alk.core.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDisneyFullDTO {

	private int id;
	private String name;
	private String image;
	private int age;
	private double weight;
	private String story;
	
	List<MovieSimpleDTO> movies;
	
}
