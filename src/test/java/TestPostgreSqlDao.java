import Customer.Customer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import postgresql.Dao;
import postgresql.PostgreSqlDao;

import java.util.Collection;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestPostgreSqlDao {
    @Test
    @Order(1)
    public void testSave() throws ClassNotFoundException {
        Customer c = new Customer(
                1,
                "chef",
                "greg",
                "dumontjudea2@gmail.com");
        PostgreSqlDao postgres = new PostgreSqlDao();
        postgres.save(c);
    }

    private static final Logger LOGGER =
            Logger.getLogger(TestPostgreSqlDao.class.getName());
    private static final Dao<Customer, Integer> CUSTOMER_DAO = new PostgreSqlDao();


    @Test
    @Order(2)
    public void testAll(){
        try {
            Customer customer = getCustomer(1);
        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, ex.getMessage());
        }

        // Test whether a customer can be added to the database
        Customer firstCustomer =
                new Customer(2, "Manuel", "Kelley", "ManuelMKelley@jourrapide.com");
        Customer secondCustomer =
                new Customer(3, "Joshua", "Daulton", "JoshuaMDaulton@teleworm.us");
        Customer thirdCustomer =
                new Customer(4, "April", "Ellis", "AprilMellis@jourrapide.com");
        addCustomer(firstCustomer).ifPresent(firstCustomer::setId);
        addCustomer(secondCustomer).ifPresent(secondCustomer::setId);
        addCustomer(thirdCustomer).ifPresent(thirdCustomer::setId);

        // Test whether the new customer's details can be edited
        firstCustomer.setFirstName("Franklin");
        firstCustomer.setLastName("Hudson");
        firstCustomer.setEmail("FranklinLHudson@jourrapide.com");
        updateCustomer(firstCustomer);

        // Test whether all customers can be read from database
        getAllCustomers().forEach(System.out::println);

        // Test whether a customer can be deleted
        deleteCustomer(secondCustomer);
    }

    // Static helper methods referenced above
    public static Customer getCustomer(int id) throws Exception {
        Optional<Customer> customer = CUSTOMER_DAO.get(id);
        return customer.orElseThrow(Exception::new);
    }

    public static Collection<Customer> getAllCustomers() {
        return CUSTOMER_DAO.getAll();
    }

    public static void updateCustomer(Customer customer) {
        CUSTOMER_DAO.update(customer);
    }

    public static Optional<Integer> addCustomer(Customer customer) {
        return CUSTOMER_DAO.save(customer);
    }

    public static void deleteCustomer(Customer customer) {
        CUSTOMER_DAO.delete(customer);
    }
}
