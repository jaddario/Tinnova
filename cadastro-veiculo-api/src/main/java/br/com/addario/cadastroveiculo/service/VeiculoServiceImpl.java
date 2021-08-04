package br.com.addario.cadastroveiculo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;
import br.com.addario.cadastroveiculo.repository.VeiculoDAO;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private VeiculoDAO repository;

	@Override
	public List<VeiculoEntity> getTodosOsVeiculos() {
		return repository.findAll();
	}
}
