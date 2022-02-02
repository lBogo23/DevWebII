package com.demomvc.curso.boot.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demomvc.curso.boot.domain.Cliente;
import com.demomvc.curso.boot.domain.ClienteDao;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired // Injeção de dependencia.
	private ClienteDao dao;

	@Transactional(readOnly = false) // Não é apenas para leitura pois faz alteração na base dados.
	@Override
	public void salvar(Cliente cliente) {
		dao.save(cliente);
	}

	@Transactional(readOnly = false) // Não é apenas para leitura pois faz alteração na base dados.
	@Override
	public void editar(Cliente cliente) {
		dao.update(cliente);

	}

	@Transactional(readOnly = false) // Não é apenas para leitura pois faz alteração na base dados.
	@Override
	public void excluir(Long id) {
		dao.delete(id);

	}

	@Transactional(readOnly = true) // Apenas para leitura.
	@Override
	public Cliente buscarPorId(Long id) { // Método que busca pelo código.

		return dao.findById(id);
	}

	@Transactional(readOnly = true) // Apenas para leitura.
	@Override
	public List<Cliente> buscarTodos() { // Método que busca todos

		return dao.findAll();
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
