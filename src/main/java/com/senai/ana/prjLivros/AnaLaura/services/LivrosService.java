package com.senai.ana.prjLivros.AnaLaura.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.ana.prjLivros.AnaLaura.entities.Livros;
import com.senai.ana.prjLivros.AnaLaura.repositories.LivrosRepository;

@Service
public class LivrosService {
	
	private final LivrosRepository livrosRepository;
	
	@Autowired
	public LivrosService (LivrosRepository livrosRepository) {
		this.livrosRepository = livrosRepository;
	}
	public Livros saveLivros(Livros livros) {
		return livrosRepository.save(livros);
	}
	public Livros getLivros(Long idcLivros) {
		return livrosRepository.findById(idcLivros).orElse(null);
	}
	public List<Livros> getAllProdutos() {
		return livrosRepository.findAll();
	}
	public void deleteLivros(Long idcLivros) {
		livrosRepository.deleteById(idcLivros);
	}
	public List<Livros> getAllLivros() {
		return null;
	}
	public Livros getLivrosById(Long idcLivros) {
		return null;
	}

}
