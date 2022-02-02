//Terceira
package com.demomvc.curso.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demomvc.curso.boot.domain.Pais;
import com.demomvc.curso.boot.domain.PaisDao;

@Repository
public class PaisDaoImpl extends AbstractDao<Pais, Long> implements PaisDao {

	/*
	 * Não precisa reimplementar os métodos da interface pois eles ja estão
	 * implementados na classe abstrata(AbstractDao), logo esta classe (PaisDaoImpl)
	 * já possui todos devido a herença.
	 */

}