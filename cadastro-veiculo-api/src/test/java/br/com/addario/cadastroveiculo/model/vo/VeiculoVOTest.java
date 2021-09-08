package br.com.addario.cadastroveiculo.model.vo;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;
import br.com.addario.cadastroveiculo.model.enums.Marca;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

class VeiculoVOTest {


    @Test
    void deveConverterUmVeiculoEntityEmUmVeiculoVO() {
        VeiculoEntity veiculoEntity = createVO();
        final VeiculoVO actualVeiculoVo = VeiculoVO.from(veiculoEntity);
        assertThat(veiculoEntity).usingRecursiveComparison().isEqualTo(actualVeiculoVo);
    }

    private VeiculoEntity createVO() {
        String dateString = "2021-07-30 12:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        return VeiculoEntity
                .builder()
                .id(1L)
                .modelo("Monza")
                .marca(Marca.FIAT.getNomeDaMarca())
                .ano(1998)
                .descricao("Monza tubarão 1.0")
                .vendido(false)
                .created(dateTime)
                .updated(dateTime)
                .build();
    }
}