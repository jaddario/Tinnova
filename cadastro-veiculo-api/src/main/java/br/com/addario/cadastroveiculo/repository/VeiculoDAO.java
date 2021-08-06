package br.com.addario.cadastroveiculo.repository;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;
import br.com.addario.cadastroveiculo.model.enums.Marca;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface VeiculoDAO {

    void insertVeiculo(VeiculoEntity veiculo);

    int updateModelo(Long veiculoId, String veiculoNovoModelo);

    int updateMarca(Long veiculoId, Marca veiculoNovaMarca);

    int updateAno(Long veiculoId, int veiculoNovoAno);

    int updateDescricao(Long veiculoId, String veiculoNovaDescricao);

    List<VeiculoEntity> findAll();

    VeiculoEntity findById(long id);

    void deleteById(long veiculoId);
}
