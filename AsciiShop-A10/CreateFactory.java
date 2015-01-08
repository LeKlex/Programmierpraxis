
import java.util.Scanner;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class CreateFactory implements Factory {

    public CreateFactory() {
    }

    /**
     *
     * @param scanner
     * @return
     * @throws FactoryException
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