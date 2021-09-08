package br.com.addario.cadastroveiculo.repository;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;
import br.com.addario.cadastroveiculo.model.enums.Decada;
import br.com.addario.cadastroveiculo.model.enums.Marca;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class VeiculoDAOImpl implements VeiculoDAO {

    @PersistenceContext
    @Qualifier(value = "entityManager")
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertVeiculo(VeiculoEntity veiculo) {
        entityManager.persist(veiculo);
    }

    @Override
    public void updateModelo(Long veiculoId, String veiculoNovoModelo) {
        final StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE VEICULOS V ")
                .append(" SET V.modelo =:novoModelo ")
                .append(" WHERE V.id =:veiculoId ");
        entityManager
                .createNativeQuery(sql.toString(), VeiculoEntity.class)
                .setParameter("veiculoId", veiculoId)
                .setParameter("novoModelo", veiculoNovoModelo)
                .executeUpdate();
    }

    @Override
    public void updateMarca(Long veiculoId, Marca veiculoNovaMarca) {
        final StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE VEICULOS V ")
                .append(" SET V.marca =:novaMarca ")
                .append(" WHERE V.id =:veiculoId ");
        entityManager
                .createNativeQuery(sql.toString(), VeiculoEntity.class)
                .setParameter("veiculoId", veiculoId)
                .setParameter("novaMarca", veiculoNovaMarca.getNomeDaMarca())
                .executeUpdate();
    }

    @Override
    public void updateAno(Long veiculoId, int veiculoNovoAno) {
        final StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE VEICULOS V ")
                .append(" SET V.ano =:novoAno ")
                .append(" WHERE V.id =:veiculoId ");
        entityManager
                .createNativeQuery(sql.toString(), VeiculoEntity.class)
                .setParameter("veiculoId", veiculoId)
                .setParameter("novoAno", veiculoNovoAno)
                .executeUpdate();
    }

    @Override
    public void updateDescricao(Long veiculoId, String veiculoNovaDescricao) {
        final StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE VEICULOS V ")
                .append(" SET V.descricao =:novaDescricao ")
                .append(" WHERE V.id =:veiculoId ");
        entityManager
                .createNativeQuery(sql.toString(), VeiculoEntity.class)
                .setParameter("veiculoId", veiculoId)
                .setParameter("novaDescricao", veiculoNovaDescricao)
                .executeUpdate();
    }

    @Override
    public List<VeiculoEntity> findAll() {
        final StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM VEICULOS V");
        return entityManager
                .createNativeQuery(sql.toString(), VeiculoEntity.class)
                .getResultList();
    }

    @Override
    public VeiculoEntity findById(long id) {
        final StringBuilder sql = new StringBuilder();
        sql.append(" SELECT * FROM VEICULOS V ")
                .append(" WHERE V.id =:veiculoId ");
        return (VeiculoEntity) entityManager
                .createNativeQuery(sql.toString(), VeiculoEntity.class)
                .setParameter("veiculoId", id)
                .getSingleResult();
    }

    @Override
    public void deleteById(long veiculoId) {
        final StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM VEICULOS V")
                .append(" WHERE V.id =:veiculoId ");
        entityManager
                .createNativeQuery(sql.toString(), VeiculoEntity.class)
                .setParameter("veiculoId", veiculoId)
                .executeUpdate();
    }

    @Override
    public int findByDecada(Decada decada) {
        final StringBuilder sql = new StringBuilder();
        sql.append(" SELECT COUNT(*) FROM VEICULOS V ");
        sql.append(" WHERE V.ano >=:decadaInicio and V.ano <:decadaFim");

        return ((BigInteger) entityManager
                .createNativeQuery(sql.toString())
                .setParameter("decadaInicio", decada.getAno())
                .setParameter("decadaFim", decada.getAno() + 10)
                .getSingleResult()).intValue();
    }
}
