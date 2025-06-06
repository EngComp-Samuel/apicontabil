package com.apicontabil.apicontabil.controlefinanceiro.domain.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ReceitaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;
	
	@Column(name = "data_receita", nullable = false)
	private LocalDate dataReceita;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private CategoriaEntity categoriaEntity;
	
	public ReceitaEntity() {}
	
	public ReceitaEntity(Long id, String descricao, BigDecimal valor, LocalDate dataReceita, CategoriaEntity categoriaEntity) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.dataReceita = dataReceita;
		this.categoriaEntity = categoriaEntity;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDataReceita() {
		return dataReceita;
	}

	public void setDataReceita(LocalDate dataReceita) {
		this.dataReceita = dataReceita;
	}

	public CategoriaEntity getCategoria() {
		return categoriaEntity;
	}

	public void setCategoria(CategoriaEntity categoriaEntity) {
		this.categoriaEntity = categoriaEntity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoriaEntity, dataReceita, descricao, id, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReceitaEntity other = (ReceitaEntity) obj;
		return Objects.equals(categoriaEntity, other.categoriaEntity) && Objects.equals(dataReceita, other.dataReceita)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(valor, other.valor);
	}

}
