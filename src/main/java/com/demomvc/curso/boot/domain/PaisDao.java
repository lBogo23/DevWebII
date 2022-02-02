//Segunda
package com.demomvc.curso.boot.domain;

import java.util.List;

public interface PaisDao {

	void save(Pais pais);

	void update(Pais pais);

	void delete(Long id);

	Pais findById(Long id);

	List<Pais> findAll();

	/*
	 * Os Métodos especificos que não estão na classe abstrata devem ser declaradas
	 * aqui e reimplementados na classe específica que implementa esta interface
	 */

}
