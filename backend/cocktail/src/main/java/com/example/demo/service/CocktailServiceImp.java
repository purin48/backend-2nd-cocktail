package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Cocktail;
import com.example.demo.repository.CocktailRepository;

@Service
public class CocktailServiceImp implements CocktailService{

	private CocktailRepository cocktailRepository;
	
	public CocktailServiceImp(CocktailRepository cocktailRepository) {
		super();
		this.cocktailRepository = cocktailRepository;
	}

	@Override
	public List<Cocktail> findAll() {
		return cocktailRepository.findAll();
	}

	@Override
	public Cocktail findById(int id) {
		return cocktailRepository.findById(id);
	}

	@Override
	public Cocktail save(Cocktail cocktail) {
		return cocktailRepository.save(cocktail);
	}

	@Override
	public void delete(Cocktail cocktail) {
		cocktailRepository.delete(cocktail);
	}
	
}
