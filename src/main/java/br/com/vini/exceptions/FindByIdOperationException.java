package br.com.vini.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FindByIdOperationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public FindByIdOperationException(String message) {
		super(message);
	}
	

}
