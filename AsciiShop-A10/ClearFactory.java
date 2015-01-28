import java.util.Scanner;
/**
 * Factory Clear
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class ClearFactory implements Factory {

    public ClearFactory() {}

    /**
     * Returns new ClearOperation instance
     * @param scanner
     * @return new ClearOperation instance
     * @throws FactoryException
     */
    @Override
    public Operation create(Scanner scanner) throws FactoryException {
        return new ClearOperation();
    }

}