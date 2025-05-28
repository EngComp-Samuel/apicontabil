package com.apicontabil.apicontabil.controlefinanceiro.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.apicontabil.apicontabil.exceptions.ApiContabilException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.apicontabil.apicontabil.controlefinanceiro.dominio.modelo.Receita;
import com.apicontabil.apicontabil.controlefinanceiro.dominio.repository.ReceitaRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	//Salvar
	public Receita salvarReceita(Receita receita){

		try {
			Receita receitaSalva = receitaRepository.save(receita);
			return receitaSalva;
		} catch (DataIntegrityViolationException e) {
			throw new ApiContabilException("Dados incorretos no envio da entidade");
		}
	}
	
	
	
	//Editar
	
	//Listar todas
	public List<Receita> listarTodas(){
		return receitaRepository.findAll();
	}
	
	//Listar com filtro
	public Receita buscarPorId(Long id){

		try{
			return receitaRepository.findById(id).orElseThrow();
		} catch (NoSuchElementException e) {
			throw new ApiContabilException("Não foram encontrados elementos");
		}
	}
	
	//Deletar
	public void deletar(Long id) {
		try{
			receitaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ApiContabilException("Não existe dados com esse codigo: " + id);
		} catch (DataIntegrityViolationException e) {
			throw new ApiContabilException("Essa entidade contem um relacionamento, ela esta em uso por outra entidade ");
		}
	}
}
