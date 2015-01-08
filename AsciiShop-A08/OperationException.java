/**
 * Exception Class for AsciiShop
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
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
