package com.demomvc.curso.boot.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "CLIENTES")
public class Cliente extends AbstractEntity<Long> {

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false, unique = false)
	private String nome;
	
	@NotBlank
	@Size(min=10, max=50)
	@Column(nullable = false, unique = true, name = "telefone")
	private String telefone;
	
	@NotBlank(message = "{NotBlank.cliente.email}")
	@Email(message = "{Pattern.cliente.email}")  
	@Size(min=10, max=50)
	@Column(nullable = false, unique = true, name = "email")
	private String email;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
