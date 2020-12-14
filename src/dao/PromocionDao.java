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
	
	/**
	 * Obtiene una promocion basada en la ID
	 * @param id
	 * @return Promocion
	 */
	public Promocion getUna(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (Promocion) session
	        		.createQuery("FROM Promocion P WHERE P.id = :Id")
	        		.setParameter("Id", id)
	        		.uniqueResult();
		}catch(Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
	/**
	 * Retorna las promociones que son preferencia del usuario y solo aquellas que esten activas, que tenga tiempo de cursar, que pueda pagar y que tengan cupo.
	 * El usuario debe tener tiempo y dinero disponible.
	 * @param usuario
	 * @return List<Promocion>
	 */
	@SuppressWarnings("unchecked")
	public List<Promocion> getPromocionesFavoritas(Usuario usuario) {
		List<Promocion> promocionesPosibles=new ArrayList<Promocion>();
		List<Promocion> promociones=new ArrayList<Promocion>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			promocionesPosibles= (List<Promocion>) session
	        		.createQuery("FROM Promocion P WHERE P.costo <= :presupuesto AND P.tiempo <= :tiempo AND P.activo = 1")
	        		.setParameter("tiempo", usuario.getTiempo_disponible())
	        		.setParameter("presupuesto", usuario.getPresupuesto())
	        		.getResultList();
			
			//Se quitan los paquetes que contengan atracciones que no sean del agrado del usuario
			for(Promocion p: promocionesPosibles) {
				if(usuario.leGustaEstaPromocion(p) && !usuario.tieneAlgoDeEstaPromocion(p)) {
					promociones.add(p);
				}
			}
			return promociones;
			
			
		}catch(Exception e) {
            e.printStackTrace();
        }
		return Collections.EMPTY_LIST;
	}
	
	/**
	 * Retorna las Promociones que no son preferencia del usuario y solo aquellas que esten activas.
	 * El usuario debe tener tiempo y dinero disponible.
	 * @param usuario
	 * @return List<Promocion>
	 */
	@SuppressWarnings("unchecked")
	public List<Promocion> getPromocionesNoFavoritas(Usuario usuario) {
		List<Promocion> promocionesPosibles=new ArrayList<Promocion>();
		List<Promocion> promociones=new ArrayList<Promocion>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			promocionesPosibles= (List<Promocion>) session
	        		.createQuery("FROM Promocion P WHERE P.costo <= :presupuesto AND P.tiempo <= :tiempo AND P.activo = 1")
	        		.setParameter("tiempo", usuario.getTiempo_disponible())
	        		.setParameter("presupuesto", usuario.getPresupuesto())
	        		.getResultList();
			
			for(Promocion p: promocionesPosibles) {
				if(!usuario.leGustaEstaPromocion(p) && !usuario.tieneAlgoDeEstaPromocion(p)) {
					promociones.add(p);
				}
			}
			return promociones;
			
			
		}catch(Exception e) {
            e.printStackTrace();
        }
		return Collections.EMPTY_LIST;
	}
	
	/**
	 * Retorna todas las Promociones. Esten dadas de baja o no.
	 * @return List<Promocion>
	 */
	@SuppressWarnings("unchecked")
	public List<Promocion> getPromociones() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (List<Promocion>) session
	        		.createQuery("FROM Promocion P")
	        		.getResultList();
		}catch(Exception e) {
            e.printStackTrace();
        }
		return Collections.EMPTY_LIST;
	}
	
	/**
	 * Retorna todas las Promociones que no estén dadas de baja.
	 * @return List<Promocion>
	 */
	@SuppressWarnings("unchecked")
	public List<Promocion> getPromocionesActivas() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (List<Promocion>) session
	        		.createQuery("FROM Promocion P where P.activo = 1")
	        		.getResultList();
		}catch(Exception e) {
            e.printStackTrace();
        }
		return Collections.EMPTY_LIST;
	}
	
	/**
	 * Retorna todas las Promociones que estén dadas de baja.
	 * @return List<Promocion>
	 */
	@SuppressWarnings("unchecked")
	public List<Promocion> getPromocionesInactivas() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (List<Promocion>) session
	        		.createQuery("FROM Promocion P where P.activo = 0")
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
	public void bajaPromocion(Promocion promocion){
		Promocion promocionAux=null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            promocionAux = (Promocion) session.createQuery("from Promocion P where P.id = :id")
                    .setParameter("id", promocion.getPromocion_id())
                    .getSingleResult();
            promocionAux.setActivo(0);
            promocion=promocionAux;
            session.update(promocion);
            session.getTransaction().commit();
		}
		catch (Exception e){
            e.printStackTrace();
        }

    }
	
	/**
	 * Graba cualquier cambio realizado en la entidad
	 * @param Promocion Promocion
	 */
	public void updatePromocion(Promocion promocion){
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(promocion);
            session.getTransaction().commit();
		}
		catch (Exception e){
            e.printStackTrace();
        }

    }
	
	
	/**
	 * Da de alta una Promocion preconstruida en hibernate
	 * @param Promocion Promocion
	 */
	public void altaDePromocion(Promocion promocion){
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			int lastId = (int) session.createQuery("select max(P.id) from Promocion P").uniqueResult();
            promocion.setId(lastId++);
			session.beginTransaction();
            session.persist(promocion);
            session.getTransaction().commit();
		}
		catch (Exception e){
            e.printStackTrace();
        }
	}

}
