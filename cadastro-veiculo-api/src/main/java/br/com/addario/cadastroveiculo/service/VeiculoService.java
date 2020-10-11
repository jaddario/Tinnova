package br.com.addario.cadastroveiculo.service;

import java.util.List;

import br.com.addario.cadastroveiculo.model.Veiculo;

public interface VeiculoService {
	public void cadastraVeiculo(Veiculo veiculo);
	
	public void removeVeiculo(long id);
	
	public void atualizaVeiculo(long id, Veiculo veiculo);
	
	public int getVeiculosNaoVendidos();
	
	public int getVeiculosPorDecadaDeFabricacao(int decada);
	
	public int getVeiculosPorFabricante(String fabricante);
	
	public List<Veiculo> getVeiculosRegistradosDuranteAUltimaSemana();
	
}
