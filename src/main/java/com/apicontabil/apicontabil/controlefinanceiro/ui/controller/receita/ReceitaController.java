package com.apicontabil.apicontabil.controlefinanceiro.ui.controller.receita;

import java.net.URI;
import java.util.List;

import com.apicontabil.apicontabil.controlefinanceiro.domain.repository.ReceitaJpaRepository;
import com.apicontabil.apicontabil.controlefinanceiro.infra.service.categoria.CategoriaService;
import com.apicontabil.apicontabil.exceptions.ApiContabilException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.CategoriaEntity;
import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.ReceitaEntity;
import com.apicontabil.apicontabil.controlefinanceiro.infra.service.receita.ReceitaService;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v1/controlefinanceiro/receita")
public class ReceitaController {
	
	@Autowired
	private ReceitaService receitaService;

	@Autowired
	private ReceitaJpaRepository receitaJpaRepository;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public List<ReceitaEntity> listarReceitas() {
		return receitaService.listarTodas();
	}
	
	/*@PostMapping
	public ResponseEntity<?> salvarReceita(@RequestBody ReceitaEntity receitaEntity) {

		try{
			ReceitaEntity receitaEntitySalva = receitaService.salvarReceita(receitaEntity);
			CategoriaEntity categoriaEntityDaReceita = categoriaService.pesquisarCategoria(receitaEntitySalva.getCategoria().getId());
			URI uri = UriComponentsBuilder.fromPath("api/v1/controlefinanceiro/receita/{id}").buildAndExpand(receitaEntitySalva.getId()).toUri();
			return ResponseEntity.created(uri).body(receitaEntitySalva);
		} catch (ApiContabilException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}*/

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarReceita(@RequestBody ReceitaEntity receitaEntity, @PathVariable Long id){
		try{
			ReceitaEntity receitaEntityParaSalvar = receitaService.buscarPorId(id);

			if(receitaEntityParaSalvar != null){
				BeanUtils.copyProperties(receitaEntity, receitaEntityParaSalvar, "id");
				receitaEntityParaSalvar = receitaService.salvarReceita(receitaEntityParaSalvar);
				return ResponseEntity.ok(receitaEntityParaSalvar);
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
