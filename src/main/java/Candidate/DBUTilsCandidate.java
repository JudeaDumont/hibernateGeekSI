package Candidate;

import Hibernate.HibernateSessionFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;

public class DBUTilsCandidate {
    public static List<Candidate> getCandidatesByName(String name) {
        Session session = HibernateSessionFactory.getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Candidate> criteria = builder.createQuery(Candidate.class);
        Root<Candidate> root = criteria.from(Candidate.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get(Candidate_.name), name));
        //problem is you have to rely on there being a property called name.

        return session.createQuery(criteria).getResultList();
    }
}
