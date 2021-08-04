package br.com.addario.cadastroveiculo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;
import br.com.addario.cadastroveiculo.repository.VeiculoDAO;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private VeiculoDAO repository;

	@Override
	public List<VeiculoEntity> getTodosOsVeiculos() {
		return repository.findAll();
	}

//	@Override
//	public VeiculoEntity cadastraVeiculo(VeiculoEntity veiculo) {
//		repository.insertVeiculo(veiculo);
//	}

//	@Override
//	public void removeVeiculo(long id) {
//		repository.deleteById(id);
//	}
//
//	@Override
//	public Long getVeiculosNaoVendidos() {
//		return repository.getVeiculosNaoVendidos();
//	}

//	@Override
//	public Long getVeiculosPorDecadaDeFabricacao(int ano) {
//		return repository.getVeiculosPorDecadaDeFabricacao(ano, ano + 10);
//	}

//	@Override
//	public Long getVeiculosPorFabricante(String fabricante) {
//		return repository.getVeiculosPorFabricante(fabricante);
//	}
//
//	@Override
//	public void atualizaVeiculo(long id, VeiculoEntity veiculo) {
//		repository.updateVeiculo(id, veiculo);
//	}
//
//	@Override
//	public List<VeiculoEntity> getVeiculosRegistradosDuranteAUltimaSemana(Date primeiroDiaDaSemanaPassada) {
//		return repository.getVeiculosRegistradosDuranteAUltimaSemana(primeiroDiaDaSemanaPassada);
//	}
//
//	@Override
//	public Optional<VeiculoEntity> getVeiculoPeloId(long id) {
//		return repository.findById(id);
//	}
}
