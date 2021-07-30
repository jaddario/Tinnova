package br.com.addario.cadastroveiculo.model.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.addario.cadastroveiculo.model.vo.VeiculoVO;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
public class VeiculoEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(name = "veiculo")
    private String modelo;
    @Column(name = "fabricante")
    private String marca;
    @Column(name = "ano")
    private int ano;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "vendido")
    private boolean vendido;
    @Column(name = "created", nullable = true)
    private LocalDateTime created;
    @Column(name = "updated", nullable = true)
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
