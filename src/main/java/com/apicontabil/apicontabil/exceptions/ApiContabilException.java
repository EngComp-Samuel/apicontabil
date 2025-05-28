package com.apicontabil.apicontabil.exceptions;

public class ApiContabilException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private int codigoErrr;

	public ApiContabilException(String mensagem) {
		super(mensagem);
	}
	
	public ApiContabilException(int codErro, String mensagem) {
		super(mensagem);
		this.codigoErrr = codErro;
	}
	
	public ApiContabilException(Exception e) {
		super(e);
	}
	
	public ApiContabilException(String mensagem, Exception e) {
		super(mensagem, e);
	}
	
	public ApiContabilException(Long id) {
		this(String.format("Não existe um cadastro com código %d", id));
	}
	
	
	public int getCodigoErrr() {
		return codigoErrr;
	}

	public void setCodigoErrr(int codigoErrr) {
		this.codigoErrr = codigoErrr;
	}

	@Override
	public String toString() {
		return super.toString() + 
				" ApiContabilException [codigoErrr=" + codigoErrr + "]"; 
		
	}

}
