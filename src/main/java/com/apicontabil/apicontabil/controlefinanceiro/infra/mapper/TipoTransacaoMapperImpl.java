package com.apicontabil.apicontabil.controlefinanceiro.infra.mapper;

import com.apicontabil.apicontabil.controlefinanceiro.app.mapper.tipotransacao.TipoTransacaoMapper;
import com.apicontabil.apicontabil.controlefinanceiro.domain.dto.TipoTransacaoDTO;
import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.TipoTransacaoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TipoTransacaoMapperImpl implements TipoTransacaoMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TipoTransacaoEntity toEntity(TipoTransacaoDTO tipoTransacaoDTO) {
        return modelMapper.map(tipoTransacaoDTO, TipoTransacaoEntity.class);
    }

    @Override
    public TipoTransacaoDTO toDTO(TipoTransacaoEntity tipoTransacaoEntity) {
        return modelMapper.map(tipoTransacaoEntity, TipoTransacaoDTO.class);
    }
}
