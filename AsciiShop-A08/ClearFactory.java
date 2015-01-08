import java.util.Scanner;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class ClearFactory implements Factory {

    public ClearFactory() {
    }

    /**
     *
     * @param scanner
     * @return
     * @throws FactoryException
     */
    @Override
    public Operation create(Scanner scanner) throws FactoryException {
        return new ClearOperation();
    }

}
