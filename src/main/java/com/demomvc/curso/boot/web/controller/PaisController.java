//sexta
package com.demomvc.curso.boot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demomvc.curso.boot.domain.Departamento;
import com.demomvc.curso.boot.domain.Pais;
import com.demomvc.curso.boot.service.PaisService;

@Controller
@RequestMapping("/paises") // Mapeia URL padrÃ£o
public class PaisController {

	@Autowired // InjeÃ§Ã£o de dependÃªncia
	private PaisService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Pais pais) {
		return "/pais/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Pais pais, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "pais/cadastro";
		}

		service.salvar(pais);
		// Mensagem adicionada para exibir o resultado da transaÃ§Ã£o cadastrar
		attr.addFlashAttribute("success", "PaÃ­s " + pais.getNome() + " inserido com sucesso.");
		return "redirect:/paises/cadastrar";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("paises", service.buscarTodos());
		return "/pais/lista";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pais", service.buscarPorId(id));
		return "/pais/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Pais pais, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "pais/cadastro";
		}

		service.editar(pais);
		// Mensagem adicionada para exibir o resultado da transaÃ§Ã£o editar
		attr.addFlashAttribute("success", "Pais " + pais.getNome() + " editado com sucesso.");
		return "redirect:/paises/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		// Mensagem adicionada para exibir o resultado da transaÃ§Ã£o excluir
		model.addAttribute("success", "Pais removido com sucesso.");
		return listar(model);
	}
}
