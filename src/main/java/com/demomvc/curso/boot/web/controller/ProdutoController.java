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

import com.demomvc.curso.boot.domain.Produto;
import com.demomvc.curso.boot.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired // Injeção de dependencia
	private ProdutoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Produto produto) {
		return "/produto/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Produto produto, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "produto/cadastro";
		}

		service.salvar(produto);
		// Mensagem adicionada para exibir o resultado da transaÃ§Ã£o cadastrar
		attr.addFlashAttribute("success", "Produto " + produto.getNome() + " inserido com sucesso.");
		return "redirect:/produtos/cadastrar";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("produtos", service.buscarTodos());
		return "/produto/lista";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("produto", service.buscarPorId(id));
		return "/produto/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Produto produto, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "produto/cadastro";
		}

		service.editar(produto);
		// Mensagem adicionada para exibir o resultado da transação editar
		attr.addFlashAttribute("success", "Produto " + produto.getNome() + " editado com sucesso.");
		return "redirect:/produtos/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		// Mensagem adicionada para exibir o resultado da transaçãoo excluir
		model.addAttribute("success", "Produto removido com sucesso.");
		return listar(model);
	}
}

