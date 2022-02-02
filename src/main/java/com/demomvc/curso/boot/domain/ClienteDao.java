package com.demomvc.curso.boot.domain;

import java.util.List;

public interface ClienteDao {

	void save(Cliente cliente);

	void update(Cliente cliente);

	void delete(Long id);

	Cliente findById(Long id);

	List<Cliente> findAll();

	/*
	 * Os Métodos especificos que não estão na classe abstrata devem ser declaradas
	 * aqui e reimplementados na classe específica que implementa esta interface
	 */

}
