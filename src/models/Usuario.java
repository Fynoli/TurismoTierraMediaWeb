package models;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {

	public Usuario(String nombre, TipoAtraccion tipoAtraccion, int presupuesto, double tiempo_disponible, String password, int activo, String profile_pic, int esadmin) {
		this.nombre = nombre;
		this.tipoAtraccion = tipoAtraccion;
		this.presupuesto = presupuesto;
		this.tiempo_disponible = tiempo_disponible;
		this.password = password;
		this.activo = activo;
		this.profile_pic = profile_pic;
		this.esadmin = esadmin;
	}

	@Id
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "idtipoatraccion")
	private TipoAtraccion tipoAtraccion;

	@Column(name = "presupuesto")
	private int presupuesto;

	@Column(name = "tiempo_disponible")
	private double tiempo_disponible;

	@Column(name = "password")
	private String password;

	@Column(name = "activo")
	private int activo;

	@Column(name = "profile_pic")
	private String profile_pic;


	@Column(name = "esadmin")
	private int esadmin;


	public Usuario() {

	}
	//Begin Getters and Setters


	public TipoAtraccion getTipoAtraccion() {
		return tipoAtraccion;
	}

	public void setTipoAtraccion(TipoAtraccion tipoAtraccion) {

		this.tipoAtraccion = tipoAtraccion;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TipoAtraccion getFav() {
		return tipoAtraccion;
	}

	public void setFav(TipoAtraccion fav) {
		this.tipoAtraccion = fav;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public double getTiempo_disponible() {
		return tiempo_disponible;
	}

	public void setTiempo_disponible(double tiempo_disponible) {
		this.tiempo_disponible = tiempo_disponible;
	}

	public String getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public int getEsadmin() {
		return esadmin;
	}

	public void setEsadmin(int esadmin) {
		this.esadmin = esadmin;
	}
}
	
	
	
	//End Getters and setters


