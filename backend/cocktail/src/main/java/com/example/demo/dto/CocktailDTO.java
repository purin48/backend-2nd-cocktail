package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CocktailDTO {
	private String name;
	private String description;
	private String alchol;
	private String imgLink;
	private int cocktailTypeId;
	
	@Builder
	public CocktailDTO(String name, String description, String alchol, String imgLink, int cocktailTypeId) {
		super();
		this.name = name;
		this.description = description;
		this.alchol = alchol;
		this.imgLink = imgLink;
		this.cocktailTypeId = cocktailTypeId;
	}
}
