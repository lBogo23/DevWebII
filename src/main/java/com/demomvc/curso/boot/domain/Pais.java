//Primeira
package com.demomvc.curso.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "PAISES") // AnotaÃ§Ã£o JPA para criar a tabela no banco de dados
public class Pais extends AbstractEntity<Long> { // DeclaraÃ§Ã£o da classe Pais herdando de AbstractEntity

	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome; // DeclaraÃ§Ã£o de atributo

	public String getNome() { // Retorna o valor
		return nome;
	}

	public void setNome(String nome) { // Inclui o valor
		this.nome = nome; // O atributo nome dessa classe (Pais) recebe o nome passado por parÃ¢metro
	}

}