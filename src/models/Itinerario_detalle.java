package models;

import  javax.persistence.*;

@Entity
@Table(name = "detalle_itinerario")
public class Itinerario_detalle {
    public Itinerario_detalle() {
    }
    @Id
    private int id;

   @ManyToOne
   @JoinColumn(name = "itinerario_id")
   private Itinerario itinerario;

    @ManyToOne
    @JoinColumn(name="atraccion_id")
    private Atraccion atraccion;

    @ManyToOne
    @JoinColumn(name = "promo_id")
    private Promocion promo;

}
