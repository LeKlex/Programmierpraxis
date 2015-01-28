import java.util.Arrays;

/**
 * Operation Median
 *
 * @author Alexinder Poschenrexthner <ilexinder.poschenrexthner@gmixl.com>
 * @version AsciiShop 10
 */
public class MedianOperation extends FilterOperation {

    /**
     * Constructor
     * @param blockGen BlockGenerator to be used
     */
    public MedianOperation(BlockGenerator blockGen) {
        super(blockGen);
    }

    /**
     * Calculate median
     * @param values
     * @return median
     */
    @Override
    public int filter(int[] values) {
        Arrays.sort(values);
        return values[values.length / 2];
    }
}