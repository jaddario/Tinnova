package br.com.addario.cadastroveiculo.service;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;
import br.com.addario.cadastroveiculo.model.enums.Marca;
import br.com.addario.cadastroveiculo.repository.VeiculoDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VeiculoServiceTest {

    @InjectMocks
    private VeiculoService veiculoService;

    @Mock
    private VeiculoDAO veiculoDAO;

    @Test
    void deveRetornarUmVeiculoVendidoDeUmaListaDeTresVeiculos() {
        final VeiculoEntity monza = createTestVeiculo(1L, "Monza", true);
        final VeiculoEntity corola = createTestVeiculo(2L, "Corola", true);
        final VeiculoEntity omega = createTestVeiculo(3L, "Omega", false);

        when(veiculoDAO.findAll()).thenReturn(Arrays.asList(monza, corola, omega));
        final List<VeiculoEntity> VeiculosNaoVendidos = veiculoService.getTodosOsVeiculosNaoVendidos();
        assertThat(VeiculosNaoVendidos).hasSize(1).contains(omega);
    }

    @Test
    void deveRetornarDoisVeiculosVendidosDeUmaListaDeTresVeiculos() {
        final VeiculoEntity monza = createTestVeiculo(1L, "Monza", true);
        final VeiculoEntity corola = createTestVeiculo(2L, "Corola", false);
        final VeiculoEntity omega = createTestVeiculo(3L, "Omega", false);

        when(veiculoDAO.findAll()).thenReturn(Arrays.asList(monza, corola, omega));
        final List<VeiculoEntity> veiculosNaoVendidos = veiculoService.getTodosOsVeiculosNaoVendidos();
        assertThat(veiculosNaoVendidos).hasSize(2).contains(corola, omega);
    }

    @Test
    void deveRetornarTresVeiculosVendidosDeUmaListaDeTresVeiculos() {
        final VeiculoEntity monza = createTestVeiculo(1L, "Monza", false);
        final VeiculoEntity corola = createTestVeiculo(2L, "Corola", false);
        final VeiculoEntity omega = createTestVeiculo(3L, "Omega", false);

        when(veiculoDAO.findAll()).thenReturn(Arrays.asList(monza, corola, omega));
        final List<VeiculoEntity> veiculosNaoVendidos = veiculoService.getTodosOsVeiculosNaoVendidos();
        assertThat(veiculosNaoVendidos).hasSize(3).contains(monza, corola, omega);
    }

    @Test
    void deveRetornarUmVeiculoDaDecadaDeNoventa(){

    }

    private VeiculoEntity createTestVeiculo(long id, String modelo, boolean vendido) {
        return VeiculoEntity.builder()
                .id(id)
                .modelo(modelo)
                .marca(Marca.FIAT)
                .ano(1998)
                .descricao("Veiculo de teste")
                .vendido(vendido)
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();
    }


}