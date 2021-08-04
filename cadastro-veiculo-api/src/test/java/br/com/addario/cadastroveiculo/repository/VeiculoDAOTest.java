package br.com.addario.cadastroveiculo.repository;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@ComponentScan
@DataJpaTest
class VeiculoDAOTest {

    @Autowired
    private VeiculoDAO veiculoDAO;

    @Test
    @Sql(scripts = "classpath:/db/insert-veiculo.sql", executionPhase =
            Sql.ExecutionPhase
                    .BEFORE_TEST_METHOD)
    void shouldFindAllVeiculos() {
        final List<VeiculoEntity> veiculos = veiculoDAO.findAll();
        final VeiculoEntity expectedVeiculo = createVeiculoDefault("Monza", "Fiat", 1998);
        assertThat(veiculos).hasSize(1);
        assertThat(veiculos.stream().findFirst().get())
                .usingRecursiveComparison()
                .ignoringFields("created", "updated")
                .isEqualTo(expectedVeiculo);
    }

    @Test
    @Sql(scripts = "classpath:/db/insert-veiculo.sql", executionPhase =
            Sql.ExecutionPhase
                    .BEFORE_TEST_METHOD)
    void shouldUpdateModeloDoVeiculo() {
        veiculoDAO.updateModelo(1L, "Passat");
        final VeiculoEntity veiculoEntity = veiculoDAO.findById(1L);
        assertThat(veiculoEntity.getModelo()).isEqualTo("Passat");
    }

    @Test
    @Sql(scripts = "classpath:/db/insert-veiculo.sql", executionPhase =
            Sql.ExecutionPhase
                    .BEFORE_TEST_METHOD)
    void shouldUpdateMarcaDoVeiculo() {
        veiculoDAO.updateMarca(1L, "Chevrolet");
        final VeiculoEntity veiculoEntity = veiculoDAO.findById(1L);
        assertThat(veiculoEntity.getMarca()).isEqualTo("Chevrolet");
    }

    @Test
    @Sql(scripts = "classpath:/db/insert-veiculo.sql", executionPhase =
            Sql.ExecutionPhase
                    .BEFORE_TEST_METHOD)
    void shouldUpdateAnoDoVeiculo() {
        veiculoDAO.updateAno(1L, 1995);
        final VeiculoEntity veiculoEntity = veiculoDAO.findById(1L);
        assertThat(veiculoEntity.getAno()).isEqualTo(1995);
    }

    @Test
    @Sql(scripts = "classpath:/db/insert-veiculo.sql", executionPhase =
            Sql.ExecutionPhase
                    .BEFORE_TEST_METHOD)
    void shouldUpdateDescricaoDoVeiculo() {
        veiculoDAO.updateDescricao(1L, "Nova descrição desse veículo irado");
        final VeiculoEntity veiculoEntity = veiculoDAO.findById(1L);
        assertThat(veiculoEntity.getDescricao()).isEqualTo("Nova descrição desse veículo irado");
    }

    @Test
    @Sql(scripts = "classpath:/db/insert-veiculo.sql", executionPhase =
            Sql.ExecutionPhase
                    .BEFORE_TEST_METHOD)
    void shouldDeleteVeiculoBrand() {
        veiculoDAO.deleteById(1L);
        final List<VeiculoEntity> veiculos = veiculoDAO.findAll();
        assertThat(veiculos).hasSize(0);
    }


    private VeiculoEntity createVeiculoDefault(String modelo, String marca, int ano) {
        return VeiculoEntity
                .builder()
                .id(1L)
                .modelo(modelo)
                .marca(marca)
                .descricao("Monza tubarão")
                .ano(ano)
                .created(LocalDateTime.now())
                .build();
    }
}