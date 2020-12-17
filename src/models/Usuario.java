package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.google.gson.JsonObject;

@Entity
@Table(name = "usuario")
public class Usuario {

	public Usuario(String nombre, TipoAtraccion tipoAtraccion, int presupuesto, double tiempo_disponible,
			String password, int activo, String profile_pic, int esadmin) {
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

	@ManyToMany(mappedBy = "usuarios", fetch = FetchType.EAGER)
	private Set<Atraccion> atracciones = new HashSet<>();

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

	@OneToMany(mappedBy = "usuario")
	private Set<Itinerario_detalle> itinerario_detalle;

	public Usuario() {

	}
	// Begin Getters and Setters

	public TipoAtraccion getTipoAtraccion() {
		return tipoAtraccion;
	}

	public Set<Itinerario_detalle> getItinerario_detalle() {
		return itinerario_detalle;
	}

	public void setItinerario_detalle(Set<Itinerario_detalle> itinerario_detalle) {
		this.itinerario_detalle = itinerario_detalle;
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

	public Set<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(Set<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public boolean tieneEstaAtraccion(Atraccion atraccion) {
		for (Atraccion a : this.getAtracciones()) {
			if (a.getId() == atraccion.getId()) {
				return true;
			}
		}
		return false;
	}

	public boolean tieneAlgoDeEstaPromocion(Promocion promocion) {
		for (Atraccion adp : promocion.getAtracciones()) {
			for (Atraccion adu : this.getAtracciones()) {
				if (adp.getId() == adu.getId()) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean leGustaEstaPromocion(Promocion promocion) {
		for (Atraccion a : promocion.getAtracciones()) {
			if (a.getTipos_atraccion().getId() == this.getFav().getId()) {
				return true;
			}
		}
		return false;
	}

	public String generateData() {

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("Id", getId());
		jsonObject.addProperty("Nombre", getNombre());
		jsonObject.addProperty("Preferencia", getTipoAtraccion().getNombre());
		jsonObject.addProperty("Presupuesto", getPresupuesto());
		jsonObject.addProperty("Tiempo Disponible", getTiempo_disponible());
		jsonObject.addProperty("Activo", this.getActivo());
		jsonObject.addProperty("Admin", this.getEsadmin());

		return jsonObject.toString();
	}
}

// End Getters and setters
