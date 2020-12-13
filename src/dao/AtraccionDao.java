package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import database.HibernateUtil;
import models.Atraccion;
import models.TipoAtraccion;
import models.Usuario;

public class AtraccionDao {
	
	/**
	 * Obtiene una atraccion basada en la ID
	 * @param id
	 * @return
	 */
	public Atraccion getUna(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (Atraccion) session
	        		.createQuery("FROM Atraccion A WHERE A.id = :Id")
	        		.setParameter("Id", id)
	        		.uniqueResult();
		}catch(Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
	/**
	 * Retorna las atracciones que son preferencia del usuario y solo aquellas que esten activas.
	 * El usuario debe tener tiempo y dinero disponible.
	 * @param usuario
	 * @return List<Atraccion>
	 */
	@SuppressWarnings("unchecked")
	public List<Atraccion> getAtraccionesFavoritas(Usuario usuario) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (List<Atraccion>) session
	        		.createQuery("FROM Atraccion A WHERE A.costo <= :presupuesto AND A.tiempo <= :tiempo AND A.tipo_id = :fav AND A.activo = 1 order by A.costo desc, A.tiempo desc")
	        		.setParameter("tiempo", usuario.getTiempo_disponible())
	        		.setParameter("presupuesto", usuario.getPresupuesto())
	        		.setParameter("fav", usuario.getFav().getId())
	        		.getResultList();
		}catch(Exception e) {
            e.printStackTrace();
        }
		return Collections.EMPTY_LIST;
	}
	
	/**
	 * Retorna las atracciones que no son preferencia del usuario y solo aquellas que esten activas.
	 * El usuario debe tener tiempo y dinero disponible.
	 * @param usuario
	 * @return List<Atraccion>
	 */
	@SuppressWarnings("unchecked")
	public List<Atraccion> getAtraccionesNoFavoritas(Usuario usuario) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (List<Atraccion>) session
	        		.createQuery("FROM Atraccion A WHERE A.costo <= :presupuesto AND A.tiempo <= :tiempo AND A.tipo_id != :fav AND A.activo = 1 order by A.costo desc, A.tiempo desc")
	        		.setParameter("tiempo", usuario.getTiempo_disponible())
	        		.setParameter("presupuesto", usuario.getPresupuesto())
	        		.setParameter("fav", usuario.getFav().getId())
	        		.getResultList();
		}catch(Exception e) {
            e.printStackTrace();
        }
		return Collections.EMPTY_LIST;
	}
	
	/**
	 * Retorna todas las atracciones. Esten dadas de baja o no.
	 * @return List<Atraccion>
	 */
	@SuppressWarnings("unchecked")
	public List<Atraccion> getAtracciones() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (List<Atraccion>) session
	        		.createQuery("FROM Atraccion A")
	        		.getResultList();
		}catch(Exception e) {
            e.printStackTrace();
        }
		return Collections.EMPTY_LIST;
	}
	
	/**
	 * Retorna todas las atracciones que no estén dadas de baja.
	 * @return List<Atraccion>
	 */
	@SuppressWarnings("unchecked")
	public List<Atraccion> getAtraccionesActivas() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (List<Atraccion>) session
	        		.createQuery("FROM Atraccion A where A.activo = 1")
	        		.getResultList();
		}catch(Exception e) {
            e.printStackTrace();
        }
		return Collections.EMPTY_LIST;
	}
	
	/**
	 * Retorna todas las atracciones que estén dadas de baja.
	 * @return List<Atraccion>
	 */
	@SuppressWarnings("unchecked")
	public List<Atraccion> getAtraccionesInactivas() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (List<Atraccion>) session
	        		.createQuery("FROM Atraccion A where A.activo = 0")
	        		.getResultList();
		}catch(Exception e) {
            e.printStackTrace();
        }
		return Collections.EMPTY_LIST;
	}
	
	
	/**
	 * Produce la baja logica de la atracción cuya id se pase por parametro.
	 * @param id
	 */
	public void bajaAtraccion(Atraccion atraccion){
		Atraccion atraccionAux=null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            atraccionAux = (Atraccion) session.createQuery("from Atraccion A where A.id = :id")
                    .setParameter("id", atraccion.getId())
                    .getSingleResult();
            atraccionAux.setActivo(0);
            atraccion=atraccionAux;
            session.update(atraccion);
            session.getTransaction().commit();
		}
		catch (Exception e){
            e.printStackTrace();
        }

    }
	
	
	
	public void altaDeAtraccion(Atraccion atraccion){
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.persist(atraccion);
            session.getTransaction().commit();
		}
		catch (Exception e){
            e.printStackTrace();
        }
	}

}
