import Candidate.Candidate;
import Candidate.DBUTilsCandidate;
import Hibernate.HibernateSessionFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestHibernateCandidates {

    private static Long id = null;
    private static Long testOrder = 0L;

    @Test
    @Order(1)
    public void testSave() throws ClassNotFoundException {
        Candidate chef = new Candidate("chef");
        HibernateSessionFactory.save(chef);
        id = chef.getId();
        System.out.println(++testOrder);
    }

    @Test
    @Order(2)
    public void testGet() throws ClassNotFoundException {
        Candidate retrieved = HibernateSessionFactory.
                getByClassAndID(Candidate.class, id);
        assertEquals(retrieved.getName(), "chef");
        System.out.println(++testOrder);
    }

    @Test
    @Order(3)
    public void testCandidatesByName() {
        Candidate judeaDumont = new Candidate(9123L, "Judea Dumont");
        HibernateSessionFactory.save(judeaDumont);

        for (Candidate person : DBUTilsCandidate.getCandidatesByName("Judea Dumont")) {
            System.out.println("You want to hire " + person.getName());
        }
        System.out.println(++testOrder);
    }
}
