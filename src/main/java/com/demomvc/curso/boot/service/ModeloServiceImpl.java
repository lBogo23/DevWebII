package com.demomvc.curso.boot.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.demomvc.curso.boot.domain.Modelo;
import com.demomvc.curso.boot.domain.ModeloDao;

@Service
public class ModeloServiceImpl implements ModeloService {

	@Autowired // Injeção de dependencia.
	private ModeloDao dao;

	@Transactional(readOnly = false) // Não é apenas para leitura pois faz alteração na base dados.
	@Override
	public void salvar(Modelo modelo) {
		dao.save(modelo);
	}

	@Transactional(readOnly = false) // Não é apenas para leitura pois faz alteração na base dados.
	@Override
	public void editar(Modelo modelo) {
		dao.update(modelo);

	}

	@Transactional(readOnly = false) // Não é apenas para leitura pois faz alteração na base dados.
	@Override
	public void excluir(Long id) {
		dao.delete(id);

	}

	@Transactional(readOnly = true) // Apenas para leitura.
	@Override
	public Modelo buscarPorId(Long id) { // Método que busca pelo código.

		return dao.findById(id);
	}

	@Transactional(readOnly = true) // Apenas para leitura.
	@Override
	public List<Modelo> buscarTodos() { // Método que busca todos

		return dao.findAll();
	}

	
}
