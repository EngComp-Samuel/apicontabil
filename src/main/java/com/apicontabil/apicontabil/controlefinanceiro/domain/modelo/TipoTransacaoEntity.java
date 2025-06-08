package com.apicontabil.apicontabil.controlefinanceiro.domain.modelo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tipo_transacao")
public class TipoTransacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    public TipoTransacaoEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoTransacaoEntity(String nome){
        this.nome = nome;
    }

    public TipoTransacaoEntity(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TipoTransacaoEntity that = (TipoTransacaoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "TipoTransacao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }




}
