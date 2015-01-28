/**
 * Metric Count Pixel
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class PixelCountMetric implements Metric<AsciiImage> {

    /**
     * Returns the absolute diffeenze between both areas
     * @param o1
     * @param o2
     * @return difference
     */
    @Override
    public int distance(AsciiImage o1, AsciiImage o2) {
        return Math.abs((o1.getHeight() * o1.getWidth()) - (o2.getHeight() * o2.getWidth()));
    }

}