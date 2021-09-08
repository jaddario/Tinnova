package br.com.addario.cadastroveiculo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.addario.cadastroveiculo.exceptions.VeiculoNaoEncontradoException;
import br.com.addario.cadastroveiculo.model.enums.Decada;
import br.com.addario.cadastroveiculo.model.enums.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;
import br.com.addario.cadastroveiculo.repository.VeiculoDAO;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoDAO veiculoDAO;

    public void cadastraVeiculo(VeiculoEntity veiculo) {
        veiculo.setCreated(LocalDateTime.now());
        veiculoDAO.insertVeiculo(veiculo);
    }

    public List<VeiculoEntity> getTodosOsVeiculos() {
        return veiculoDAO.findAll();
    }

    public List<VeiculoEntity> getTodosOsVeiculosNaoVendidos() {
        final List<VeiculoEntity> veiculos = getTodosOsVeiculos();
        return veiculos.stream().filter(VeiculoService::isNaoVendido).collect(Collectors.toList());
    }

    public int getVeiculosPorMarcas(Marca marca) {
        final List<VeiculoEntity> veiculos = getTodosOsVeiculos();
        return (int) veiculos.stream().filter(veiculo -> veiculo.getMarca().equals(marca.getNomeDaMarca())).count();
    }

    public List<VeiculoEntity> getVeiculosRegistradosNaUltimaSemana() {
        final List<VeiculoEntity> veiculos = getTodosOsVeiculos();
        return veiculos
                .stream()
                .filter(VeiculoService::isVeiculoRegistradoNaUltimaSemana)
                .collect(Collectors.toList());
    }

    public int getNumeroDeVeiculosPorDecada(Decada decada) {
        return veiculoDAO.findByDecada(decada);
    }

    public void updateMarca(Long veiculoId, Marca marca) {
        veiculoDAO.updateMarca(veiculoId, marca);
    }

    public void updateModelo(Long veiculoId, String modelo) {
        veiculoDAO.updateModelo(veiculoId, modelo);
    }

    public void updateDescricao(Long veiculoId, String descricao) {
        veiculoDAO.updateDescricao(veiculoId, descricao);
    }

    public void updateAno(Long veiculoId, int ano) {
        veiculoDAO.updateAno(veiculoId, ano);
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

    public void removeVeiculo(long id) {
        veiculoDAO.deleteById(id);
    }

    public Optional<VeiculoEntity> getVeiculoPeloId(long id) {
        return Optional.ofNullable(veiculoDAO.findById(id));
    }
}
