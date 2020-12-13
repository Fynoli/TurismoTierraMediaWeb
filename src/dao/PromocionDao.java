package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import database.HibernateUtil;
import models.Atraccion;
import models.Promocion;
import models.Usuario;

public class PromocionDao {
	
	public List<Promocion> getPromocionesFavoritas(Usuario usuario) {
		List<Promocion> promociones=new ArrayList<Promocion>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (List<Promocion>) session
	        		.createQuery("FROM Atraccion A WHERE A.costo <= :presupuesto AND A.tiempo <= :tiempo AND A.tipo_id = :fav order by A.costo desc, A.tiempo desc")
	        		.setParameter("tiempo", usuario.getTiempo_disponible())
	        		.setParameter("presupuesto", usuario.getPresupuesto())
	        		.setParameter("fav", usuario.getFav().getId())
	        		.getResultList();
		}catch(Exception e) {
            e.printStackTrace();
        }
		return Collections.EMPTY_LIST;
	}

}
