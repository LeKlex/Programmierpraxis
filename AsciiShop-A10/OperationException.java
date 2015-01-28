/**
 * Exception for Operations
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class OperationException extends Exception {

    public OperationException() {
        super();
    }

    public OperationException(String message) {
        super(message);
    }

    public OperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationException(Throwable cause) {
        super(cause);
    }

}
