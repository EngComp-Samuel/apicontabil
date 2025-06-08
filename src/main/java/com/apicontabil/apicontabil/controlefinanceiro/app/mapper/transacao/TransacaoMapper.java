package com.apicontabil.apicontabil.controlefinanceiro.app.mapper.transacao;

import com.apicontabil.apicontabil.controlefinanceiro.domain.dto.CategoriaDTO;
import com.apicontabil.apicontabil.controlefinanceiro.domain.dto.TransacaoDTO;
import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.CategoriaEntity;
import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.TransacaoEntity;

public interface TransacaoMapper {

    TransacaoEntity toEntity(TransacaoDTO transacaoDTO);
    TransacaoDTO toDTO(TransacaoEntity transacaoEntity);

}
