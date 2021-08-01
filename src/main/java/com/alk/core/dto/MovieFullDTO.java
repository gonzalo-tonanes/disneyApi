package com.alk.core.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieFullDTO {

	private int id;
	private String title;
	private String image;
	private Date date;
	private int qualification;
	private List<CharacterDisneySimpleDTO> characters;
	
	
	
	
}
