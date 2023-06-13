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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "batallas")
public class Batalla {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull(message = "No debe ser un valor nulo")
	@Column(name = "titulo")
	private String titulo;

	@NotNull(message = "No debe ser un valor nulo")
	@Column(name = "descripcion")
	private String descripcion;

	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fechaBatalla")
	private LocalDate fechaBatalla;

	@NotNull(message = "No debe ser un valor nulo")
	private String youtubeVideo;

	private String rutaPortada;

	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ronda_batalla", 
			   joinColumns = @JoinColumn(name = "id"), 
			   inverseJoinColumns = @JoinColumn(name = "id_ronda"))
	private List<Ronda> rondas;
	
	@Transient
	private MultipartFile portada;

}
