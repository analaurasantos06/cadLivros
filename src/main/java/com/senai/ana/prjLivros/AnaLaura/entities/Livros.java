package com.senai.ana.prjLivros.AnaLaura.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_Livros") 
public class Livros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;
	
	private String isdn;
	


public void setId(Long id) {
	this.id = id;
}
public String getDescricao()	{
	return descricao;
}
public String setDescricao(String descricao) {
	return descricao;
}
	
	public String getIsdn() {
		return isdn;
	}
	public void setIsdn(String isdn) {
		this.isdn = isdn;
	
}
}
	



 




