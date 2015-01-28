/**
 * Block Generator Circular
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class CircularBlockGenerator extends BlockGenerator {

    public CircularBlockGenerator(int squareSize) {
        super(squareSize);
    }

    /**
     * If pixel is out of bounds - wrap around
     * @param img
     * @param x
     * @param y
     * @return
     */
    @Override
    public int getPixel(AsciiImage img, int x, int y) {
        int posX = (x + img.getWidth()) % img.getWidth();
        int posY = (y + img.getHeight()) % img.getHeight();
        return img.getCharset().indexOf(img.getPixel(posX, posY));
    }

}