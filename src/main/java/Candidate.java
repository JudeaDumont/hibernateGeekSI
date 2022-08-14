import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "CANDIDATES")
public class Candidate {
    private Long id;
    private String name;

    public Candidate() {
        // this form used by Hibernate
    }

    public Candidate(Long id, String name) {
        // for application use, to create new Employees
        this.id = id;
        this.name = name;
    }

    public Candidate(String name) {
        // for application use, to create new Employees
        this.name = name;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    private void setname(String name) {
        this.name = name;
    }

    public static void save(Candidate candidate) {
        Session session = HibernateSessionFactory.getSession();
        session.beginTransaction();
        session.save(candidate);
        session.getTransaction().commit();
        session.close();
    }

    public static Candidate getById(Long id) {
        Session session = HibernateSessionFactory.getSession();
        session.beginTransaction();
        Candidate candidate = session.get(Candidate.class, id);
        session.getTransaction().commit();
        session.close();
        return candidate;
    }

    public static List<Candidate> getCandidatesByName(String name) {
        Session session = HibernateSessionFactory.getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Candidate> criteria = builder.createQuery(Candidate.class);
        Root<Candidate> root = criteria.from(Candidate.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get(Candidate_.name), name));

        return session.createQuery(criteria).getResultList();
    }
}
