package com.apicontabil.apicontabil.controlefinanceiro.infra.relatorios;

public class ReportsException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ReportsException(String mensagem) {
        super(mensagem);
    }

    public ReportsException(String mensagem, Throwable e) {
        super(mensagem, e);
    }
}
