package com.apicontabil.apicontabil.controlefinanceiro.infra.service.receita;

import java.util.List;
import java.util.NoSuchElementException;

import com.apicontabil.apicontabil.exceptions.ApiContabilException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.ReceitaEntity;
import com.apicontabil.apicontabil.controlefinanceiro.domain.repository.ReceitaJpaRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaJpaRepository receitaJpaRepository;
	
	//Salvar
	public ReceitaEntity salvarReceita(ReceitaEntity receitaEntity){

		try {
			ReceitaEntity receitaEntitySalva = receitaJpaRepository.save(receitaEntity);
			return receitaEntitySalva;
		} catch (DataIntegrityViolationException e) {
			throw new ApiContabilException("Dados incorretos no envio da entidade");
		}
	}
	
	
	
	//Editar
	
	//Listar todas
	public List<ReceitaEntity> listarTodas(){
		return receitaJpaRepository.findAll();
	}
	
	//Listar com filtro
	public ReceitaEntity buscarPorId(Long id){

		try{
			return receitaJpaRepository.findById(id).orElseThrow();
		} catch (NoSuchElementException e) {
			throw new ApiContabilException("Não foram encontrados elementos");
		}
	}
	
	//Deletar
	public void deletar(Long id) {
		try{
			receitaJpaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ApiContabilException("Não existe dados com esse codigo: " + id);
		} catch (DataIntegrityViolationException e) {
			throw new ApiContabilException("Essa entidade contem um relacionamento, ela esta em uso por outra entidade ");
		}
	}
}
