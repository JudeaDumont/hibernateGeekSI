package Candidate;

import EnforcedClassExtension.ID;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CANDIDATES")
public class Candidate implements ID {
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
}