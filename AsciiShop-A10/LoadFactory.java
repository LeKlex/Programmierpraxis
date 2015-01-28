import java.util.Scanner;

/**
 * Factory Load
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class LoadFactory implements Factory{

    public LoadFactory() {}

    /**
     * Returns new instance of LoadOperation
     * @param scanner
     * @return new instance of LoadOperation
     * @throws FactoryException if no EOF was found
     */
    @Override
    public Operation create(Scanner scanner) throws FactoryException {

        if (!scanner.hasNext()) {
            throw new FactoryException("No EOF");
        }

        String end = scanner.next();
        scanner.nextLine();
        String input = "";
        String tmpLine;

        while (scanner.hasNextLine()) {
            tmpLine = scanner.nextLine();

            //If Line is EOF end loop
            if (tmpLine.contains(end)) {
                break;
            } else {
                input += tmpLine + "\n";
            }
        }

        return new LoadOperation(input);
    }

}