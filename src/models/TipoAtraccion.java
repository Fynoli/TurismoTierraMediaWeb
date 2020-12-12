package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tipo_atraccion")
public class TipoAtraccion {
	
	public TipoAtraccion() {
		}

		@Id
	    private int id;
		
		@Column(name="nombre")
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
