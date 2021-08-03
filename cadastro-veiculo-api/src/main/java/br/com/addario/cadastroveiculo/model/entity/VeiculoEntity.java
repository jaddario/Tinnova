package br.com.addario.cadastroveiculo.model.entity;

import br.com.addario.cadastroveiculo.model.vo.VeiculoVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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
