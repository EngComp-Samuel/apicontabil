package com.apicontabil.apicontabil.controlefinanceiro.infraestrutura;

import com.apicontabil.apicontabil.controlefinanceiro.dominio.modelo.Categoria;
import com.apicontabil.apicontabil.controlefinanceiro.dominio.repository.CategoriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * REPOSITORIO CUSTOMIZADO
 */
@Repository
public class CategoriaRepositoryImpl implements CategoriaRepositoryQueries{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Categoria> buscarTodasCategoriasPorNome(String nome){

        var jpql = "from Categoria where nome ilike :nome";

        return entityManager.createQuery(jpql, Categoria.class).setParameter("nome", "%" + nome + "%").getResultList();
    }



}
