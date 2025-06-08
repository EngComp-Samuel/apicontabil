package com.apicontabil.apicontabil.controlefinanceiro.domain.repository;


import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.TipoTransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTransacaoJpaRepository extends JpaRepository<TipoTransacaoEntity, Long> {
}
