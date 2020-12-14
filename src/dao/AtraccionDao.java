package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import database.HibernateUtil;
import models.Atraccion;
import models.Usuario;

public class AtraccionDao {

	/**
	 * Obtiene una atraccion basada en la ID
	 * 
	 * @param id
	 * @return Atraccion
	 */
	public Atraccion getUna(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (Atraccion) session.createQuery("FROM Atraccion A WHERE A.id = :Id").setParameter("Id", id)
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retorna las atracciones que son preferencia del usuario y solo aquellas que
	 * esten activas, tenga tiempo y dinero para pagar y no esten en su itinerario.
	 * El usuario debe tener tiempo y dinero disponible.
	 * 
	 * @param usuario
	 * @return List<Atraccion>
	 */
	@SuppressWarnings("unchecked")
	public List<Atraccion> getAtraccionesFavoritas(Usuario usuario) {
		List<Atraccion> atraccionesPosibles = new ArrayList<Atraccion>();
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			atraccionesPosibles = (List<Atraccion>) session.createQuery(
					"FROM Atraccion A WHERE A.costo <= :presupuesto AND A.tiempo <= :tiempo AND A.tipos_atraccion = :fav AND A.activo = 1 order by A.costo desc, A.tiempo desc")
					.setParameter("tiempo", usuario.getTiempo_disponible())
					.setParameter("presupuesto", usuario.getPresupuesto()).setParameter("fav", usuario.getFav())
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(usuario.getAtracciones());

		for (Atraccion a : atraccionesPosibles) {
			if (!usuario.tieneEstaAtraccion(a)) {
				atracciones.add(a);
			}
		}

		return atracciones;
	}

	/**
	 * Retorna las atracciones que no son preferencia del usuario, solo aquellas que
	 * esten activas, que tenga tiempo y dinero para costear y que aun no posea. El
	 * usuario debe tener tiempo y dinero disponible.
	 * 
	 * @param usuario
	 * @return List<Atraccion>
	 */
	@SuppressWarnings("unchecked")
	public List<Atraccion> getAtraccionesNoFavoritas(Usuario usuario) {
		List<Atraccion> atraccionesPosibles = new ArrayList<Atraccion>();
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			atraccionesPosibles= (ArrayList<Atraccion>) session.createQuery(
					"FROM Atraccion A WHERE A.costo <= :presupuesto AND A.tiempo <= :tiempo AND A.tipos_atraccion != :fav AND A.activo = 1 order by A.costo desc, A.tiempo desc")
					.setParameter("tiempo", usuario.getTiempo_disponible())
					.setParameter("presupuesto", usuario.getPresupuesto())
					.setParameter("fav", usuario.getFav())
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Atraccion a : atraccionesPosibles) {
			if (!usuario.tieneEstaAtraccion(a)) {
				atracciones.add(a);
			}
		}

		return atracciones;
	}

	/**
	 * Retorna todas las atracciones. Esten dadas de baja o no.
	 * 
	 * @return List<Atraccion>
	 */
	@SuppressWarnings("unchecked")
	public List<Atraccion> getAtracciones() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (List<Atraccion>) session.createQuery("FROM Atraccion A").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * Retorna todas las atracciones que no estén dadas de baja.
	 * 
	 * @return List<Atraccion>
	 */
	@SuppressWarnings("unchecked")
	public List<Atraccion> getAtraccionesActivas() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (List<Atraccion>) session.createQuery("FROM Atraccion A where A.activo = 1").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * Retorna todas las atracciones que estén dadas de baja.
	 * 
	 * @return List<Atraccion>
	 */
	@SuppressWarnings("unchecked")
	public List<Atraccion> getAtraccionesInactivas() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (List<Atraccion>) session.createQuery("FROM Atraccion A where A.activo = 0").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * Produce la baja logica de la atracción cuya id se pase por parametro.
	 * 
	 * @param id
	 */
	public void bajaAtraccion(Atraccion atraccion) {
		Atraccion atraccionAux = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			atraccionAux = (Atraccion) session.createQuery("from Atraccion A where A.id = :id")
					.setParameter("id", atraccion.getId()).getSingleResult();
			atraccionAux.setActivo(0);
			atraccion = atraccionAux;
			session.update(atraccion);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Graba cualquier cambio realizado en la entidad
	 * 
	 * @param Atraccion atraccion
	 */
	public void updateAtraccion(Atraccion atraccion) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(atraccion);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Da de alta una atraccion preconstruida en hibernate
	 * 
	 * @param Atraccion atraccion
	 */
	public void altaDeAtraccion(Atraccion atraccion) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			int lastId = (int) session.createQuery("select max(A.id) from Atraccion A").uniqueResult();
			atraccion.setId(lastId++);
			session.beginTransaction();
			session.persist(atraccion);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
