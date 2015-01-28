import java.util.Scanner;

/**
 * Factory Save
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class SaveFactory implements Factory {

    final private MetricSet<AsciiImage> saved;

    /**
     * Constructor
     * @param saved
     */
    public SaveFactory(MetricSet<AsciiImage> saved) {
        this.saved = saved;
    }

    /**
     * Returns new instance of SaveOperation
     * @param scanner
     * @return
     * @throws FactoryException
     */
    @Override
    public Operation create(Scanner scanner) throws FactoryException {
        return new SaveOperation(saved);
    }
}