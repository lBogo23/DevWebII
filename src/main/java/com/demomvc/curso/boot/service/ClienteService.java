package com.demomvc.curso.boot.service;


import java.util.List;


import com.demomvc.curso.boot.domain.Cliente;


public interface ClienteService {

	void salvar(Cliente cliente);

	void editar(Cliente cliente);

	void excluir(Long id);

	Cliente buscarPorId(Long id);

	List<Cliente> buscarTodos();

	List<Cliente> buscarPorNome(String nome);


}
