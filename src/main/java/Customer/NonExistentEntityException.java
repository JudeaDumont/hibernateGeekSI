package Customer;

import java.io.Serial;
//doesn't work
public class NonExistentEntityException extends Throwable {

    @Serial
    private static final long serialVersionUID = -3760558819369784286L;

    public NonExistentEntityException(String message) {
        super(message);
    }
}