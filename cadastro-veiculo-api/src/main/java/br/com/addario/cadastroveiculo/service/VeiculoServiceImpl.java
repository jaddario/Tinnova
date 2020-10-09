package br.com.addario.cadastroveiculo.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.addario.cadastroveiculo.model.Veiculo;
import br.com.addario.cadastroveiculo.repository.VeiculoRepository;

public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	@Override
	public void cadastraVeiculo(Veiculo veiculo) {
		repository.save(veiculo);

	}

	@Override
	public void removeVeiculo(long id) {
		repository.deleteById(id);

	}

}
