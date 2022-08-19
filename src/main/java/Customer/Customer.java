package Customer;

public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    // Constructor, getters and setters...

    @Override
    public String toString() {
        return "Customer["
                + "id=" + id
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", email=" + email
                + ']';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Customer(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}

