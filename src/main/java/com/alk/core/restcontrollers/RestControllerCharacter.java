package com.alk.core.restcontrollers;

import java.util.ArrayList;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alk.core.converter.ToCharacterDTO;
import com.alk.core.dto.CharacterDisneyFullDTO;
import com.alk.core.dto.CharacterDisneySimpleDTO;
import com.alk.core.entity.DisneyCharacter;
import com.alk.core.entity.Movie;

import com.alk.core.service.CharacterDisneyServiceImpl;

@RestController
@RequestMapping("/api/characters")
public class RestControllerCharacter {

	@Autowired
	private CharacterDisneyServiceImpl serviceCharacter;
	
	@GetMapping()
	public List<CharacterDisneySimpleDTO> readAll(){	
		
		return ToCharacterDTO.createCharactersSimpleDTO(serviceCharacter.findAll());
	}	

	@PostMapping("/add")
	public void addCharacter(@Valid @RequestBody DisneyCharacter character){
		serviceCharacter.addCharacter(character);
	}	
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable String id, DisneyCharacter c){
		serviceCharacter.deleteChar(c);
	}
	
	@PutMapping("/edit/{id}")
	public void update(@PathVariable int id, @RequestBody DisneyCharacter character){
		character.setId(id);
		serviceCharacter.addCharacter(character);
		
	}
	
	
	@GetMapping(params = "name")
	public CharacterDisneyFullDTO findByName(@RequestParam(value = "name") String name){
		
		
		DisneyCharacter character =(DisneyCharacter) serviceCharacter.findByName(name).get();
		
		if (character == null) {
			return null;
		}
		
		
		return ToCharacterDTO.createCharFullDTO(character);
	}
	@GetMapping(params="age")
	public List<CharacterDisneyFullDTO> findByAge(@RequestParam(value="age") int age){
		
		
		return ToCharacterDTO.createCharactersFullDTO(serviceCharacter.findByAge(age));
	}
	
	@GetMapping(params="movie")
	public List<CharacterDisneyFullDTO> findByIdMovie(@RequestParam(value="movie") int idMovie){
		
		List<Movie> movies= new ArrayList<Movie>();
		movies.add(new Movie(idMovie));
		List<CharacterDisneyFullDTO> charactersDTO=ToCharacterDTO.createCharactersFullDTO(serviceCharacter.findByMovies(movies));
		
		return charactersDTO;
	}
	

	
}
