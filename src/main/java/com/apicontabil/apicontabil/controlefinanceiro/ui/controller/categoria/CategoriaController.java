package com.apicontabil.apicontabil.controlefinanceiro.ui.controller.categoria;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.apicontabil.apicontabil.controlefinanceiro.app.mapper.categoria.CategoriaMapper;
import com.apicontabil.apicontabil.controlefinanceiro.domain.dto.CategoriaDTO;
import com.apicontabil.apicontabil.controlefinanceiro.infra.utils.ResourceUriUtils;
import com.apicontabil.apicontabil.exceptions.ApiContabilException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.CategoriaEntity;
import com.apicontabil.apicontabil.controlefinanceiro.domain.repository.CategoriaJpaRepository;
import com.apicontabil.apicontabil.controlefinanceiro.infra.service.categoria.CategoriaService;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v1/controlefinanceiro/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaJpaRepository categoriaJpaRepository;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private CategoriaMapper categoriaMapper;

	//ok
	@PostMapping
	public ResponseEntity<CategoriaDTO> salvarCategoria(@RequestBody CategoriaDTO categoria) {
		CategoriaEntity salva = categoriaService.salvarCategoria(categoria);
		ResourceUriUtils.addUriInResponseHeader(salva.getId());
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaMapper.toDTO(salva));
	}

	//ok
	@GetMapping
	public List<CategoriaDTO> listarCategorias(){

		List<CategoriaEntity> categoriaEntities = categoriaService.listarCategorias();
		List<CategoriaDTO> categorias = new ArrayList<>();
		for(CategoriaEntity c: categoriaEntities){
			categorias.add(categoriaMapper.toDTO(c));
		}
		return categorias;
	}

	//ok
	@GetMapping(value = "/{categoriaId}")
	public ResponseEntity<?> buscarCategoriaPorId(@PathVariable Long categoriaId){

		try{
			CategoriaEntity cat = categoriaService.buscarCategoriaPorId(categoriaId);
			CategoriaDTO categoriaDTO = categoriaMapper.toDTO(cat);
			return ResponseEntity.ok(categoriaDTO);
		} catch (ApiContabilException e) {
			return new ResponseEntity<>( "Recurso não encontrado", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/{categoriaId}")
	public ResponseEntity<CategoriaDTO> atualizarCategoria(@RequestBody CategoriaDTO categoriaDTO, @PathVariable Long categoriaId) {

		CategoriaEntity cat = categoriaService.atualizarCategoria(categoriaDTO, categoriaId);
		if(cat != null){
			return ResponseEntity.ok(categoriaMapper.toDTO(cat));
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * @OBSERVACAO = AQUI EH NECESSARIO FAZER UMA VALIDACAO OU CONTROLE DE ACESSO
	 */
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
	public List<CategoriaDTO> listarCategoriasPorNome(String nome){
		List<CategoriaEntity> categoriaEntities = categoriaService.listarCategoriasPorNome(nome);
		List<CategoriaDTO> categoriaDTOList = new ArrayList<>();
		for(CategoriaEntity c: categoriaEntities){
			categoriaDTOList.add(categoriaMapper.toDTO(c));
		}
		return categoriaDTOList;
	}
}
