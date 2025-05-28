package com.apicontabil.apicontabil.controlefinanceiro.service;

import com.apicontabil.apicontabil.exceptions.RestExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.apicontabil.apicontabil.controlefinanceiro.dominio.modelo.Categoria;
import com.apicontabil.apicontabil.controlefinanceiro.dominio.repository.CategoriaRepository;
import com.apicontabil.apicontabil.exceptions.ApiContabilException;

import java.util.NoSuchElementException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	//verificar a necessidade
	public Categoria pesquisarCategoria(Long id) {

		try{
			return categoriaRepository.findById(id).orElseThrow(); //buscarUmaCategoriaPorId(id);
		} catch (NoSuchElementException e) {
			throw new ApiContabilException("Não foram encontrados elementos");
		}
	}

	public void removerCategoria(Long id){
		try{
			categoriaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ApiContabilException("Não existe dados com esse codigo: " + id);
		} catch (DataIntegrityViolationException e) {
			throw new ApiContabilException("Essa entidade contem um relacionamento, ela esta em uso por outra entidade ");
		}
	}

	public void salvarCategoria(Long id){}

	public void atualizarCategoria(Long id){}

	public void listarCategoria(Long id){}
	
	
}
