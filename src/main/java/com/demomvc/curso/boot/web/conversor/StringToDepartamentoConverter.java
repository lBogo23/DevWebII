package com.demomvc.curso.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.demomvc.curso.boot.domain.Departamento;
import com.demomvc.curso.boot.service.DepartamentoService;

//Esta classe é usada no combobox de cargo a fim de recuperar o departamento por meio da id
@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

	@Autowired
	private DepartamentoService service;

	public Departamento convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id); // Recebe o id convertido de texto para numero e retorna o objeto referente ao
										// id
	}
}
