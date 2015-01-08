import java.util.Scanner;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class LoadFactory implements Factory{

    public LoadFactory() {
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
            throw new FactoryException("No EOF");
        }

        String end = scanner.next();
        scanner.nextLine();
        String input = "";
        String tmpLine;

        while (scanner.hasNextLine()) {
            tmpLine = scanner.nextLine();
            if (tmpLine.contains(end)) {
                break;
            } else {
                input += tmpLine + "\n";
            }
        }

        return new LoadOperation(input);
    }

}