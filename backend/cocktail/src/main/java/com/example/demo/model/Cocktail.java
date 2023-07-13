package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "t_cocktail")
@JsonAutoDetect
@NoArgsConstructor
public class Cocktail{

	@Id
	@Column(name = "c_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "c_name")
	private String name;

	@Column(name = "c_desc")
	private String description;

	@Column(name = "c_al")
	private String alchol;

	@Column(name = "c_link")
	private String imgLink;

	@ManyToOne
	@JoinColumn(name = "c_type")
	private CocktailType cocktailType;
	
	

	@Override
	public String toString() {
		return "Cocktail [id=" + id + ", name=" + name + ", description=" + description + ", alchol=" + alchol
				+ ", imgLink=" + imgLink + ", cocktailType=" + cocktailType + "]";
	}


	@Builder
	public Cocktail(int id, String name, String description, String alchol, String imgLink, CocktailType cocktailType) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.alchol = alchol;
		this.imgLink = imgLink;
		this.cocktailType = cocktailType;
	}

}
