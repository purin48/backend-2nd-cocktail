package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Getter

@Table(name = "t_cocktailtype")
public class CocktailType {
	
	@Id
	@Column(name = "ct_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ct_name")
	private String name;
//	
//	@OneToMany(cascade = CascadeType.ALL , mappedBy = "")
//	private List<Cocktail> cocktails = new ArrayList<>();
	
}
