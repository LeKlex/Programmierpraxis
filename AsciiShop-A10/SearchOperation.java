/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class SearchOperation implements Operation {

    final private MetricSet<AsciiImage> saved;
    final private Metric<AsciiImage> m;

    /**
     *
     * @param saved
     * @param m
     */
    public SearchOperation(MetricSet<AsciiImage> saved, Metric<AsciiImage> m) {
        this.saved = saved;
        this.m = m;
    }

    /**
     *
     * @param img
     * @return
     * @throws OperationException
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