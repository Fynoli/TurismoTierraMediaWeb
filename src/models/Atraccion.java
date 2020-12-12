package models;
import javax.persistence.*;
import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="atraccion")
public class Atraccion {
	public Atraccion() {
	}

	@Id
    private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="costo")
	private int costo;
	
	@Column(name="tiempo")
	private Double tiempo;
	
	@Column(name="cupo")
	private int cupo;
	
	@Column(name="tipo_id")
	private int tipo_id;



	public int getTipo_id() {
		return tipo_id;
	}


	public void setTipo_id(int tipo_id) {
		this.tipo_id = tipo_id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getCosto() {
		return costo;
	}


	public void setCosto(int costo) {
		this.costo = costo;
	}


	public Double getTiempo() {
		return tiempo;
	}


	public void setTiempo(Double tiempo) {
		this.tiempo = tiempo;
	}


	public int getCupo() {
		return cupo;
	}


	public void setCupo(int cupo) {
		this.cupo = cupo;
	}


//	public TipoAtraccion getTipo() {
//		return tipo;
//	}
//	
//	
//	public String getNombreTipo() { 
//		return tipo.getNombre();
//	}
//
//
//	public void setTipo(TipoAtraccion tipo) {
//		this.tipo = tipo;
//	}
//	
}
