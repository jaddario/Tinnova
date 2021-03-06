package br.com.addario.cadastroveiculo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Component
public class Veiculo {
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
	private Date created;
	@Column(name = "updated", nullable = true)
	private Date updated;

	public Veiculo() {
		this.created = new Date();
	}

	public Veiculo(Long id, String modelo, String marca, int ano, String descricao) {
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.created = new Date();
	}
	
	

}
