/**
 * Operation Save
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class SaveOperation implements Operation {

    final private MetricSet<AsciiImage> saved;

    /**
     * Constructor
     * @param saved
     */
    public SaveOperation(MetricSet<AsciiImage> saved) {
        this.saved = saved;
    }

    /**
     * Save Image in MetricSet
     * @param img
     * @return
     * @throws OperationException
     */
    @Override
    public AsciiImage execute(AsciiImage img) throws OperationException {
        //.add already checks null and .equals
        saved.add(img);
        return new AsciiImage(img);
    }

    /**
     * Returns saved 
     * @return
     */
    public MetricSet<AsciiImage> getSaves() {
        return saved;
    }
}
