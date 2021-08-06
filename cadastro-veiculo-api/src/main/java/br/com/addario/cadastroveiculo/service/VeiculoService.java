package br.com.addario.cadastroveiculo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;
import br.com.addario.cadastroveiculo.repository.VeiculoDAO;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoDAO veiculoDAO;

    public List<VeiculoEntity> getTodosOsVeiculos() {
        return veiculoDAO.findAll();
    }

    public List<VeiculoEntity> getTodosOsVeiculosNaoVendidos() {
        final List<VeiculoEntity> veiculos = veiculoDAO.findAll();
        return veiculos.stream().filter(VeiculoService::isNaoVendido).collect(Collectors.toList());
    }

    private static boolean isNaoVendido(VeiculoEntity veiculo) {
        return !veiculo.isVendido();
    }
}
