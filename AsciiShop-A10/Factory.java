import java.util.Scanner;

/**
 * Factory for Operations
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public interface Factory {

        /**
         * Creates new instances of Operations
         * @param scanner
         * @return Operation
         * @throws FactoryException
         */
        public Operation create (Scanner scanner) throws FactoryException;

}