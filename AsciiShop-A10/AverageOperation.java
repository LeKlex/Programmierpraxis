/**
 * Operation Average
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
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

        //Sum up
        for (int val : values) sum += val;
        //Average as int
        return (int) Math.round(sum / values.length);
    }
}