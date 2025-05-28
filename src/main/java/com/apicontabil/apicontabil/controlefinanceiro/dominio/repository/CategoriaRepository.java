package com.apicontabil.apicontabil.controlefinanceiro.dominio.repository;

import com.apicontabil.apicontabil.controlefinanceiro.infraestrutura.CategoriaRepositoryQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apicontabil.apicontabil.controlefinanceiro.dominio.modelo.Categoria;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>, CategoriaRepositoryQueries {

    @Query("from Categoria c where c.id =:id")
    public Categoria buscarUmaCategoriaPorId(@Param("id") Long id);


}
