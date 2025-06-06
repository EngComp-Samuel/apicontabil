package com.apicontabil.apicontabil.controlefinanceiro.app.service.categoria;

import com.apicontabil.apicontabil.controlefinanceiro.domain.dto.CategoriaDTO;
import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.CategoriaEntity;

import java.util.List;

public interface CategoriaServiceUseCase {

    CategoriaEntity salvarCategoria(CategoriaDTO categoria);

    CategoriaEntity buscarCategoriaPorId(Long id);

    List<CategoriaEntity> listarCategorias();

    void removerCategoria(Long id);

    CategoriaEntity atualizarCategoria(CategoriaDTO categoria, Long id);

    List<CategoriaEntity> listarCategoriasPorNome(String nome);

}
