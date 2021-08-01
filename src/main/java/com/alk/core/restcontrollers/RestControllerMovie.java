package com.alk.core.restcontrollers;


import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alk.core.converter.ToMovieDTO;
import com.alk.core.dto.MovieSimpleDTO;
import com.alk.core.dto.MovieFullDTO;
import com.alk.core.entity.DisneyCharacter;
import com.alk.core.entity.Genre;
import com.alk.core.entity.Movie;
import com.alk.core.service.MovieServiceImpl;

@RestController
@RequestMapping("/api/movies")
public class RestControllerMovie {

	
	@Autowired
	private MovieServiceImpl service;
	
	@GetMapping()
	public List<MovieSimpleDTO> getAll(){
		List<Movie> movies= service.findAll();
	
		return ToMovieDTO.createMoviesSimpleDTO(movies);
	}
	

	
	@GetMapping(params = "name")
	public MovieFullDTO findByName(@RequestParam(name="name") String name){
		Movie movie=(Movie) service.findByName(name).get();
		return ToMovieDTO.createFullMovieDTO(movie);
	}
	
	@GetMapping(params = "genre")
	public List<MovieFullDTO> findByGenre(@RequestParam(name="genre") int idGenre){
		
		List<Genre> genres= new ArrayList<Genre>();
		genres.add(new Genre(idGenre));
		
		return ToMovieDTO.listMoviesFullDTO(service.findByGenre(genres));
		
	}
	
	@GetMapping(params = "order")
	public List<MovieFullDTO> findByGenre(@RequestParam(name="order") String order){
		
		List<Movie> movies= new ArrayList<Movie>();
		
		if (order.equals("desc")) {
			movies= service.findByNameDesc();
		}
		if (order.equals("asc")) {
			movies= service.findByNameAsc();
		}
		return ToMovieDTO.listMoviesFullDTO(movies);
	}
	
	
	
	@PostMapping("/movie")
	public void addMovie(@RequestBody Movie movie, DisneyCharacter disney){
		service.addMovie(movie);
	}
	
	@PutMapping("/movie/{id}")
	public void update(@RequestBody Movie movie, @PathVariable(value = "id") Integer id){
		
		service.addMovie(movie);
		
	}
	

	
}
