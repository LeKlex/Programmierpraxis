/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class AverageOperation extends FilterOperation {

    public AverageOperation(BlockGenerator blockGen) {
        super(blockGen);
    }

    /**
     * Calculate Average
     * @param values
     * @return
     */
    @Override
    public int filter(int[] values) {
        double sum = 0.0;

        for (int val : values) {
            sum += val;
        }

        return (int) Math.round(sum / values.length);
    }
}