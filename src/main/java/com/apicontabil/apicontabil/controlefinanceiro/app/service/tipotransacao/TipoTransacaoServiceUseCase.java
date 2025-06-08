package com.apicontabil.apicontabil.controlefinanceiro.app.service.tipotransacao;

import com.apicontabil.apicontabil.controlefinanceiro.domain.dto.CategoriaDTO;
import com.apicontabil.apicontabil.controlefinanceiro.domain.dto.TipoTransacaoDTO;
import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.CategoriaEntity;
import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.TipoTransacaoEntity;

import java.util.List;

public interface TipoTransacaoServiceUseCase {

    TipoTransacaoEntity salvarTipoTransacao(TipoTransacaoDTO tipoTransacaoDTO);

    TipoTransacaoEntity buscarTipoTransacaoPorId(Long id);

    List<TipoTransacaoEntity> listarTiposTransacoes();

    void removerTipoTransacao(Long id);

    TipoTransacaoEntity atualizarTipoTransacao(TipoTransacaoDTO tipoTransacaoDTO, Long id);

    List<TipoTransacaoEntity> listarTipoTransacaoPorNome(String nome);

}
