package dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import database.HibernateUtil;
import models.Usuario;

public class UsuarioDao {
	public boolean validar(String username, String password) {

        Usuario user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            user = (Usuario) session
            		.createQuery("FROM Usuario U, TipoAtraccion WHERE U.nombre = :username")
            		.setParameter("username", username)
            		.uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public Usuario getUno(String nombre) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (Usuario) session
	        		.createQuery("FROM Usuario U WHERE U.nombre = :nombreusuario")
            		.setParameter("nombreusuario", nombre)
            		.uniqueResult();
		}catch(Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
	public Usuario getUno(Integer id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return (Usuario) session
	        		.createQuery("FROM Usuario U WHERE U.id = :Id")
	        		.setParameter("Id", id)
	        		.uniqueResult();
		}catch(Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
	public boolean crear(Usuario usuario) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			
			int lastId = (int) session.createQuery("select max(u.id) from Usuario u").uniqueResult();
			usuario.setId(++lastId);
			
			session.save(usuario);
		    session.getTransaction().commit();
			return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
	}
	

}
