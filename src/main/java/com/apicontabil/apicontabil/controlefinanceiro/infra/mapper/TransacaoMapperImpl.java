package com.apicontabil.apicontabil.controlefinanceiro.infra.mapper;

import com.apicontabil.apicontabil.controlefinanceiro.app.mapper.transacao.TransacaoMapper;
import com.apicontabil.apicontabil.controlefinanceiro.domain.dto.TransacaoDTO;
import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.TransacaoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TransacaoMapperImpl implements TransacaoMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TransacaoEntity toEntity(TransacaoDTO transacaoDTO) {
        return modelMapper.map(transacaoDTO, TransacaoEntity.class);
    }

    @Override
    public TransacaoDTO toDTO(TransacaoEntity transacaoEntity) {
        return modelMapper.map(transacaoEntity, TransacaoDTO.class);
    }
}
