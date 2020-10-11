package br.com.addario.cadastroveiculo.service;

import java.util.List;

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

	@Override
	public void atualizaVeiculo(long id, Veiculo veiculo) {
		repository.updateVeiculo(id, veiculo);
	}

	@Override
	public int getVeiculosNaoVendidos() {
		return repository.getVeiculosNaoVendidos();
	}

	@Override
	public int getVeiculosPorDecadaDeFabricacao(int decada) {
		return repository.getVeiculosPorDecadaDeFabricacao(decada);
	}

	@Override
	public int getVeiculosPorFabricante(String fabricante) {
		return repository.getVeiculosPorFabricante(fabricante);
	}

	@Override
	public List<Veiculo> getVeiculosRegistradosDuranteAUltimaSemana() {
		return null;
	}

}
