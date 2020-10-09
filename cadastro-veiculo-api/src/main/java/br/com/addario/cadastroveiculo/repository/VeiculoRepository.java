package br.com.addario.cadastroveiculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.addario.cadastroveiculo.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

}
