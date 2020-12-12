package models;

import javax.persistence.*;

@Entity
@Table(name = "promocion")
public class Promocion {
    private String id;

    public Promocion() {
    }
    @Id
    private int promocion_id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="descuento")
    private String descuento;

    @Column(name="costo")
    private int costo;

    @ManyToOne
    @JoinColumn(name = "tipo_promocion")
    private Tipo_Descuento_Promocion tipo_promo;

    public String getId() {
        return id;
    }

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

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Tipo_Descuento_Promocion getTipo_promo() {
        return tipo_promo;
    }

    public void setTipo_promo(Tipo_Descuento_Promocion tipo_promo) {
        this.tipo_promo = tipo_promo;
    }

    public void setId(String id) {
        this.id = id;
    }
}
