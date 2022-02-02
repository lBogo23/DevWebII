//Quinta
package com.demomvc.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demomvc.curso.boot.domain.Pais;
import com.demomvc.curso.boot.domain.PaisDao;

@Service
public class PaisServiceImpl implements PaisService {

	@Autowired // Injeção de dependencia.
	private PaisDao dao;

	@Transactional(readOnly = false) // Não é apenas para leitura pois faz alteração na base dados.
	@Override
	public void salvar(Pais pais) {
		dao.save(pais);
	}

	@Transactional(readOnly = false) // Não é apenas para leitura pois faz alteração na base dados.
	@Override
	public void editar(Pais pais) {
		dao.update(pais);

	}

	@Transactional(readOnly = false) // Não é apenas para leitura pois faz alteração na base dados.
	@Override
	public void excluir(Long id) {
		dao.delete(id);

	}

	@Transactional(readOnly = true) // Apenas para leitura.
	@Override
	public Pais buscarPorId(Long id) { // Método que busca pelo código.

		return dao.findById(id);
	}

	@Transactional(readOnly = true) // Apenas para leitura.
	@Override
	public List<Pais> buscarTodos() { // Método que busca todos

		return dao.findAll();
	}

}
