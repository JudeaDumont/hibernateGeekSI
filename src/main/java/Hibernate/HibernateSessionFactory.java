package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory {
    private HibernateSessionFactory() {
    }

    private static SessionFactory hibernateSessionFactory = null;

    public static Session getSession() {
        if (hibernateSessionFactory == null) {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            try {
                hibernateSessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                StandardServiceRegistryBuilder.destroy(registry);
            }
        }
        return hibernateSessionFactory.openSession();
    }

    // does not return an EnforcedClassExtension.ID of the thing you just saved
    // you shouldn't need the id after saving the thing, you should need it before
    public static <T> void save(T obj){
        Session session = HibernateSessionFactory.getSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }

    public static <T> T getByClassAndID(Class<T> classOfObj, Long id) throws ClassNotFoundException {

        Session session = HibernateSessionFactory.getSession();
        session.beginTransaction();
        T obj = session.get(classOfObj, id);
        session.getTransaction().commit();
        session.close();
        return obj;
    }
}
