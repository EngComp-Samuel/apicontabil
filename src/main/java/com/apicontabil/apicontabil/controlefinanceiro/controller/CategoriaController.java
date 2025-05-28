package com.apicontabil.apicontabil.controlefinanceiro.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.apicontabil.apicontabil.controlefinanceiro.infraestrutura.CategoriaRepositoryImpl;
import com.apicontabil.apicontabil.exceptions.ApiContabilException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apicontabil.apicontabil.controlefinanceiro.dominio.modelo.Categoria;
import com.apicontabil.apicontabil.controlefinanceiro.dominio.repository.CategoriaRepository;
import com.apicontabil.apicontabil.controlefinanceiro.service.CategoriaService;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v1/controlefinanceiro/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	// INICIO DA IMPLANTACAO DO MODEL MAPPER PARA O PADRAO DTO
	//TODO: NÃO ESQUECER QUE EH NECESSARIO CRIAR UMA CLASS DE CONFIGURACAO E UM METODO BEAN
	@Autowired
	private ModelMapper modelMapper;
	// FIM DA IMPLANTACAO DO MODEL MAPPER PARA O PADRAO DTO

	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria) {
		
		Categoria salva = categoriaRepository.save(categoria);
		URI uri = UriComponentsBuilder.fromPath("api/v1/controlefinanceiro/categoria/{id}").buildAndExpand(salva.getId()).toUri();
		return ResponseEntity.created(uri).body(salva);
	}
	
	@GetMapping
	public List<Categoria> listarCategorias(){		
		return categoriaRepository.findAll();
	}
	
	@GetMapping(value = "/{categoriaId}")
	public ResponseEntity<?> pesquisarCategoria(@PathVariable Long categoriaId){

		try{
			Categoria cat = categoriaService.pesquisarCategoria(categoriaId);
			return ResponseEntity.ok(cat);
		} catch (ApiContabilException e) {
			return new ResponseEntity<>( "Recurso não encontrado", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/{categoriaId}")
	public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long categoriaId, @RequestBody Categoria categoria) {
		
		Optional<Categoria> cat = categoriaRepository.findById(categoriaId);
		
		if(cat != null) {
			BeanUtils.copyProperties(categoria, cat, "id");
			categoriaRepository.save(cat.get());
			return ResponseEntity.ok(cat.get());
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	@DeleteMapping(value = "/{categoriaId}")
	public ResponseEntity<?> removerCategoria(@PathVariable Long categoriaId){

		try {
			categoriaService.removerCategoria(categoriaId);
			return ResponseEntity.noContent().build();
		}catch (EmptyResultDataAccessException e){
			return ResponseEntity.notFound().build();
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}



	@GetMapping(value = "/nome")
	public List<Categoria> listarCategoriasPorNome(String nome){
		return categoriaRepository.buscarTodasCategoriasPorNome(nome);
	}
	
	
	
	
	
	
	
	
	

}
