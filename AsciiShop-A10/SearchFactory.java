import java.util.Scanner;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class SearchFactory implements Factory {

    final private MetricSet<AsciiImage> saved;

    /**
     *
     * @param saved
     */
    public SearchFactory(MetricSet<AsciiImage> saved) {
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

        if(!scanner.hasNext()) {
            throw new FactoryException();
        }

        return new SearchOperation(saved, choseMetric(scanner.next().trim()));
    }

    /**
     * Chose metric by name
     * @param name
     * @return
     * @throws FactoryException
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