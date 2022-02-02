//Quarta
package com.demomvc.curso.boot.service;

import java.util.List;

import com.demomvc.curso.boot.domain.Pais;

public interface PaisService {

	void salvar(Pais pais);

	void editar(Pais pais);

	void excluir(Long id);

	Pais buscarPorId(Long id);

	List<Pais> buscarTodos();

}
