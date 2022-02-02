package com.demomvc.curso.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demomvc.curso.boot.domain.ModeloDao;
import com.demomvc.curso.boot.domain.Modelo;

@Repository
public class ModeloDaoImpl extends AbstractDao<Modelo, Long> implements ModeloDao {

	@Override
	public List<Modelo> findByNome(String nome) {
		// TODO Auto-generated method stub
		return createQuery("select m from Modelo m where m.nome like concat('%',?1,'%') ", nome);
	}

	@Override
	public List<Modelo> findByDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}

}
