package database;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import models.Atraccion;
import models.Itinerario;
import models.Itinerario_detalle;
import models.Promocion;
import models.TipoAtraccion;
import models.Tipo_Descuento_Promocion;
import models.Usuario;


public class HibernateUtil {
    private static SessionFactory sessionFactory;
    

    private static final String emilio="jdbc:sqlite:/home/ediffer/java-projects/TurismoTierraMediaWeb/src/TurismoTierraMedia.db";
    private static final String marce="jdbc:sqlite:F:\\Users\\Marcelo\\Java-ServerTurismoTM\\TurismoTierraMediaWeb\\src\\TurismoTierraMedia.db";
    private static final String flor="";
    private static final String antonio="";


    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.sqlite.JDBC");

                settings.put(Environment.URL, marce);

                settings.put(Environment.DIALECT, "com.enigmabridge.hibernate.dialect.SQLiteDialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                configuration.setProperties(settings);
                
                //Clases controladas
                configuration.addAnnotatedClass(Usuario.class);
                configuration.addAnnotatedClass(Atraccion.class);
                configuration.addAnnotatedClass(Itinerario_detalle.class);
                configuration.addAnnotatedClass(Itinerario.class);
                configuration.addAnnotatedClass(Promocion.class);
                //configuration.addAnnotatedClass(Promocion_Atraccion.class); Aun no es digna
                configuration.addAnnotatedClass(Tipo_Descuento_Promocion.class);
                configuration.addAnnotatedClass(TipoAtraccion.class);
                //------

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}