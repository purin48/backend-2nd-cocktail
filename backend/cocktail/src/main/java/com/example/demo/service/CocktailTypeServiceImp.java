package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.CocktailType;
import com.example.demo.repository.CocktailTypeRepository;
@Service
public class CocktailTypeServiceImp implements CocktailTypeService{

	private CocktailTypeRepository cocktailTypeRepository;
	
	public CocktailTypeServiceImp(CocktailTypeRepository cocktailTypeRepository) {
		super();
		this.cocktailTypeRepository = cocktailTypeRepository;
	}

	@Override
	public List<CocktailType> findAll() {
		return cocktailTypeRepository.findAll();
	}

	@Override
	public CocktailType findById(int id) {
		return cocktailTypeRepository.findById(id).orElse(null);
	}

}
