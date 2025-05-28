package com.apicontabil.apicontabil.controlefinanceiro.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apicontabil.apicontabil.controlefinanceiro.dominio.modelo.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long>{

}
