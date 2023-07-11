package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Cocktail;

public interface CocktailService {
	// 전체 칵테일 조회
		List<Cocktail> findAll();
		
		// 특정 칵테일 상세조회
		Cocktail findById(int id);
		
		// 칵테일 저장
		Cocktail save(Cocktail cocktail);
		
		// 칵테일 삭제
		void delete(Cocktail cocktail);
}
