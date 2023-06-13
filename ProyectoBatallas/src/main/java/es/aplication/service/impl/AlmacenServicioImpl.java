package es.aplication.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import es.aplication.exceptions.AlmacenExcepcion;
import es.aplication.service.interfaces.AlmacenServicio;

@Service
public class AlmacenServicioImpl implements AlmacenServicio{

	@Value("${storage.location}")
	private String storageLocation;
	
	//Sirve para indicar que este metodo se va a ejecutar cada vez que haya una nueva instancia de esta clase
	@PostConstruct
	@Override
	public void iniciarAlmacenDeArchivos() {
		// TODO Auto-generated method stub
		try {
			Files.createDirectories(Paths.get(storageLocation));
		}catch (IOException exception) {
			throw new AlmacenExcepcion("Error al inicializar la ubicación en el almacen de archivos");
		}
	}

	@Override
	public String almacenarArchivo(MultipartFile archivo) {
		// TODO Auto-generated method stub
		String nombreArchivo = archivo.getOriginalFilename();
		if (archivo.isEmpty()) {
			throw new AlmacenExcepcion("No se puede almacenar un archivo vacio");
		}try {
			InputStream inputStream = archivo.getInputStream();
			Files.copy(inputStream, Paths.get(storageLocation).resolve(nombreArchivo),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException exception) {
			throw new AlmacenExcepcion("Error al almacenar el archivo " + nombreArchivo,exception);
		}
		return nombreArchivo;
	}

	@Override
	public Path cargarArchivo(String nombreArchivo) {
		// TODO Auto-generated method stub
		
		
		return Paths.get(storageLocation).resolve(nombreArchivo);
	}

	@Override
	public Resource cargarComoRecurso(String nombreArchivo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarArchivo(String nombreArchivo) {
		// TODO Auto-generated method stub
		
	}

}
