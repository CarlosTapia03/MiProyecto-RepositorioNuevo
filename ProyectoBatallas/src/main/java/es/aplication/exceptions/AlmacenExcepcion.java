package es.aplication.exceptions;

public class AlmacenExcepcion extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -341292501937016085L;

	
	public AlmacenExcepcion(String mensaje) {
		super(mensaje);
	}
	
	public AlmacenExcepcion(String mensaje, Throwable excepcion) {
		super(mensaje, excepcion);
	}
}
