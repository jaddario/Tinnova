package br.com.addario.cadastroveiculo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;

public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Long> {

	@Query("select v from Veiculo v where v.vendido = FALSE")
	public void updateVeiculo(long id, VeiculoEntity veiculo);

	@Query("select count(v) from Veiculo v where v.vendido = FALSE")
	public Long getVeiculosNaoVendidos();

	@Query("select count(v) from Veiculo v where v.ano between :startDate and :endDate")
	public Long getVeiculosPorDecadaDeFabricacao(@Param(value = "startDate") int startDate,
			@Param(value = "endDate") int endDate);

	@Query("select count(v) from Veiculo v where v.marca =:fabricante")
	public Long getVeiculosPorFabricante(@Param(value = "fabricante") String fabricante);

	@Query("select v from Veiculo v where v.created > :primeiroDiaDaSemanaPassada")
	public List<VeiculoEntity> getVeiculosRegistradosDuranteAUltimaSemana(@Param(value = "primeiroDiaDaSemanaPassada") Date primeiroDiaDaSemanaPassada);

}
