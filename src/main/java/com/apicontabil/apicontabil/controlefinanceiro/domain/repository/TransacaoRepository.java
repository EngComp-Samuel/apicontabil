package com.apicontabil.apicontabil.controlefinanceiro.domain.repository;

import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<TransacaoEntity, Long> {
}
