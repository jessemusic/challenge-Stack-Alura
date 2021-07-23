package br.com.mattec.loja.services.exceptions;

public class ControllerNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ControllerNotFoundException(Object id) {
		super("Não há registro com essa chamada! Id "+ id);
	}

}
