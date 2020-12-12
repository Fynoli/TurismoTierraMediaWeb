package models;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="atraccion")
public class Atraccion{

    public Atraccion() {
    }
    @Id
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column (name = "costo")
    private int costo;

    @Column (name = "tiempo")
    private double tiempo;

    @Column (name = "cupo")
    private int cupo;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoAtraccion tipos_atraccion;
    
    @ManyToMany()
    @JoinTable(
        name = "promocion_atraccion", 
        joinColumns = { @JoinColumn(name = "atraccion_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "promocion_id") }
    )
    Set<Promocion> promociones = new HashSet<>();
    
    

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
    
}
