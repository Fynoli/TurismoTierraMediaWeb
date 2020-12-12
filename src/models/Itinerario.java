package models;

import  javax.persistence.*;

@Entity
@Table(name = "itinerario")
public class Itinerario {
    public Itinerario() {
    }
   @Id
   private int id;

    @Column(name = "fecha")
    private  int fecha;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
