package br.com.addario.cadastroveiculo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.addario.cadastroveiculo.model.Veiculo;
import br.com.addario.cadastroveiculo.service.VeiculoService;

@RestController("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService service;

	@GetMapping
	public void cadastraVeiculo(@RequestBody Veiculo veiculo) {
		service.cadastraVeiculo(veiculo);
	}

	@DeleteMapping("/{id}")
	public void removeVeiculo(@RequestParam long id) {
		service.removeVeiculo(id);
	}
}
