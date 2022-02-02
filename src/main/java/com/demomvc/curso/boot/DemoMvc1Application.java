package com.demomvc.curso.boot;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class DemoMvc1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoMvc1Application.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR")); // Configuracao explicita do locate, assim fica sempre
																// para o padrao Brasileiro, fiz isso para nao ocorrer
																// erro no salario
	}

}