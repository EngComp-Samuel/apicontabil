package com.apicontabil.apicontabil.controlefinanceiro.app.service.transacao;

import com.apicontabil.apicontabil.controlefinanceiro.domain.dto.TipoTransacaoDTO;
import com.apicontabil.apicontabil.controlefinanceiro.domain.dto.TransacaoDTO;
import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.TipoTransacaoEntity;
import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.TransacaoEntity;

import java.util.List;

public interface TransacaoServiceUseCase {

    TransacaoEntity salvarTransacao(TransacaoDTO transacaoDTO);

    TransacaoEntity buscarTransacaoPorId(Long id);

    List<TransacaoEntity> listarTransacoes();

    void removerTransacao(Long id);

    TransacaoEntity atualizarTransacao(TransacaoDTO transacaoDTO, Long id);

    List<TransacaoEntity> listarTransacaoPorNome(String nome);

}
