package com.apicontabil.apicontabil.controlefinanceiro.app.mapper.tipotransacao;

import com.apicontabil.apicontabil.controlefinanceiro.domain.dto.CategoriaDTO;
import com.apicontabil.apicontabil.controlefinanceiro.domain.dto.TipoTransacaoDTO;
import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.CategoriaEntity;
import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.TipoTransacaoEntity;

public interface TipoTransacaoMapper {

    TipoTransacaoEntity toEntity(TipoTransacaoDTO tipoTransacaoDTO);
    TipoTransacaoDTO toDTO(TipoTransacaoEntity tipoTransacaoEntity);
}
