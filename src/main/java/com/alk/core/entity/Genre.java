package com.alk.core.entity;

import java.util.ArrayList;
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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="genre")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id"
		)
public class Genre {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "image")
	private String image;
	
	public Genre(int id){
		this.id=id;
	}
	
	
	@ManyToMany(cascade = {CascadeType.MERGE,  CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinTable(name="genre_movie",
			joinColumns = { @JoinColumn(name="gender_id")},
			inverseJoinColumns = {@JoinColumn(name="movie_id")}, uniqueConstraints = @UniqueConstraint(columnNames = {"movie_id", "gender_id" }) )
	private List<Movie> movies = new ArrayList<Movie>();
	
	
}
