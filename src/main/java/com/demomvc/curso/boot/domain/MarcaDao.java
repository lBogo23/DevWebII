package com.demomvc.curso.boot.domain;

import java.util.List;

public interface MarcaDao {

	void save(Marca marca);

	void update(Marca marca);

	void delete(Long id);

	Marca findById(Long id);

	List<Marca> findAll();

	/*
	 * Os Métodos especificos que não estão na classe abstrata devem ser declaradas
	 * aqui e reimplementados na classe específica que implementa esta interface
	 */

}
