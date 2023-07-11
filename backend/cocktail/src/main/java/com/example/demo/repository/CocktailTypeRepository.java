package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cocktail;
import com.example.demo.model.CocktailType;

@Repository
public interface CocktailTypeRepository extends CrudRepository<CocktailType, Integer>{
	
	// 전체 칵테일 조회
	List<CocktailType> findAll();
}
