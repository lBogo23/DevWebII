package com.demomvc.curso.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demomvc.curso.boot.domain.Marca;
import com.demomvc.curso.boot.domain.Produto;
import com.demomvc.curso.boot.domain.ProdutoDao;

@Repository
public class ProdutoDaoImpl extends AbstractDao<Produto, Long> implements ProdutoDao {

}