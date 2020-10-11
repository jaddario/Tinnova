package br.com.addario.cadastroveiculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.addario.cadastroveiculo.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	
	@Query("select v from Veiculo where v.vendido = FALSE")
	public void updateVeiculo(long id, Veiculo veiculo);

	@Query("select count(v) from Veiculo where v.vendido = FALSE")
	public int getVeiculosNaoVendidos();

	@Query("select count(v) from Veiculo where v.ano =:1")
	public int getVeiculosPorDecadaDeFabricacao(int decada);

	@Query("select count(v) from Veiculo where v.marca =:1")
	public int getVeiculosPorFabricante(String fabricante);
	
	

}
