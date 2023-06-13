package es.aplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FileNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -341292501937016085L;

	
	public FileNotFoundException(String mensaje) {
		super(mensaje);
	}
	
	public FileNotFoundException(String mensaje, Throwable excepcion) {
		super(mensaje, excepcion);
	}
}
