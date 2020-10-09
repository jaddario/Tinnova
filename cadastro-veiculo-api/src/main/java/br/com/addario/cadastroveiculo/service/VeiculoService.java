package br.com.addario.cadastroveiculo.service;

import br.com.addario.cadastroveiculo.model.Veiculo;

public interface VeiculoService {
	public void cadastraVeiculo(Veiculo veiculo);
	
	public void removeVeiculo(long id);
	
}
