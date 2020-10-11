package br.com.addario.cadastroveiculo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.addario.cadastroveiculo.model.Veiculo;
import br.com.addario.cadastroveiculo.repository.VeiculoRepository;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	@Override
	public List<Veiculo> getTodosOsVeiculos() {
		return repository.findAll();
	}

	@Override
	public void cadastraVeiculo(Veiculo veiculo) {
		repository.save(veiculo);
	}

	@Override
	public void removeVeiculo(long id) {
		repository.deleteById(id);
	}

	@Override
	public Long getVeiculosNaoVendidos() {
		return repository.getVeiculosNaoVendidos();
	}

	@Override
	public Long getVeiculosPorDecadaDeFabricacao(int ano) {
		return repository.getVeiculosPorDecadaDeFabricacao(ano, ano + 10);
	}

	@Override
	public Long getVeiculosPorFabricante(String fabricante) {
		return repository.getVeiculosPorFabricante(fabricante);
	}

	@Override
	public void atualizaVeiculo(long id, Veiculo veiculo) {
		repository.updateVeiculo(id, veiculo);
	}

	@Override
	public List<Veiculo> getVeiculosRegistradosDuranteAUltimaSemana(Date primeiroDiaDaSemanaPassada) {
		return repository.getVeiculosRegistradosDuranteAUltimaSemana(primeiroDiaDaSemanaPassada);
	}

}
