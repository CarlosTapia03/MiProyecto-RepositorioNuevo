package es.aplication.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "batallas")
public class Batalla {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotBlank
	@Column(name = "titulo")
	private String titulo;

	@NotBlank
	@Column(name = "descripcion")
	private String descripcion;

	@NotBlank
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_batalla")
	private LocalDate fechaBatalla;

	@NotBlank
	@Column(name = "youtube_trailer_id")
	private String youtubeTrailerId;

	@Column(name = "ruta_portada")
	private String rutaPortada;

	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ronda_batalla", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id_ronda"))
	private List<Ronda> rondas;

	@Transient
	private MultipartFile portada;


	public Batalla() {
		super();
	}


	public Batalla(Integer id, @NotNull String titulo, @NotNull String descripcion, @NotNull LocalDate fechaBatalla,
			@NotNull String youtubeTrailerId, String rutaPortada, @NotEmpty List<Ronda> rondas, MultipartFile portada) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaBatalla = fechaBatalla;
		this.youtubeTrailerId = youtubeTrailerId;
		this.rutaPortada = rutaPortada;
		this.rondas = rondas;
		this.portada = portada;
	}


	public Batalla(@NotNull String titulo, @NotNull String descripcion, @NotNull LocalDate fechaBatalla,
			@NotNull String youtubeTrailerId, String rutaPortada, @NotEmpty List<Ronda> rondas, MultipartFile portada) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaBatalla = fechaBatalla;
		this.youtubeTrailerId = youtubeTrailerId;
		this.rutaPortada = rutaPortada;
		this.rondas = rondas;
		this.portada = portada;
	}

	

}
