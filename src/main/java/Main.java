public class Main {
    public static void main(String[] args) {
        Candidate JudeaDumont = new Candidate(9123L, "Judea Dumont");

        Candidate.save(JudeaDumont);

        for (Candidate person : Candidate.getCandidatesByName("Judea Dumont")) {
            System.out.println("You want to hire " + person.getName());
        }
    }
}
