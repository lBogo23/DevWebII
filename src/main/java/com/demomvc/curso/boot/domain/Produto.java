package com.demomvc.curso.boot.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;

@SuppressWarnings("serial")
@Entity
@Table(name = "PRODUTOS")
public class Produto extends AbstractEntity<Long> {

	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome; // Declaração de atributo

	@Valid
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "marca_id_fk")
	private Marca marca;
	
	@Valid
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "modelo_id_fk")
	private Modelo modelo;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
	

