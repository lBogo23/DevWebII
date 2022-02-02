package com.demomvc.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demomvc.curso.boot.domain.Marca;
import com.demomvc.curso.boot.domain.MarcaDao;


@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired // Injeção de dependencia.
	private MarcaDao dao;

	@Transactional(readOnly = false) // Não é apenas para leitura pois faz alteração na base dados.
	@Override
	public void salvar(Marca marca) {
		dao.save(marca);
	}

	@Transactional(readOnly = false) // Não é apenas para leitura pois faz alteração na base dados.
	@Override
	public void editar(Marca marca) {
		dao.update(marca);

	}

	@Transactional(readOnly = false) // Não é apenas para leitura pois faz alteração na base dados.
	@Override
	public void excluir(Long id) {
		dao.delete(id);

	}

	@Transactional(readOnly = true) // Apenas para leitura.
	@Override
	public Marca buscarPorId(Long id) { // Método que busca pelo código.

		return dao.findById(id);
	}

	@Transactional(readOnly = true) // Apenas para leitura.
	@Override
	public List<Marca> buscarTodos() { // Método que busca todos

		return dao.findAll();
	}

}
