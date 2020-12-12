package models;

import javax.persistence.*;
@Entity
@Table(name = "tipo_descuento_promocion")
public class Tipo_Descuento_Promocion {
    public Tipo_Descuento_Promocion() {
    }
    @Id
    private int id;

    @Column(name = "nombre")
    private String nombre;

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
}
