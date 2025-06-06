package com.apicontabil.apicontabil.controlefinanceiro.app.mapper.categoria;

import com.apicontabil.apicontabil.controlefinanceiro.domain.dto.CategoriaDTO;
import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.CategoriaEntity;

public interface CategoriaMapper {

    CategoriaEntity toEntity(CategoriaDTO categoriaDTO);
    CategoriaDTO toDTO(CategoriaEntity categoriaEntity);

}
