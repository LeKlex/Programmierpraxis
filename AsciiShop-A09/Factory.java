import java.util.Scanner;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public interface Factory {

        /**
         * @param sc
         * @return Operation
         * @throws FactoryException
         */
        public Operation create (Scanner scanner) throws FactoryException;

}