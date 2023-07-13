package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cocktail;

@Repository
public interface CocktailRepository extends CrudRepository<Cocktail, Integer>{
	
	// 전체 칵테일 조회
	List<Cocktail> findAll();
	
	// 특정 칵테일 상세조회
	Cocktail findById(int id);
	
	// 칵테일 저장
	Cocktail save(Cocktail cocktail);
	
//	
//	//칵테일 타입 id만 저장
//	void saveTypeID(Cocktail cocktail);
	
	// 칵테일 삭제
	void delete(Cocktail cocktail);
}
