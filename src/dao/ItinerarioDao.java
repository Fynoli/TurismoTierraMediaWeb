package dao;

import database.HibernateUtil;
import models.Itinerario_detalle;
import models.Usuario;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItinerarioDao {

    @SuppressWarnings("unchecked")
    public List<Itinerario_detalle> getItinerario(Usuario usuario) {

        List<Itinerario_detalle> itinerario_detalles=new ArrayList<Itinerario_detalle>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            itinerario_detalles = (List<Itinerario_detalle>) session
                     .createQuery("FROM Itinerario_detalle ID WHERE ID.usuario = :usuarioid")
                    .setParameter("usuarioid", usuario)
                    .getResultList();

            return itinerario_detalles;
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("sale vacia");
        return Collections.EMPTY_LIST;
    }
}
