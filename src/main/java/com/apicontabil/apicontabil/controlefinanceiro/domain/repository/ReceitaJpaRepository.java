package com.apicontabil.apicontabil.controlefinanceiro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.ReceitaEntity;

@Repository
public interface ReceitaJpaRepository extends JpaRepository<ReceitaEntity, Long>{

}
