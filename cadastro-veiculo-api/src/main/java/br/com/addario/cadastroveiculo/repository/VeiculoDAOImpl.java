package br.com.addario.cadastroveiculo.repository;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class VeiculoDAOImpl implements VeiculoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertVeiculo(VeiculoEntity veiculo) {
        entityManager.persist(veiculo);
    }

    @Override
    public int updateModelo(Long veiculoId, String veiculoNovoModelo) {
        final StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE VEICULOS V ")
                .append(" SET V.modelo =:novoModelo ")
                .append(" WHERE V.id =:veiculoId ");
        final int executeUpdate = entityManager
                .createNativeQuery(sql.toString(), VeiculoEntity.class)
                .setParameter("veiculoId", veiculoId)
                .setParameter("novoModelo", veiculoNovoModelo)
                .executeUpdate();

        validate(executeUpdate == 1, "Veiculo não encontrado com o Id=", veiculoId);

        return executeUpdate;
    }

    @Override
    public int updateMarca(Long veiculoId, String veiculoNovaMarca) {
        final StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE VEICULOS V ")
                .append(" SET V.marca =:novaMarca ")
                .append(" WHERE V.id =:veiculoId ");
        final int executeUpdate = entityManager
                .createNativeQuery(sql.toString(), VeiculoEntity.class)
                .setParameter("veiculoId", veiculoId)
                .setParameter("novaMarca", veiculoNovaMarca)
                .executeUpdate();

        validate(executeUpdate == 1, "Veiculo não encontrado com o Id=", veiculoId);

        return executeUpdate;
    }

    @Override
    public int updateAno(Long veiculoId, int veiculoNovoAno) {
        final StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE VEICULOS V ")
                .append(" SET V.ano =:novoAno ")
                .append(" WHERE V.id =:veiculoId ");
        final int executeUpdate = entityManager
                .createNativeQuery(sql.toString(), VeiculoEntity.class)
                .setParameter("veiculoId", veiculoId)
                .setParameter("novoAno", veiculoNovoAno)
                .executeUpdate();

        validate(executeUpdate == 1, "Veiculo não encontrado com o Id=", veiculoId);

        return executeUpdate;
    }

    @Override
    public int updateDescricao(Long veiculoId, String veiculoNovaDescricao) {
        final StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE VEICULOS V ")
                .append(" SET V.descricao =:novaDescricao ")
                .append(" WHERE V.id =:veiculoId ");
        final int executeUpdate = entityManager
                .createNativeQuery(sql.toString(), VeiculoEntity.class)
                .setParameter("veiculoId", veiculoId)
                .setParameter("novaDescricao", veiculoNovaDescricao)
                .executeUpdate();

        validate(executeUpdate == 1, "Veiculo não encontrado com o Id=", veiculoId);

        return executeUpdate;
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

    private static void validate(boolean expression, String message, Object value) {
        if (expression == false) {
            throw new IllegalArgumentException(message + value);
        }
    }
}
