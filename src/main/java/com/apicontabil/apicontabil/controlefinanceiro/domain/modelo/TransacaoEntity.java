package com.apicontabil.apicontabil.controlefinanceiro.domain.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "transacao")
public class TransacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "data_transacao", nullable = false)
    private LocalDate dataTransacao;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaEntity categoriaEntity;

    @ManyToOne
    @JoinColumn(name = "tipo_transacao_id", nullable = false)
    private TipoTransacaoEntity tipoTransacaoEntity;

    public TransacaoEntity() {}

    public TransacaoEntity(Long id, String descricao, BigDecimal valor, LocalDate dataTransacao, CategoriaEntity categoriaEntity, TipoTransacaoEntity tipoTransacaoEntity) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.categoriaEntity = categoriaEntity;
        this.tipoTransacaoEntity = tipoTransacaoEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TransacaoEntity transacao = (TransacaoEntity) o;
        return Objects.equals(id, transacao.id) && Objects.equals(descricao, transacao.descricao) && Objects.equals(valor, transacao.valor) && Objects.equals(dataTransacao, transacao.dataTransacao) && Objects.equals(categoriaEntity, transacao.categoriaEntity) && Objects.equals(tipoTransacaoEntity, transacao.tipoTransacaoEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, valor, dataTransacao, categoriaEntity, tipoTransacaoEntity);
    }

    public TipoTransacaoEntity getTipoTransacao() {
        return tipoTransacaoEntity;
    }

    public void setTipoTransacao(TipoTransacaoEntity tipoTransacaoEntity) {
        this.tipoTransacaoEntity = tipoTransacaoEntity;
    }

    public CategoriaEntity getCategoriaEntity() {
        return categoriaEntity;
    }

    public void setCategoriaEntity(CategoriaEntity categoriaEntity) {
        this.categoriaEntity = categoriaEntity;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }





}
