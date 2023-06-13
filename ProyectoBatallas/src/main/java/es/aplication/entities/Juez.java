package es.aplication.entities;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="jueces")
public class Juez {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;

	
//	@OneToMany(cascade = { CascadeType.MERGE },mappedBy="juez",fetch=FetchType.EAGER )
//	//@JsonIgnore
//	private Set<Batalla> batallas;
//	
//	
//	public Juez() {
//		batallas = new HashSet<Batalla>();
//	}
//	public Juez(String n) {
//		batallas = new HashSet<Batalla>();
//		nombre = n;	 
//	}
//	
//		
//	public Set<Batalla> getbatallas() {
//		return batallas;
//		
//	}
//
//	public void setbatallas(Set<Batalla> batallas) {
//		this.batallas = batallas;
//	}
//	
//
//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//		 
//	}
//	
//	
//	
//	@Override
//	public String toString() {
//		return "Id_Juez: "+id+"   Nombre: "+nombre+"\n" 
//				+imprimirBatalla();
//	}
//	
//	
//	public String imprimirBatalla() {
//		
//		String resultado="batalla del juez "+nombre+"\n";
//		if(batallas.size()==0) {
//			resultado = (nombre+" No juecea batallas");
//		}else {
//			for(Batalla b:batallas) {
//				resultado = resultado + b.toString();
//			}
//		}
//		return resultado;
//	}
//	
//	 
//	public void imprimirJuez(List<Juez> lista) {
//		for(Juez j:lista) {
//			System.out.println(j.toString());
//		}
//	}
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
	
	
	

}
