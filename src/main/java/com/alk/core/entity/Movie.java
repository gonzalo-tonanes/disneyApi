package com.alk.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "movie")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id"
		)
public class Movie implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "required field")
	@Column(name="title")
	private String title;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="qualification")
	private int qualification;
	
	@Column(name="image")
	private String image; 
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="movie_character",
		joinColumns = @JoinColumn(name="id_movie"),
		inverseJoinColumns = @JoinColumn(name="id_character"))
	private List<DisneyCharacter> characters;
	
	
	@ManyToMany(mappedBy = "movies")
	private List<Genre> genre = new ArrayList<Genre>();
	
	public Movie() {}
	
	public Movie(int id) {
		this.id=id;
	}
	public Movie(String title, Date creationDate, int qualification,String image) {
		this.title = title;
		this.creationDate = creationDate;
		this.qualification = qualification;
		this.image = image;
	}
	
	
	
	public void addCharacter(DisneyCharacter c){
		this.characters.add(c);
	}
	
	public int getId() {
		return id;
	}
	
	
	public List<DisneyCharacter> getCharacters() {
		return characters;
	}

	public void setCharacters(List<DisneyCharacter> characters) {
		this.characters = characters;
	}
	
	@JsonIgnore	
	public List<Genre>  getGenre(){
		return this.genre;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getQualification() {
		return qualification;
	}

	public void setQualification(int qualification) {
		this.qualification = qualification;
	}

	

	

}
	
	
	
	
	

