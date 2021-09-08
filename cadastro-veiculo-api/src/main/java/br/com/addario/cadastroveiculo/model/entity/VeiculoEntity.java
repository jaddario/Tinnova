package br.com.addario.cadastroveiculo.model.entity;

import br.com.addario.cadastroveiculo.model.enums.Decada;
import br.com.addario.cadastroveiculo.model.enums.Marca;
import br.com.addario.cadastroveiculo.model.vo.VeiculoVO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VEICULOS")
public class VeiculoEntity {

    @Id
    @EqualsAndHashCode.Exclude
    private Long id;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "ANO")
    private int ano;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "VENDIDO")
    private boolean vendido;
    @Column(name = "CREATED", nullable = true)
    @EqualsAndHashCode.Exclude
    private LocalDateTime created;
    @Column(name = "UPDATED", nullable = true)
    private LocalDateTime updated;

    public static VeiculoEntity from(VeiculoVO veiculoVO) {
        return VeiculoEntity
                .builder()
                .id(veiculoVO.getId())
                .modelo(veiculoVO.getModelo())
                .marca(veiculoVO.getMarca())
                .ano(veiculoVO.getAno())
                .descricao(veiculoVO.getDescricao())
                .vendido(veiculoVO.isVendido())
                .created(veiculoVO.getCreated())
                .updated(veiculoVO.getCreated())
                .build();
    }

}



