package br.com.addario.cadastroveiculo.repository;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;
import br.com.addario.cadastroveiculo.model.enums.Decada;
import br.com.addario.cadastroveiculo.model.enums.Marca;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoDAO {

    void insertVeiculo(VeiculoEntity veiculo);

    void updateModelo(Long veiculoId, String veiculoNovoModelo);

    void updateMarca(Long veiculoId, Marca veiculoNovaMarca);

    void updateAno(Long veiculoId, int veiculoNovoAno);

    void updateDescricao(Long veiculoId, String veiculoNovaDescricao);

    List<VeiculoEntity> findAll();

    VeiculoEntity findById(long id);

    void deleteById(long veiculoId);

    int findByDecada(Decada decada);
}
