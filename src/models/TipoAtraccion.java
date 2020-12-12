package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_atraccion")
public class TipoAtraccion {
    public TipoAtraccion() {
    }
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "tipoAtraccion")
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    @OneToMany(mappedBy = "tipos_atraccion")// mapeado al atributo de la relacion
    private List<Atraccion> atracciones = new ArrayList<Atraccion>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Atraccion> getAtracciones() {
        return atracciones;
    }

    public void setAtracciones(List<Atraccion> atracciones) {
        this.atracciones = atracciones;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
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


 }

