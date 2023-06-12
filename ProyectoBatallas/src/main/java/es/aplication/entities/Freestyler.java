package es.aplication.entities;

import java.util.HashSet; 
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
 

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import javax.persistence.ManyToMany;

@Entity
@Table(name="freestylers")
public class Freestyler {
	
	
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="edad")
	private int edad; 
	
	@ManyToMany(fetch =FetchType.EAGER)
    @JoinTable(
        name = "freestylers_batallas", 
        joinColumns = { @JoinColumn(name = "id_freestyler") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_batallas") }
    )
	@JsonIgnore
	private Set<Batalla> batallas;

	
	public Freestyler() {
		
	}
	
	public Freestyler(String n, int e) {
		nombre = n;
		batallas = new HashSet<Batalla>();
		edad = e;
		  
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Set<Batalla> getBatallas() {
		return batallas;
	}


	public void setBatallas(Set<Batalla> batalla) {
		this.batallas = batalla;
	}
	
	/*
	@Override
	public String toString() {
		String resultado=nombre+"--->>\nIngredientes:\n";
		for(Ingrediente in:ingredientes)
		{
			 resultado= resultado + in.toString();
		}
		resultado= resultado + "Precio: "+precio+" €\n";
		
		return resultado;			 
	}
*/
	
	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Freestyler [nombre=" + nombre + ", edad=" + edad + ", está en la batalla de=" + batallas + "]";
	}
	


}
