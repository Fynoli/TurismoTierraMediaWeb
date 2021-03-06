package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.google.gson.JsonObject;


@Entity
@Table(name = "atraccion")
public class Atraccion {

	public Atraccion() {
	}

	@Id
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "costo")
	private int costo;

	@Column(name = "tiempo")
	private double tiempo;

	@Column(name = "cupo")
	private int cupo;

	@Column(name = "activo")
	private int activo;

	@ManyToOne
	@JoinColumn(name = "tipo_id")
	private TipoAtraccion tipos_atraccion;
	
	@ManyToMany(mappedBy = "atracciones", fetch = FetchType.EAGER)
    private Set<Promocion> promociones = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "detalle_itinerario", joinColumns = {
			@JoinColumn(name = "atraccion_id") }, inverseJoinColumns = { @JoinColumn(name = "usuario_id") })
	Set<Usuario> usuarios = new HashSet<>();
	

	/* Begin getters and setters */
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

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public TipoAtraccion getTipos_atraccion() {
		return tipos_atraccion;
	}

	public void setTipos_atraccion(TipoAtraccion tipos_atraccion) {
		this.tipos_atraccion = tipos_atraccion;
	}
	
	/* End Getters and setters */

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public Set<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(Set<Promocion> promociones) {
		this.promociones = promociones;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		
		return "[\""+this.nombre+"\",\""+this.tipos_atraccion.getNombre()+"\",\""+this.descripcion+"\",\""+Integer.valueOf(this.costo).toString()+"\",\""+Double.valueOf(this.tiempo).toString()+"\"]";
	}
	
	public String generateData() {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Id", getId());
        jsonObject.addProperty("Nombre", getNombre());
        jsonObject.addProperty("Tipo", getTipos_atraccion().getNombre());
        jsonObject.addProperty("Descripcion", getDescripcion());
        jsonObject.addProperty("Costo", getCosto());
        jsonObject.addProperty("Tiempo", getTiempo());
        jsonObject.addProperty("Cupo", getCupo());
        jsonObject.addProperty("Activo", this.getActivo());

        return jsonObject.toString();
    }
	
	
}
