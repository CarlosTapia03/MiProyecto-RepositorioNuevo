package es.aplication.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "batallas")
public class Batalla {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre")
    private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToOne 
	@JoinColumn(name = "id_juez", nullable = true)
	@JsonIgnore
	private Juez juez;

	@ManyToMany(mappedBy = "batallas", fetch = FetchType.EAGER)
	private Set<Freestyler> freestylers;

	public Juez getJuez() {
		return juez;
	}

	public void setAlumno(Juez juez) {
		this.juez = juez;
	}

	public Batalla() {
		freestylers = new HashSet<Freestyler>();
	}

	public Batalla(Juez j) {
		juez = j;
		freestylers = new HashSet<Freestyler>();

	}

	public Set<Freestyler> getFreestyler() {
		return freestylers;
	}

	public void setFreestyler(Set<Freestyler> freestylers) {
		this.freestylers = freestylers;
	}

	@Override
	public String toString() {
		return imprimirFreestylers();
	}

	public String imprimirFreestylers() {

		String resultado = "Freestylers de la batalla " + id + "\n";
		if (freestylers.size() == 0) {

		} else {
			for (Freestyler f : freestylers) {
				resultado = resultado + f.toString();
			}
		}
		return resultado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Freestyler> getFreestylers() {
		return freestylers;
	}

	public void setFreestylers(Set<Freestyler> freestylers) {
		this.freestylers = freestylers;
	}

	public void setJuez(Juez juez) {
		this.juez = juez;
	}
	
	

}
