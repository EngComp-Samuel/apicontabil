package com.apicontabil.apicontabil.controlefinanceiro.infraestrutura;

import com.apicontabil.apicontabil.controlefinanceiro.dominio.modelo.Categoria;

import java.util.List;

public interface CategoriaRepositoryQueries {

    public List<Categoria> buscarTodasCategoriasPorNome(String nome);
}
