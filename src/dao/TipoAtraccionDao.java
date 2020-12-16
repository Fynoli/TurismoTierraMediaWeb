package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import database.HibernateUtil;
import models.Usuario;
import models.TipoAtraccion;

public class TipoAtraccionDao {

	public TipoAtraccion getUno(Integer id) {

		TipoAtraccion miTipoAtraccion = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// la condicion que coloque solo es una prueba podemos filtrar por lo mismo de
			// arriba, presupuesto, tiempo y demas
			return miTipoAtraccion = (TipoAtraccion) session.createQuery("FROM TipoAtraccion TA where TA.id = :id")
					.setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return miTipoAtraccion;

	}

	@SuppressWarnings("unchecked")
	public List<TipoAtraccion> getTiposAtracciones(TipoAtraccion tipoAtraccion) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (List<TipoAtraccion>) session.createQuery("FROM TipoAtraccion TA").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoAtraccion> getTiposAtracciones() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (List<TipoAtraccion>) session.createQuery("FROM TipoAtraccion TA").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

	public TipoAtraccion unTipoAtraccion(Usuario usuario) {
		TipoAtraccion miTipoAtraccion = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// la condicion que coloque solo es una prueba podemos filtrar por lo mismo de
			// arriba, presupuesto, tiempo y demas
			return miTipoAtraccion = (TipoAtraccion) session
					.createQuery("FROM TipoAtraccion TA where TA.id < :preferencia")
					.setParameter("preferencia", usuario.getFav()).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return miTipoAtraccion;
	}
	
	public boolean baja(Integer id){

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			session.beginTransaction();
			TipoAtraccion tp1 = (TipoAtraccion) session
					.createQuery("FROM TipoAtraccion T WHERE T.id = :Id")
					.setParameter("Id", id)
					.getSingleResult();
			tp1.setActivo(0);
			session.saveOrUpdate(tp1);
			System.out.println("El tipo eliminado es:" + tp1.getNombre());
			session.getTransaction().commit();
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;

	}

	public boolean crear(TipoAtraccion tipoAtraccion) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();

			int lastId = (int) session.createQuery("select max(TA.id) from TipoAtraccion TA").uniqueResult();
			tipoAtraccion.setId(++lastId);

			session.save(tipoAtraccion);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean baja(TipoAtraccion tipoAtraccion) {
		TipoAtraccion tipoAtraccion1 = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			tipoAtraccion1 = (TipoAtraccion) session.createQuery("from TipoAtraccion TA where TA.id = :tipo_id")
					.setParameter("tipo_id", tipoAtraccion.getId()).getSingleResult();
			tipoAtraccion1.setActivo(0);
			session.saveOrUpdate(tipoAtraccion1);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	// mostramos los valores de un usuario getUno(id), ahi se podran modificar
	// algunos campos
	// y lo vamos a guardar en un usuario temporal, lo comparamos y si son distintos
	// le hacemos update

	public boolean update(TipoAtraccion tipoAtraccion) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.saveOrUpdate(tipoAtraccion);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
}
