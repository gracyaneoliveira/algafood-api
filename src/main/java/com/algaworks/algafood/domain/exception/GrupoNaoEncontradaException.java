package com.algaworks.algafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND )
public class GrupoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public GrupoNaoEncontradaException(String message) {
		super(message);
	}
	
	public GrupoNaoEncontradaException(Long grupoId) {
		this(String.format("Não existe um cadastro de grupo com código %d", grupoId));
	}

}
