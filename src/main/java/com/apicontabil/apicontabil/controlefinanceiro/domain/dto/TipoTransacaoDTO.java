package com.apicontabil.apicontabil.controlefinanceiro.domain.dto;

import java.util.Objects;

public class TipoTransacaoDTO {


    private String nome;

    public TipoTransacaoDTO(String nome) {
        this.nome = nome;
    }

    public TipoTransacaoDTO(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TipoTransacaoDTO that = (TipoTransacaoDTO) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }



}
