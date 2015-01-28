import java.util.Scanner;

/**
 * Factory Binary
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class BinaryFactory implements Factory {

    /**
     * Constructor
     */
    public BinaryFactory() {}

    /**
     * Returns a new BinaryOperation Instance
     * @param scanner
     * @return new BinaryOperation Instance
     * @throws FactoryException if too few params
     */
    @Override
    public Operation create(Scanner scanner) throws FactoryException {

        if (!scanner.hasNext()) {
            throw new FactoryException("Insufficient parameter");
        }

        return new BinaryOperation(scanner.next(".").charAt(0));
    }

}