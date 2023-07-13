package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CocktailType;

public interface CocktailTypeService {
	// 전체 칵테일 조회
	List<CocktailType> findAll();
	
	CocktailType findById(int id);

}
