package br.com.addario.cadastroveiculo.model.vo;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class VeiculoVO {
    private Long id;
    private String modelo;
    private String marca;
    private int ano;
    private String descricao;
    private boolean vendido;
    private LocalDateTime created;
    private LocalDateTime updated;

    public VeiculoVO from(VeiculoEntity entity) {
        return VeiculoVO
                .builder()
                .id(entity.getId())
                .modelo(entity.getModelo())
                .marca(entity.getMarca())
                .ano(entity.getAno())
                .descricao(entity.getDescricao())
                .vendido(entity.isVendido())
                .created(entity.getCreated())
                .updated(entity.getCreated())
                .build();
    }
}
