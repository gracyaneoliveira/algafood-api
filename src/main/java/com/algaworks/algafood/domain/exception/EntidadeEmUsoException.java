package com.algaworks.algafood.domain.exception;

public class EntidadeEmUsoException extends NegocioException{

	// https://blog.algaworks.com/serialversionuid/
	private static final long serialVersionUID = 1L;
	
	public EntidadeEmUsoException(String message) {
		super(message);
	}

}
