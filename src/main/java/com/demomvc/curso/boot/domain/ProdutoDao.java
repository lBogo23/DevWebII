package com.demomvc.curso.boot.domain;

import java.util.List;

public interface ProdutoDao {

	void save(Produto produto);

	void update(Produto produto);

	void delete(Long id);

	Produto findById(Long id);

	List<Produto> findAll();

	/*
	 * Os Métodos especificos que não estão na classe abstrata devem ser declaradas
	 * aqui e reimplementados na classe específica que implementa esta interface
	 */

}


