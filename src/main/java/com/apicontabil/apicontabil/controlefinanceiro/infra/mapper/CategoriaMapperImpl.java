package com.apicontabil.apicontabil.controlefinanceiro.infra.mapper;

import com.apicontabil.apicontabil.controlefinanceiro.app.mapper.categoria.CategoriaMapper;
import com.apicontabil.apicontabil.controlefinanceiro.domain.dto.CategoriaDTO;
import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.CategoriaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    //private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private ModelMapper modelMapper;

   /* @Override
    public CategoriaEntity toEntity(Categoria categoria) {
        return modelMapper.map(categoria, CategoriaEntity.class);
    }

    @Override
    public Categoria toDomain(CategoriaEntity categoriaEntity) {
        return modelMapper.map(categoriaEntity, Categoria.class);
    }*/

    @Override
    public CategoriaEntity toEntity(CategoriaDTO categoriaDTO) {
        return modelMapper.map(categoriaDTO, CategoriaEntity.class);
    }

    @Override
    public CategoriaDTO toDTO(CategoriaEntity categoriaEntity) {
        return modelMapper.map(categoriaEntity, CategoriaDTO.class);
    }
}
