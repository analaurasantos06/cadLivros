package com.senai.ana.prjLivros.AnaLaura.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.ana.prjLivros.AnaLaura.entities.Livros;
import com.senai.ana.prjLivros.AnaLaura.services.LivrosService;


@RestController
@RequestMapping("/livros")
public class LivrosController {
	
	
	 private final LivrosService livrosService;
	 
	 @Autowired
	 public LivrosController (LivrosService livrosService) {
		 this.livrosService = livrosService;
	 }
	 @PostMapping
	 public Livros createLivros (@RequestBody Livros livros ) {
		 return livrosService.saveLivros(livros);
	 }
	 @GetMapping 
	 public List<Livros> getAllLivros() {
		 return livrosService.getAllLivros();
	 }
	 @GetMapping ("/{id}")
	 public Livros getLivros(@PathVariable Long id) {
	   return livrosService.getLivrosById(id); 
	}
	 @DeleteMapping
	 public void deleteLivros(@PathVariable Long id) {
		 livrosService.deleteLivros(id);
	 }
	}


