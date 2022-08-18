package Candidate;

import EnforcedClassExtension.ID;
import Hibernate.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DBUTilsCandidate {
    public static <T extends ID> List<T> getByName(Class<T> classOfObject, String name) {
        Session session = HibernateSessionFactory.getSession();
        session.beginTransaction();

        Query<T> tQuery = session.createQuery(
                "from " + getTableNameFromClass(classOfObject) + " c where c.name = '" + name + "'", classOfObject);

        return tQuery.getResultList();
    }

    private static <T extends ID> String getTableNameFromClass(Class<T> classOfObject) {
        String[] packageLocation = classOfObject.getName().split("\\.");
        return packageLocation[packageLocation.length-1];
    }
}
