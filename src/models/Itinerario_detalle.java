package models;

import javax.persistence.*;

import com.google.gson.JsonObject;

@Entity
@Table(name = "detalle_itinerario")
public class Itinerario_detalle {
	public Itinerario_detalle() {
	}

	@Id
	private int id;

	@ManyToOne
	@JoinColumn(name = "atraccion_id")
	private Atraccion atraccion;

	@ManyToOne
	@JoinColumn(name = "promo_id")
	private Promocion promo;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	
	
	/*Begin Getters and Setters*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Atraccion getAtraccion() {
		return atraccion;
	}

	public void setAtraccion(Atraccion atraccion) {
		this.atraccion = atraccion;
	}

	public Promocion getPromo() {
		return promo;
	}

	public void setPromo(Promocion promo) {
		this.promo = promo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/*-------------------------*/
	
	public String generateData() {

		JsonObject jsonObject = new JsonObject();
		
		jsonObject.addProperty("Id", getId());
		jsonObject.addProperty("itinerarioid", getId());
		jsonObject.addProperty("usuario", getUsuario().getNombre());

		
		if(this.getPromo().getPromocion_id()!=4) {
			jsonObject.addProperty("producto", getPromo().getNombre());
			jsonObject.addProperty("tipo", "Paquete");
			jsonObject.addProperty("descripcion", getPromo().getDescripcion());
			jsonObject.addProperty("costo", getPromo().getCosto());
			jsonObject.addProperty("tiempo", getPromo().getTiempo());
			
		}
		else {
			jsonObject.addProperty("producto", getAtraccion().getNombre());
			jsonObject.addProperty("tipo", getAtraccion().getTipos_atraccion().getNombre());
			jsonObject.addProperty("descripcion", getAtraccion().getDescripcion());
			jsonObject.addProperty("costo", getAtraccion().getCosto());
			jsonObject.addProperty("tiempo", getAtraccion().getTiempo());

		}
		
		return jsonObject.toString();
	}

}
