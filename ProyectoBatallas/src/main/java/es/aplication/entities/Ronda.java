package es.aplication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ronda {
	
	@Id
	@Column(name = "id_ronda")
	private Integer id;

	@NotNull
	@Column(name = "titulo")
	private String titulo;

	public Ronda(Integer id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public Ronda() {
		super();
	}

	public Ronda(Integer id) {
		super();
		this.id = id;
	}

	public Ronda(String titulo) {
		super();
		this.titulo = titulo;
	}

	
	
}
