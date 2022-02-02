package com.demomvc.curso.boot.dao;


import org.springframework.stereotype.Repository;

import com.demomvc.curso.boot.domain.Cliente;
import com.demomvc.curso.boot.domain.ClienteDao;

@Repository
public class ClienteDaoImpl extends AbstractDao<Cliente, Long> implements ClienteDao  {

}
