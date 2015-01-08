import java.util.Arrays;

/**
 *
 * @author Alexinder Poschenrexthner <ilexinder.poschenrexthner@gmixl.com>
 */
public class MedianOperation extends FilterOperation {

    public MedianOperation(BlockGenerator blockGen) {
        super(blockGen);
    }

    /**
     * 
     * @param values
     * @return
     */
    @Override
    public int filter(int[] values) {
        Arrays.sort(values);
        return values[values.length / 2];
    }
}