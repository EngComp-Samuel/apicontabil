package com.apicontabil.apicontabil.controlefinanceiro.controller;

import java.net.URI;
import java.util.List;

import com.apicontabil.apicontabil.controlefinanceiro.dominio.repository.ReceitaRepository;
import com.apicontabil.apicontabil.controlefinanceiro.service.CategoriaService;
import com.apicontabil.apicontabil.exceptions.ApiContabilException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apicontabil.apicontabil.controlefinanceiro.dominio.modelo.Categoria;
import com.apicontabil.apicontabil.controlefinanceiro.dominio.modelo.Receita;
import com.apicontabil.apicontabil.controlefinanceiro.service.ReceitaService;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v1/controlefinanceiro/receita")
public class ReceitaController {
	
	@Autowired
	private ReceitaService receitaService;

	@Autowired
	private ReceitaRepository receitaRepository;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public List<Receita> listarReceitas() {
		return receitaService.listarTodas();
	}
	
	@PostMapping
	public ResponseEntity<?> salvarReceita(@RequestBody Receita receita) {

		try{
			Receita receitaSalva = receitaService.salvarReceita(receita);
			Categoria categoriaDaReceita = categoriaService.pesquisarCategoria(receitaSalva.getCategoria().getId());
			URI uri = UriComponentsBuilder.fromPath("api/v1/controlefinanceiro/receita/{id}").buildAndExpand(receitaSalva.getId()).toUri();
			return ResponseEntity.created(uri).body(receitaSalva);
		} catch (ApiContabilException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarReceita(@RequestBody Receita receita, @PathVariable Long id){
		try{
			Receita receitaParaSalvar = receitaService.buscarPorId(id);

			if(receitaParaSalvar != null){
				BeanUtils.copyProperties(receita, receitaParaSalvar, "id");
				receitaParaSalvar = receitaService.salvarReceita(receitaParaSalvar);
				return ResponseEntity.ok(receitaParaSalvar);
			}
			return ResponseEntity.notFound().build();
		} catch (ApiContabilException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> removerReceita(@PathVariable Long id){
		try {
			receitaService.deletar(id);
			return ResponseEntity.noContent().build();
		}catch (EmptyResultDataAccessException e){
			return ResponseEntity.notFound().build();
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	
	

}
