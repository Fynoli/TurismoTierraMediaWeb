package models;

import javax.persistence.*;

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
	
	

}
