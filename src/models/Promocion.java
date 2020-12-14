package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.google.gson.JsonObject;

@Entity
@Table(name = "promocion")
public class Promocion {

    public Promocion() {
    }
    
    @Id
    @Column(name="promocion_id")
    private int promocion_id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="costo")
    private int costo;
    
    @Column(name="tiempo")
    private double tiempo;
    
    @Column(name = "activo")
	private int activo;
    
    @ManyToMany(mappedBy = "promociones")
    private Set<Atraccion> atracciones = new HashSet<>();
    

    public void setId(int id) {
        this.promocion_id = id;
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

	public int getPromocion_id() {
		return promocion_id;
	}

	public void setPromocion_id(int promocion_id) {
		this.promocion_id = promocion_id;
	}

	public Set<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(Set<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	
	public int getCupo() {
		int cupo=Integer.MAX_VALUE;
		for(Atraccion a: this.getAtracciones()) {
			if(a.getCupo()<cupo) {
				cupo=a.getCupo();
			}
		}
		return cupo;
	}
	
	public String generateData() {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Id", this.getPromocion_id());
        jsonObject.addProperty("Nombre", getNombre());
        jsonObject.addProperty("Tipo", "Paquete");
        jsonObject.addProperty("Descripcion", getDescripcion());
        jsonObject.addProperty("Costo", getCosto());
        jsonObject.addProperty("Tiempo", getTiempo());
        jsonObject.addProperty("Cupo", getCupo());

        return jsonObject.toString();
    }
    
    
}
