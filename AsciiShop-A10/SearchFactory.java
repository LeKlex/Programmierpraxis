import java.util.Scanner;

/**
 * Factory Search
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class SearchFactory implements Factory {

    /**
     * Saved Images in MetricSet
     */
    final private MetricSet<AsciiImage> saved;

    /**
     * Constructor
     * @param saved
     */
    public SearchFactory(MetricSet<AsciiImage> saved) {
        this.saved = saved;
    }

    /**
     * Returns new instance of SearchOperation
     * @param scanner
     * @return
     * @throws FactoryException if insufficient arguments
     */
    @Override
    public Operation create(Scanner scanner) throws FactoryException {

        if(!scanner.hasNext()) {
            throw new FactoryException();
        }

        return new SearchOperation(saved, choseMetric(scanner.next().trim()));
    }

    /**
     * Chose metric by name
     * @param name
     * @return
     * @throws FactoryException if unknown metric
     */
    private Metric<AsciiImage> choseMetric(String name) throws FactoryException {
        if("pixelcount".equals(name)) {
            return new PixelCountMetric();
        } else if("uniquechars".equals(name)) {
            return new UniqueCharsMetric();
        }

        throw new FactoryException("Unknown Metric");

    }

}