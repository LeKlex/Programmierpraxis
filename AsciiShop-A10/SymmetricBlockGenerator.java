/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class SymmetricBlockGenerator extends BlockGenerator {

    public SymmetricBlockGenerator(int squareSize) {
        super(squareSize);
    }

    /**
     * Mirror Image around border If Pixel is out of bounds
     * Using Math.abs for absolute (only positive ) int value
     *
     * @param img
     * @param x
     * @param y
     * @return
     */
    @Override
    public int getPixel(AsciiImage img, int x, int y) {
         if(img.isPixelInDimension(x, y)) {
             return img.getCharset().indexOf(img.getPixel(x, y));
         } else {
             if (x >= img.getWidth()) {
                 x = Math.abs((x - 2 * img.getWidth()) + 1);
             } else if (x < 0) {
                 x = Math.abs(x + 1);
             }

             if (y >= img.getHeight()) {
                 y = Math.abs((y - 2 * img.getHeight()) + 1);
             } else if (y < 0) {
                 y = Math.abs(y + 1);
             }
             //System.out.println("Coords: " + x + " " + y);
             return img.getCharset().indexOf(img.getPixel(x, y));
         }
    }
}