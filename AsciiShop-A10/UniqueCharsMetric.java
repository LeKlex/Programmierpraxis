/**
 * Metric Unique Chars
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class UniqueCharsMetric implements Metric<AsciiImage>{

    /**
     * Calculate the absolute distance of unique chars
     * @param o1
     * @param o2
     * @return distance of unique chars
     */
    @Override
    public int distance(AsciiImage o1, AsciiImage o2) {
        return Math.abs(o1.getUniqueChars() - o2.getUniqueChars());
    }
}