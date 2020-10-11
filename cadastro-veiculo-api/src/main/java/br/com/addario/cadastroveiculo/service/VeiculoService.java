package br.com.addario.cadastroveiculo.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.addario.cadastroveiculo.model.Veiculo;

@Service
public interface VeiculoService {

	public void cadastraVeiculo(Veiculo veiculo);

	public void removeVeiculo(long id);

	public void atualizaVeiculo(long id, Veiculo veiculo);

	public Long getVeiculosNaoVendidos();

	public Long getVeiculosPorDecadaDeFabricacao(int decada);

	public Long getVeiculosPorFabricante(String fabricante);

	public List<Veiculo> getVeiculosRegistradosDuranteAUltimaSemana(Date primeiroDiaDaSemanaPassada);

	public List<Veiculo> getTodosOsVeiculos();

}
