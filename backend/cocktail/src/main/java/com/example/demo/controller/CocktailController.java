package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CocktailDTO;
import com.example.demo.model.Cocktail;
import com.example.demo.model.CocktailType;
import com.example.demo.service.CocktailService;
import com.example.demo.service.CocktailTypeService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/cocktail")
@RestController
public class CocktailController {
	private final CocktailService cocktailService;
	private final CocktailTypeService cocktailTypeService;
	
	public CocktailController(CocktailService cocktailService, CocktailTypeService cocktailTypeService) {
		this.cocktailService = cocktailService;
		this.cocktailTypeService = cocktailTypeService;
	}
	
//	List<CocktailType> cts = cocktailTypeService.findAll();

	// 술 리스트 표출
	@GetMapping
	public List<Cocktail> listCocktails() {
		List<Cocktail> cocktails = cocktailService.findAll();
		return cocktails;
	}

	// 술 디테일 표출
	@GetMapping("/{id}")
	public Cocktail showDetail(@PathVariable("id") int id) {
		Cocktail cocktail = cocktailService.findById(id);
		return cocktail;
	}

	// 수정 화면 표출
	@GetMapping("/{id}/edit")
	public Cocktail showEdit(@PathVariable("id") int id) {
		Cocktail cocktail = cocktailService.findById(id);

		return cocktail;
	}

	// 수정 제출 버튼시
	@PostMapping("/{id}/edit")
	public Cocktail submitEdit(@PathVariable("id") int id, @RequestBody Cocktail editCocktail) {
		editCocktail.setId(id);
		Cocktail updatedCocktail = cocktailService.save(editCocktail);
		return updatedCocktail;
	}
	
	// 추가화면의 타입보여주기
	@GetMapping("/add")
	public List<CocktailType> getAddCocktailType() {
		List<CocktailType> cts = cocktailTypeService.findAll();
		return cts;
	}
	

	
	@PostMapping("/add")
	public Cocktail addCocktail(@RequestBody CocktailDTO cockDto) {
		
		CocktailType cocktailType = cocktailTypeService.findById(cockDto.getCocktailTypeId());
		
		Cocktail newCocktail = Cocktail.builder()
				.name(cockDto.getName())
				.description(cockDto.getDescription())
				.alchol(cockDto.getAlchol())
				.imgLink(cockDto.getImgLink())
				.cocktailType(cocktailType)
				.build();
				
		Cocktail savedCocktail = cocktailService.save(newCocktail);
		
		return savedCocktail;
	}
	
	

	// 삭제 버튼시
	@DeleteMapping("/{id}/delete")
	void deleteCocktail(@PathVariable int id) {
		Cocktail cocktail = cocktailService.findById(id);
		cocktailService.delete(cocktail);
	}
}
