import java.util.Scanner;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class SaveFactory implements Factory {

    final private MetricSet<AsciiImage> saved;

    /**
     *
     * @param saved
     */
    public SaveFactory(MetricSet<AsciiImage> saved) {
        this.saved = saved;
    }

    /**
     * 
     * @param scanner
     * @return
     * @throws FactoryException
     */
    @Override
    public Operation create(Scanner scanner) throws FactoryException {
        return new SaveOperation(saved);
    }
}