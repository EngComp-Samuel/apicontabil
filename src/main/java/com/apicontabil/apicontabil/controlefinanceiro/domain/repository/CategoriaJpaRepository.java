package com.apicontabil.apicontabil.controlefinanceiro.domain.repository;

import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.CategoriaEntity;

import java.util.List;

@Repository
public interface CategoriaJpaRepository extends JpaRepository<CategoriaEntity, Long> {

    @Query(nativeQuery = true, value = "select * from Categoria as c where c.nome ilike %:nome%")
    List<CategoriaEntity> listarCategoriasPorNome(@PathParam("nome") String nome);
}
