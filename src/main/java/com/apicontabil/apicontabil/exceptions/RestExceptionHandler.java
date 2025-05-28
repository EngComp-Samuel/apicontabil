package com.apicontabil.apicontabil.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

	
	//ISSO AQUI EH MUITO PODEROSO
	//VER LINK: https://medium.com/@felipeacelinoo/como-tratar-exce%C3%A7%C3%B5es-em-uma-api-rest-com-spring-boot-utilizando-restcontrolleradvice-e-af6732559d59
	
	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity<ApiErros> genericException(Exception e){
		
		ApiErros apiErros = ApiErros.of(
				LocalDateTime.now(), 
				HttpStatus.INTERNAL_SERVER_ERROR.value(), 
				HttpStatus.INTERNAL_SERVER_ERROR.name(), 
				List.of(e.getMessage()));
		
		return new ResponseEntity<>(apiErros, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	//TODO: ESSE STATUS CODE REFLETE LA NO POSTMAN, MESMO TRATANDO NO SERVICE E CONTROLLER, VERIFICAR A POSSIBILIDADE
	//DE CRIAR UMA EXCEPTION PARA CADA EXCEÇÃO E DEPOIS CRIAR UMA CLASSE QUE REPRESENTE ISSO
	@ExceptionHandler(exception = ApiContabilException.class)
	public ResponseEntity<ApiErros> produtoNaoEncontrado(Exception e){
		
		ApiErros apiErros = ApiErros.of(
				LocalDateTime.now(), 
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.name(),
				List.of(e.getMessage()));
		
		return new ResponseEntity<>(apiErros, HttpStatus.NOT_FOUND);
		
	}

	/*@ExceptionHandler(exception = ApiContabilException.class)
	public ResponseEntity<ApiErros> erroInternoServidor(Exception e){

		ApiErros apiErros = ApiErros.of(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				HttpStatus.BAD_REQUEST.name(),
				List.of(e.getMessage()));

		return new ResponseEntity<>(apiErros, HttpStatus.BAD_REQUEST);

	}


	@ExceptionHandler(exception = ApiContabilException.class)
	public ResponseEntity<ApiErros> erroConflito(Exception e){

		ApiErros apiErros = ApiErros.of(
				LocalDateTime.now(),
				HttpStatus.CONFLICT.value(),
				HttpStatus.CONFLICT.name(),
				List.of(e.getMessage()));

		return new ResponseEntity<>(apiErros, HttpStatus.CONFLICT);

	}*/
	
	
	
	
}
