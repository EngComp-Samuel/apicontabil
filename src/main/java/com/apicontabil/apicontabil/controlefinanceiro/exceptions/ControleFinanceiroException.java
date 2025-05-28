package com.apicontabil.apicontabil.controlefinanceiro.exceptions;

import com.apicontabil.apicontabil.exceptions.ApiContabilException;

public class ControleFinanceiroException extends ApiContabilException{

	private static final long serialVersionUID = 1L;

	public ControleFinanceiroException(Exception e) {
		super(e);
	}

}
