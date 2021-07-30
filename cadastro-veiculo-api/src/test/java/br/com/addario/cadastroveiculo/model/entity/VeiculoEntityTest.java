package br.com.addario.cadastroveiculo.model.entity;

import br.com.addario.cadastroveiculo.model.vo.VeiculoVO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

class VeiculoEntityTest {

    @Test
    void deveConverterUmVeiculoVoEmUmVeiculoEntity() {
        VeiculoVO veiculoVO = createEntity();
        final VeiculoEntity actualVeiculoEntity = VeiculoEntity.from(veiculoVO);
        assertThat(veiculoVO).usingRecursiveComparison().isEqualTo(actualVeiculoEntity);
    }

    private VeiculoVO createEntity() {
        String dateString = "2021-07-30 12:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        return VeiculoVO
                .builder()
                .id(1L)
                .modelo("Monza")
                .marca("Fiat")
                .ano(1998)
                .descricao("Monza tubarão 1.0")
                .vendido(false)
                .created(dateTime)
                .updated(dateTime)
                .build();
    }
}