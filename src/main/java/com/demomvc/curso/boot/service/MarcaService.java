package com.demomvc.curso.boot.service;

import java.util.List;

import com.demomvc.curso.boot.domain.Marca;

public interface MarcaService {

	void salvar(Marca marca);

	void editar(Marca marca);

	void excluir(Long id);

	Marca buscarPorId(Long id);

	List<Marca> buscarTodos();

}
