/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class SaveOperation implements Operation {

    final private MetricSet<AsciiImage> saved;

    /**
     *
     * @param saved
     */
    public SaveOperation(MetricSet<AsciiImage> saved) {
        this.saved = saved;
    }

    /**
     *
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
     *
     * @return
     */
    public MetricSet<AsciiImage> getSaves() {
        return saved;
    }
}
