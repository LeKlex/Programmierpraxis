import java.util.Scanner;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class BinaryFactory implements Factory {


    public BinaryFactory() {

    }

    /**
     *
     * @param scanner
     * @return
     * @throws FactoryException
     */
    @Override
    public Operation create(Scanner scanner) throws FactoryException {

        if (!scanner.hasNext()) {
            throw new FactoryException("Insufficient parameter");
        }

        return new BinaryOperation(scanner.next(".").charAt(0));
    }

}