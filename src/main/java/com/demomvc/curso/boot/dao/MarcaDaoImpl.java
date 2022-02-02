//Terceira
package com.demomvc.curso.boot.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.demomvc.curso.boot.domain.Marca;
import com.demomvc.curso.boot.domain.MarcaDao;


@Repository
public class MarcaDaoImpl extends AbstractDao<Marca, Long> implements MarcaDao {

}
