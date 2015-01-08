/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class ReplicateBlockGenerator extends BlockGenerator {

    public ReplicateBlockGenerator(int squareSize) {
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

            //Some correction of values
            if (x >= img.getWidth()) {
                x = img.getWidth() - 1; //take nearest to the right
            } else if (x < 0) {
                x = 0; //nearest valid
            }

            if (y >= img.getHeight()) {
                y = img.getHeight() - 1; //take nearest above
            } else if (y < 0) {
                y = 0; //nearest valid
            }

            return img.getCharset().indexOf(img.getPixel(x, y));
        }
    }
}