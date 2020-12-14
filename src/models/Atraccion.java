package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "atraccion")
public class Atraccion {

	public Atraccion() {
	}

	public Atraccion(String nombre, String descripcion, int costo, double tiempo, int cupo, int tipo_id) {
		this.id = 0;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.activo = 1;
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

	@ManyToMany()
	@JoinTable(name = "promocion_atraccion", joinColumns = {
			@JoinColumn(name = "atraccion_id") }, inverseJoinColumns = { @JoinColumn(name = "promocion_id") })
	Set<Promocion> promociones = new HashSet<>();

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

	public Set<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(Set<Promocion> promociones) {
		this.promociones = promociones;
	}
	/* End Getters and setters */

	/**
	 * Devuelve los atributos del objeto en un array de strings para ser colocados
	 * en un datatable
	 * 
	 * @return String[]
	 */
	public String[] dumpDataAsArray() {
		String[] data = new String[4];
		data[0] = this.nombre;
		data[1] = this.descripcion;
		data[2] = Integer.valueOf(this.costo).toString();
		data[3] = Double.valueOf(this.tiempo).toString();
		return data;
	}

	/**
	 * Devuelve los atributos del objeto en una lista de strings para ser colocados
	 * en un datatable
	 * 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> dumpDataAsArrayList() {
		ArrayList<String> data = new ArrayList<String>();
		data.add(this.nombre);
		data.add(this.descripcion);
		data.add(Integer.valueOf(this.costo).toString());
		data.add(Double.valueOf(this.tiempo).toString());

		return data;
	}

	@Override
	public String toString() {
		
		return "[\""+this.nombre+"\",\""+this.tipos_atraccion.getNombre()+"\",\""+this.descripcion+"\",\""+Integer.valueOf(this.costo).toString()+"\",\""+Double.valueOf(this.tiempo).toString()+"\"]";
	}
	
	
}
