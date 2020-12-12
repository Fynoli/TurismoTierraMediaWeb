package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import database.HibernateUtil;
import models.Atraccion;
import models.Usuario;

public class AtraccionDao {
	public List<Atraccion> getAtracciones(Usuario usuario) {
		List<Atraccion> atracciones=new ArrayList<Atraccion>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (List<Atraccion>) session
	        		.createQuery("FROM atraccion A WHERE A.costo <= :presupuesto AND A.tiempo <= :tiempo order by A.costo, A.tiempo")
	        		.setParameter("tiempo", usuario.getTiempo_disponible())
	        		.setParameter("presupuesto", usuario.getPresupuesto())
	        		.setParameter("fav", usuario.getFav())
	        		.getResultList();
		}catch(Exception e) {
            e.printStackTrace();
        }
		return Collections.EMPTY_LIST;
	}

}
