package com.demomvc.curso.boot.service;

import java.util.List;

import com.demomvc.curso.boot.domain.Produto;
import com.demomvc.curso.boot.domain.ProdutoDao;

public interface ProdutoService extends ProdutoDao {

	void salvar(Produto produto);

	void editar(Produto produto);

	void excluir(Long id);

	Produto buscarPorId(Long id);

	List<Produto> buscarTodos();

}
