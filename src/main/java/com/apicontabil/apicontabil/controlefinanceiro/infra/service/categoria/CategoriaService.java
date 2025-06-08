package com.apicontabil.apicontabil.controlefinanceiro.infra.service.categoria;

import com.apicontabil.apicontabil.controlefinanceiro.app.mapper.categoria.CategoriaMapper;
import com.apicontabil.apicontabil.controlefinanceiro.app.service.categoria.CategoriaServiceUseCase;
import com.apicontabil.apicontabil.controlefinanceiro.domain.dto.CategoriaDTO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.CategoriaEntity;
import com.apicontabil.apicontabil.controlefinanceiro.domain.repository.CategoriaJpaRepository;
import com.apicontabil.apicontabil.exceptions.ApiContabilException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoriaService implements CategoriaServiceUseCase {

	@Autowired
	private CategoriaJpaRepository categoriaJpaRepository;

	@Autowired
	private CategoriaMapper categoriaMapper;


	@Override
	public CategoriaEntity salvarCategoria(CategoriaDTO categoria) {
		CategoriaEntity categoriaSalvar = categoriaMapper.toEntity(categoria);
		return categoriaJpaRepository.save(categoriaSalvar);
	}

	@Override
	public CategoriaEntity buscarCategoriaPorId(Long id) {
		try{
			return categoriaJpaRepository.findById(id).orElseThrow(); //buscarUmaCategoriaPorId(id);
		} catch (NoSuchElementException e) {
			throw new ApiContabilException("Não foram encontrados elementos");
		}
	}

	@Override
	public List<CategoriaEntity> listarCategorias() {
		//adicionar uma validacao de lista vazia, ou seja, se contem elementos ou nao
		return categoriaJpaRepository.findAll();
	}

	public void removerCategoria(Long id){
		try{
			CategoriaEntity categoriaEntity = buscarCategoriaPorId(id);
			categoriaJpaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ApiContabilException("Não existe dados com esse codigo: " + id);
		} catch (DataIntegrityViolationException e) {
			throw new ApiContabilException("Essa entidade contem um relacionamento, ela esta em uso por outra entidade ");
		}
	}

	@Override
	public CategoriaEntity atualizarCategoria(CategoriaDTO categoriaDTO, Long id) {

		Optional<CategoriaEntity> cat = categoriaJpaRepository.findById(id);

		if(cat != null) {
			BeanUtils.copyProperties(categoriaDTO, cat.get(), "id");
		}
			return categoriaJpaRepository.save(categoriaMapper.toEntity(categoriaDTO));
	}

	@Override
	public List<CategoriaEntity> listarCategoriasPorNome(String nome) {
		List<CategoriaEntity> categoriaEntity = categoriaJpaRepository.listarCategoriasPorNome(nome);
		return categoriaEntity;
	}
}
