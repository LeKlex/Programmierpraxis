import java.util.Scanner;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class FilterFactory implements Factory {

    public FilterFactory() {
    }

    /**
     *
     * @param scanner
     * @return
     * @throws FactoryException
     */
    @Override
    public Operation create(Scanner scanner) throws FactoryException {

        //Check if we have a param and if its "median"
        if (!scanner.hasNext() || ! "median".equals(scanner.next())) {
            throw new FactoryException("Insufficient parameter");
        }

        return new MedianOperation();
    }

}