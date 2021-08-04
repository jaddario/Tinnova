package br.com.addario.cadastroveiculo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;

@Service
public interface VeiculoService {

//	public VeiculoEntity cadastraVeiculo(VeiculoEntity veiculo);

//	public void removeVeiculo(long id);
//
//	public void atualizaVeiculo(long id, VeiculoEntity veiculo);
//
//	public Long getVeiculosNaoVendidos();
//
//	public Long getVeiculosPorDecadaDeFabricacao(int decada);
//
//	public Long getVeiculosPorFabricante(String fabricante);

//	public List<VeiculoEntity> getVeiculosRegistradosDuranteAUltimaSemana(Date primeiroDiaDaSemanaPassada);

	public List<VeiculoEntity> getTodosOsVeiculos();

//	public Optional<VeiculoEntity> getVeiculoPeloId(long id);

}
