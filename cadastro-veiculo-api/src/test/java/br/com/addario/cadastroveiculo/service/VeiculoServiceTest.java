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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.*;
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
        final VeiculoEntity monza = createTestVeiculo(1L, "Monza", Marca.FIAT, true);
        final VeiculoEntity corola = createTestVeiculo(2L, "Corola", Marca.TOYOTA, true);
        final VeiculoEntity omega = createTestVeiculo(3L, "Omega", Marca.FORD, false);

        when(veiculoDAO.findAll()).thenReturn(Arrays.asList(monza, corola, omega));
        final List<VeiculoEntity> VeiculosNaoVendidos = veiculoService.getTodosOsVeiculosNaoVendidos();
        assertThat(VeiculosNaoVendidos).hasSize(1).contains(omega);
    }

    @Test
    void deveRetornarDoisVeiculosVendidosDeUmaListaDeTresVeiculos() {
        final VeiculoEntity monza = createTestVeiculo(1L, "Monza", Marca.FIAT, true);
        final VeiculoEntity corola = createTestVeiculo(2L, "Corola", Marca.TOYOTA, false);
        final VeiculoEntity omega = createTestVeiculo(3L, "Omega", Marca.FORD, false);

        when(veiculoDAO.findAll()).thenReturn(Arrays.asList(monza, corola, omega));
        final List<VeiculoEntity> veiculosNaoVendidos = veiculoService.getTodosOsVeiculosNaoVendidos();
        assertThat(veiculosNaoVendidos).hasSize(2).contains(corola, omega);
    }

    @Test
    void deveRetornarTresVeiculosVendidosDeUmaListaDeTresVeiculos() {
        final VeiculoEntity monza = createTestVeiculo(1L, "Monza", Marca.FIAT, false);
        final VeiculoEntity corola = createTestVeiculo(2L, "Corola", Marca.TOYOTA, false);
        final VeiculoEntity omega = createTestVeiculo(3L, "Omega", Marca.FORD, false);

        when(veiculoDAO.findAll()).thenReturn(Arrays.asList(monza, corola, omega));
        final List<VeiculoEntity> veiculosNaoVendidos = veiculoService.getTodosOsVeiculosNaoVendidos();
        assertThat(veiculosNaoVendidos).hasSize(3).contains(monza, corola, omega);
    }

    @Test
    void deveRetornarUmVeiculoDaMarcaFord() {
        final VeiculoEntity monza = createTestVeiculo(1L, "Monza", Marca.FIAT, false);
        final VeiculoEntity corola = createTestVeiculo(2L, "Corola", Marca.TOYOTA, false);
        final VeiculoEntity omega = createTestVeiculo(3L, "Omega", Marca.FORD, false);

        when(veiculoDAO.findAll()).thenReturn(Arrays.asList(monza, corola, omega));
        final int quantidadeDeVeiculosPorMarca = veiculoService.getVeiculosPorMarcas(Marca.FORD);
        assertThat(quantidadeDeVeiculosPorMarca).isEqualTo(1);
    }

    @Test
    void deveRetornarDoisVeiculosDaMarcaFord() {
        final VeiculoEntity monza = createTestVeiculo(1L, "Monza", Marca.FIAT, false);
        final VeiculoEntity ka = createTestVeiculo(2L, "Ka", Marca.FORD, false);
        final VeiculoEntity omega = createTestVeiculo(3L, "Omega", Marca.FORD, false);

        when(veiculoDAO.findAll()).thenReturn(Arrays.asList(monza, ka, omega));
        final int quantidadeDeVeiculosPorMarca = veiculoService.getVeiculosPorMarcas(Marca.FORD);
        assertThat(quantidadeDeVeiculosPorMarca).isEqualTo(2);
    }

    @Test
    void deveRetornarTresVeiculosDaMarcaFord() {
        final VeiculoEntity mustang = createTestVeiculo(1L, "Mustang", Marca.FORD, false);
        final VeiculoEntity ka = createTestVeiculo(2L, "Ka", Marca.FORD, false);
        final VeiculoEntity omega = createTestVeiculo(3L, "Omega", Marca.FORD, false);

        when(veiculoDAO.findAll()).thenReturn(Arrays.asList(mustang, ka, omega));
        final int quantidadeDeVeiculosPorMarca = veiculoService.getVeiculosPorMarcas(Marca.FORD);
        assertThat(quantidadeDeVeiculosPorMarca).isEqualTo(3);
    }

    @Test
    void deveRetornarUmVeiculosRegistradoNaUltimaSemana() {
        LocalDateTime[] dias = {
                LocalDateTime.now().minusDays(8),
                LocalDateTime.now().minusDays(10),
                LocalDateTime.now()
        };
        final List<VeiculoEntity> veiculos = createListWith3Veiculos(dias);
        when(veiculoDAO.findAll()).thenReturn(veiculos);
        final List<VeiculoEntity> veiculosRegistradosNaUltimaSemana = veiculoService.getVeiculosRegistradosNaUltimaSemana();
        assertThat(veiculosRegistradosNaUltimaSemana).hasSize(1);
    }

    @Test
    void deveRetornarDoisVeiculosRegistradoNaUltimaSemana() {
        LocalDateTime[] dias = {
                LocalDateTime.now().minusDays(8),
                LocalDateTime.now().minusDays(2),
                LocalDateTime.now()
        };
        final List<VeiculoEntity> veiculos = createListWith3Veiculos(dias);
        when(veiculoDAO.findAll()).thenReturn(veiculos);
        final List<VeiculoEntity> veiculosRegistradosNaUltimaSemana = veiculoService.getVeiculosRegistradosNaUltimaSemana();
        assertThat(veiculosRegistradosNaUltimaSemana).hasSize(2);
    }

    private VeiculoEntity createTestVeiculo(long id, String modelo, Marca marca, boolean vendido) {
        return VeiculoEntity.builder()
                .id(id)
                .modelo(modelo)
                .marca(marca)
                .ano(1998)
                .descricao("Veiculo de teste")
                .vendido(vendido)
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();
    }

    private VeiculoEntity createDefaultVeiculoWithCreatedField(Long id, LocalDateTime created) {
        return VeiculoEntity.builder()
                .id(id)
                .modelo("modelo")
                .marca(Marca.FIAT)
                .ano(1998)
                .descricao("Veiculo de teste")
                .vendido(false)
                .created(created)
                .updated(LocalDateTime.now())
                .build();
    }

    private List<VeiculoEntity> createListWith3Veiculos(LocalDateTime[] registros) {
        return range(0, 3)
                .boxed()
                .map(id -> createDefaultVeiculoWithCreatedField((long) id, registros[id]))
                .collect(Collectors.toList());

    }


}