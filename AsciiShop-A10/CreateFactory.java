import java.util.Scanner;

/**
 * Factory Create
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class CreateFactory implements Factory {

    public CreateFactory() {}

    /**
     * Creates new CreateOperation instance
     * @param scanner
     * @return new CreateOperation instance
     * @throws FactoryException if insufficient params
     */
    @Override
    public Operation create(Scanner scanner) throws FactoryException {
        try {
            return new CreateOperation(scanner.nextInt(), scanner.nextInt(), scanner.next());
        } catch (Exception e) {
            throw new FactoryException("Insufficient parameter");
        }
    }
}