package com.demomvc.curso.boot.web.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToInteger implements Converter<String, Integer> {

	@Override
	public Integer convert(String text) {

		text = text.trim(); // Apaga espaços em branco

		if (text.matches("[0-9]+")) {
			return Integer.valueOf(text); // Type Cast (estudar type Cast)
		}

		return null;
	}

}