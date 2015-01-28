/**
 * Abstract Generator Block
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public abstract class BlockGenerator {

    /**
     * Size of square / block
     */
    final protected int squareSize;

    /**
     * Define the square size of block (3 => square of 3x3)
     * @param squareSize length of square edge
     */
    public BlockGenerator(int squareSize) {
        this.squareSize = squareSize;
    }

    /**
     * Return pixel
     * Handles behaviour if pixel out of region aso.
     * @param img Image to reade from
     * @param x X-Axis position
     * @param y Y-Axis position
     * @return
     */
    public abstract int getPixel(AsciiImage img, int x, int y);

    /**
     * Calculates block by squaresize
     * @param img
     * @param x X-Axis position
     * @param y Y-Axis position
     * @return
     */
    public int[] getBlock(AsciiImage img, int x, int y) {
        int[] retBlock = new int[squareSize * squareSize];
        int blockIdx = 0;

        //Calculate before loop-condition!
        int squrSizeHalf = squareSize / 2;
        for (int i  = x - squrSizeHalf; i <= x + squrSizeHalf; i++) {
            for (int j = y - squrSizeHalf; j <= y + squrSizeHalf; j++) {
                retBlock[blockIdx++] = getPixel(img, i, j);
            }
        }

        return retBlock;
    }

}