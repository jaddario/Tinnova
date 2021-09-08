package br.com.addario.cadastroveiculo.repository;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;
import br.com.addario.cadastroveiculo.model.enums.Decada;
import br.com.addario.cadastroveiculo.model.enums.Marca;
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
    void shouldInsertEntityThenInsertTheSameAndReturnException() {
        final VeiculoEntity i360 = createVeiculoDefault(1L, "i360", Marca.NISSAN.getNomeDaMarca(), 2018);
        veiculoDAO.insertVeiculo(i360);
        final List<VeiculoEntity> todosOsVeiculos = veiculoDAO.findAll();
        assertThat(todosOsVeiculos).hasSize(1).contains(i360);
    }

    @Test
    @Sql(scripts = "classpath:/db/create-veiculo-database.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void shouldFindAllVeiculos() {
        final List<VeiculoEntity> veiculos = veiculoDAO.findAll();
        final VeiculoEntity expectedVeiculo = createVeiculoDefault(1L, "Monza", Marca.FIAT.getNomeDaMarca(), 1998);
        assertThat(veiculos).hasSize(6);
        assertThat(veiculos.stream().findFirst().get())
                .usingRecursiveComparison()
                .ignoringFields("created", "updated")
                .isEqualTo(expectedVeiculo);
    }

    @Test
    @Sql(scripts = "classpath:/db/create-veiculo-database.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void shouldUpdateModeloDoVeiculo() {
        veiculoDAO.updateModelo(1L, "Passat");
        final VeiculoEntity veiculoEntity = veiculoDAO.findById(1L);
        assertThat(veiculoEntity.getModelo()).isEqualTo("Passat");
    }

    @Test
    @Sql(scripts = "classpath:/db/create-veiculo-database.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void shouldUpdateMarcaDoVeiculo() {
        veiculoDAO.updateMarca(1L, Marca.CHEVROLET);
        final VeiculoEntity veiculoEntity = veiculoDAO.findById(1L);
        assertThat(veiculoEntity.getMarca()).isEqualTo(Marca.CHEVROLET.getNomeDaMarca());
    }

    @Test
    @Sql(scripts = "classpath:/db/create-veiculo-database.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void shouldUpdateAnoDoVeiculo() {
        veiculoDAO.updateAno(1L, 1995);
        final VeiculoEntity veiculoEntity = veiculoDAO.findById(1L);
        assertThat(veiculoEntity.getAno()).isEqualTo(1995);
    }

    @Test
    @Sql(scripts = "classpath:/db/create-veiculo-database.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void shouldUpdateDescricaoDoVeiculo() {
        veiculoDAO.updateDescricao(1L, "Nova descrição desse veículo irado");
        final VeiculoEntity veiculoEntity = veiculoDAO.findById(1L);
        assertThat(veiculoEntity.getDescricao()).isEqualTo("Nova descrição desse veículo irado");
    }

    @Test
    @Sql(scripts = "classpath:/db/create-veiculo-database.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void shouldFind3VeiculosInDecada90() {
        final int numeroDeVeiculosPorDecada = veiculoDAO.findByDecada(Decada.D90);
        assertThat(numeroDeVeiculosPorDecada).isEqualTo(3);
    }

    @Test
    @Sql(scripts = "classpath:/db/create-veiculo-database.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void shouldDeleteVeiculoBrand() {
        veiculoDAO.deleteById(3L);
        final List<VeiculoEntity> veiculos = veiculoDAO.findAll();
        assertThat(veiculos).hasSize(5);
    }


    private VeiculoEntity createVeiculoDefault(long id, String modelo, String marca, int ano) {
        return VeiculoEntity
                .builder()
                .id(id)
                .modelo(modelo)
                .marca(marca)
                .descricao("Monza tubarão")
                .ano(ano)
                .created(LocalDateTime.now())
                .build();
    }
}