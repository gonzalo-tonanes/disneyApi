package com.alk.core.entity;


import java.io.Serializable;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="characters_disney")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id"
		)
public class DisneyCharacter  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "required field")
	@Column(name="name")
	private String name;
	@Column(name="age")
	private int age;
	@Column(name="weight")
	private double weight;
	@Column(name="story")
	private String story;
	@Column(name="image")
	private String image;
	
	
	
	@ManyToMany(mappedBy = "characters")
	private List<Movie> movies;
	
	
	public List<Movie> getMovies() {
		return movies;
	}

	
	
	
	
}
