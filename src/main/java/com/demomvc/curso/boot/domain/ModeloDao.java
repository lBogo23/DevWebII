package com.demomvc.curso.boot.domain;

import java.util.List;

public interface ModeloDao {

	void save(Modelo modelo);

	void update(Modelo modelo);

	void delete(Long id);

	Modelo findById(Long id);

	List<Modelo> findAll();
	
	List<Modelo> findByNome(String nome);
	
	List<Modelo> findByDescricao(String descricao);
	

	/*
	 * Os Métodos especificos que não estão na classe abstrata devem ser declaradas
	 * aqui e reimplementados na classe específica que implementa esta interface
	 */

}
