package br.com.mattec.loja.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.mattec.loja.services.exceptions.ControllerNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ControllerNotFoundException.class)
	public ResponseEntity<StandardError> registroNaoEncontrado(
			ControllerNotFoundException e, HttpServletRequest request){
		String error ="Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(),
				status.value(),
				error,
				e.getMessage(),
				request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	
	
	

}
