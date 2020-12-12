package models;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="usuario")
public class Usuario {
	
	public Usuario() {
    }
	
	@Id
    private int id;
	
	@Column (name = "nombre")
    private String nombre;
	
	@Column (name = "password")
	private String password;
	
	@Column (name = "atraccion_favorita")
	private int fav;
    
	@Column (name = "presupuesto")
	private int presupuesto;
	
	@Column (name = "tiempo_disponible")
    private double tiempo_disponible;
	
	@Column (name= "profile_pic")
	private String profile_pic;
	
	@Column (name= "activo")
	private int activo;
	
	@Column (name= "esadmin")
	private int esadmin;
	
	@OneToOne
	@JoinColumn(name="id")
	private TipoAtraccion tipo;
	
	
	//Begin Getters and Setters
	
	public String getTipo() {
		return tipo.getNombre();
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

	public int getFav() {
		return fav;
	}

	public void setFav(int fav) {
		this.fav = fav;
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
	
	
	
	//End Getters and setters
    

    
}
