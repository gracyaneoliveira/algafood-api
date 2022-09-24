package com.algaworks.algafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND ) 
public class ProdutoNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public ProdutoNaoEncontradoException(String message) {
		super(message);
	}
	
	public ProdutoNaoEncontradoException(Long produtoId, Long restauranteId) {
		this(String.format("Não existe um cadastro de produto com código %d para o restaurante de código %d", produtoId, restauranteId));
	}
}