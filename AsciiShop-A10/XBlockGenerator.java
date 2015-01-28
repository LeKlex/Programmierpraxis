/**
 * BlockGenerator X
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class XBlockGenerator extends BlockGenerator {

    /**
     * Constructor
     * @param squareSize
     */
    public XBlockGenerator(int squareSize) {
        super(squareSize);
    }

    /**
     *
     * @param img
     * @param x
     * @param y
     * @return
     */
    @Override
    public int getPixel(AsciiImage img, int x, int y) {
        if (img.isPixelInDimension(x, y)) {
            return img.getCharset().indexOf(img.getPixel(x, y));
        } else {
            return img.getCharset().length() - 1;
        }
    }
}