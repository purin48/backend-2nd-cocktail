package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;

@Entity
@Getter

@Table(name = "t_cocktailtype")
@JsonAutoDetect
public class CocktailType {
	
	@Id
	@Column(name = "ct_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ct_name")
	private String name;

	
}
