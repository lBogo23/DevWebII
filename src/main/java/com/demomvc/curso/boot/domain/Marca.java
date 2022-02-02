package com.demomvc.curso.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "MARCAS") // Anotação JPA para criar a tabela no banco de dados
public class Marca extends AbstractEntity<Long> { // Declaração da classe Pais herdando de AbstractEntity

	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome; // Declaração de atributo

	public String getNome() { // Retorna o valor
		return nome;
	}

	public void setNome(String nome) { // Inclui o valor
		this.nome = nome; // O atributo nome dessa classe (marca) recebe o nome passado por parÃ¢metro
	}

}