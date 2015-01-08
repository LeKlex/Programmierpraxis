/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class UniqueCharsMetric implements Metric<AsciiImage>{

    /**
     * Calculate the absolute distance of unique chars
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int distance(AsciiImage o1, AsciiImage o2) {
        return Math.abs(o1.getUniqueChars() - o2.getUniqueChars());
    }
}