package br.com.addario.cadastroveiculo.repository;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;
import br.com.addario.cadastroveiculo.model.vo.VeiculoVO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class VeiculoRepositoryTest {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @BeforeEach
    void initUsecase() {
        veiculoRepository.saveAll(Arrays.asList(createVeiculoDefault("Monza", "Fiat", 1998)));
    }

    @AfterEach
    void destroy() {
        veiculoRepository.deleteAll();
    }

    @Test
    void shouldFindAllVeiculos() {
        final VeiculoEntity fiatMonza98 = createVeiculoDefault("Monza", "Fiat", 1998);
        final List<VeiculoEntity> veiculos = veiculoRepository.findAll();

        assertThat(veiculos).hasSize(1).contains(fiatMonza98);
    }


    private VeiculoEntity createVeiculoDefault(String modelo, String marca, int ano) {
        return VeiculoEntity
                .builder()
                .modelo(modelo)
                .marca(marca)
                .descricao("Veiculo Teste")
                .ano(ano)
                .created(LocalDateTime.now())
                .build();
    }
}