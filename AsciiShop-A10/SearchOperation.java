/**
 * Operation Search
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class SearchOperation implements Operation {

    /**
     *
     */
    final private MetricSet<AsciiImage> saved;

    /**
     *
     */
    final private Metric<AsciiImage> m;

    /**
     * Constructor
     * @param saved AsciiImages in MetricSet
     * @param m metric to use for search
     */
    public SearchOperation(MetricSet<AsciiImage> saved, Metric<AsciiImage> m) {
        this.saved = saved;
        this.m = m;
    }

    /**
     * Search nearest and return new instance of it
     * @param img
     * @return
     * @throws OperationException if saved does not contain any images
     */
    @Override
    public AsciiImage execute(AsciiImage img) throws OperationException {
        if (saved.isEmpty()) {
            throw new OperationException("No saved images for search operation");
        }

        //Return copy img with smallest distance, if more than 1 result, return the first
        return new AsciiImage(saved.search(img, m).iterator().next());
    }
}