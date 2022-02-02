package com.demomvc.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demomvc.curso.boot.domain.Produto;
import com.demomvc.curso.boot.domain.ProdutoDao;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired // Injeção de dependencia.
	private ProdutoDao dao;

	@Transactional(readOnly = false) // Não é apenas para leitura pois faz alteração na base dados.
	@Override
	public void salvar(Produto produto) {
		dao.save(produto);
	}

	@Transactional(readOnly = false) // Não é apenas para leitura pois faz alteração na base dados.
	@Override
	public void editar(Produto produto) {
		dao.update(produto);

	}

	@Transactional(readOnly = false) // Não é apenas para leitura pois faz alteração na base dados.
	@Override
	public void excluir(Long id) {
		dao.delete(id);

	}

	@Transactional(readOnly = true) // Apenas para leitura.
	@Override
	public Produto buscarPorId(Long id) { // Método que busca pelo código.

		return dao.findById(id);
	}

	@Transactional(readOnly = true) // Apenas para leitura.
	@Override
	public List<Produto> buscarTodos() { // Método que busca todos

		return dao.findAll();
	}

	@Override
	public void save(Produto produto) {
		dao.save(produto);

	}

	@Override
	public void update(Produto produto) {
		dao.update(produto);

	}

	@Override
	public void delete(Long id) {
		dao.delete(id);

	}

	@Override
	public Produto findById(Long id) {
		
		return dao.findById(id);
		
	}

	@Override
	public List<Produto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
