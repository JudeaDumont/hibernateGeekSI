package Customer;

import java.io.Serial;

public class NonExistentCustomerException extends NonExistentEntityException {

    @Serial
    private static final long serialVersionUID = 8633588908169766368L;

    public NonExistentCustomerException() {
        super("Customer does not exist");
    }
}