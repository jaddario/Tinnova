package br.com.addario.cadastroveiculo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.addario.cadastroveiculo.model.enums.Marca;
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
        final List<VeiculoEntity> veiculos = getTodosOsVeiculos();
        return veiculos.stream().filter(VeiculoService::isNaoVendido).collect(Collectors.toList());
    }

    public int getVeiculosPorMarcas(Marca marca) {
        final List<VeiculoEntity> veiculos = getTodosOsVeiculos();
        return (int) veiculos.stream().filter(veiculo -> veiculo.getMarca().equals(marca)).count();
    }

    public List<VeiculoEntity> getVeiculosRegistradosNaUltimaSemana() {
        final List<VeiculoEntity> veiculos = getTodosOsVeiculos();
        return veiculos
                .stream()
                .filter(VeiculoService::isVeiculoRegistradoNaUltimaSemana)
                .collect(Collectors.toList());
    }

    private static boolean isNaoVendido(VeiculoEntity veiculo) {
        return !veiculo.isVendido();
    }

    private static boolean isVeiculoRegistradoNaUltimaSemana(VeiculoEntity veiculo) {
        return veiculo
                .getCreated()
                .isAfter(LocalDateTime.now()
                        .minusDays(7));
    }
}
