package com.apicontabil.apicontabil.controlefinanceiro.domain.dto;

import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.CategoriaEntity;
import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.TipoTransacaoEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class TransacaoDTO {


    private String descricao;
    private BigDecimal valor;
    private LocalDate dataTransacao;
    private CategoriaDTO categoriaDTO;
    private TipoTransacaoDTO tipoTransacaoDTO;

    public TransacaoDTO(){}

    public TransacaoDTO(String descricao, BigDecimal valor, LocalDate dataTransacao, CategoriaDTO categoriaDTO, TipoTransacaoDTO tipoTransacaoDTO) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.categoriaDTO = categoriaDTO;
        this.tipoTransacaoDTO = tipoTransacaoDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TransacaoDTO that = (TransacaoDTO) o;
        return Objects.equals(descricao, that.descricao) && Objects.equals(valor, that.valor) && Objects.equals(dataTransacao, that.dataTransacao) && Objects.equals(categoriaDTO, that.categoriaDTO) && Objects.equals(tipoTransacaoDTO, that.tipoTransacaoDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, valor, dataTransacao, categoriaDTO, tipoTransacaoDTO);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public CategoriaDTO getCategoriaDTO() {
        return categoriaDTO;
    }

    public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
        this.categoriaDTO = categoriaDTO;
    }

    public TipoTransacaoDTO getTipoTransacaoDTO() {
        return tipoTransacaoDTO;
    }

    public void setTipoTransacaoDTO(TipoTransacaoDTO tipoTransacaoDTO) {
        this.tipoTransacaoDTO = tipoTransacaoDTO;
    }

}
