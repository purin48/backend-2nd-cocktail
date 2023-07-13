package com.example.demo.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Cocktail;
import com.example.demo.service.CocktailService;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/cocktail")
@RestController
public class CocktailController {
	private final CocktailService cocktailService;

	public CocktailController(CocktailService cocktailService) {
		super();
		this.cocktailService = cocktailService;
	}

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

	// 추가 버튼시
	@PostMapping("/add")
	public Cocktail addCocktail(@RequestBody Cocktail addCocktail) {
		Cocktail addCocktatil = cocktailService.save(addCocktail);

		return addCocktatil;
	}

	// 삭제 버트시
	@DeleteMapping("/{id}/delete")
	void deleteCocktail(@PathVariable int id) {
		Cocktail cocktail = cocktailService.findById(id);
		cocktailService.delete(cocktail);
	}
}
