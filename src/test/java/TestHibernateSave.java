import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHibernateSave {
    @Test
    public void testSave() {
        Candidate chef = new Candidate("chef");
        Candidate.save(chef);
        Candidate retrieved = Candidate.getById(chef.getId());
        assertEquals(retrieved.getName(), "chef");
    }
}
