package es.aplication.service.interfaces;

import java.nio.file.Path;

import javax.annotation.Resource;

import org.springframework.web.multipart.MultipartFile;

public interface AlmacenServicio {

	public void iniciarAlmacenDeArchivos();
	
	public String almacenarArchivo(MultipartFile archivo);
	
	public Path cargarArchivo(String nombreArchivo);
	
	public Resource cargarComoRecurso(String nombreArchivo);
	
	public void eliminarArchivo(String nombreArchivo);
	
}
