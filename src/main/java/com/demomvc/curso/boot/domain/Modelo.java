package com.demomvc.curso.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "MODELOS")
public class Modelo extends AbstractEntity<Long>{

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome; // Declaração de atributo

	public String getNome() { // Retorna o valor
		return nome;
	}

	public void setNome(String nome) { // Inclui o valor
		this.nome = nome; // O atributo nome dessa classe (modelo) recebe o nome passado por parÃ¢metro
	}
	
	@Column(name = "descricao", nullable = false, unique = true, length = 500)
	private String descricao; // Declaração de atributo

	public String getDescricao() { // Retorna o valor
		return descricao;
	}

	public void setDescricao(String descricao) { // Inclui o valor
		this.descricao = descricao; // O atributo nome dessa classe (modelo) recebe o nome passado por parÃ¢metro
	}

}
	

