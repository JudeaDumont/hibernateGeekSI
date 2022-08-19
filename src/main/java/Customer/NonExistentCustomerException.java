package Customer;

import java.io.Serial;

//todo: get these exceptions to work, look for "Exception" in this project for the generic ones
//that need to be changed to these
public class NonExistentCustomerException extends NonExistentEntityException {

    @Serial
    private static final long serialVersionUID = 8633588908169766368L;

    public NonExistentCustomerException() {
        super("Customer does not exist");
    }
}