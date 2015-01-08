/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public abstract class FilterOperation implements Operation {

    /**
     * Store the chosen BlockGenerator
     */
    final protected BlockGenerator blockGen;

    public FilterOperation(BlockGenerator blockGen) {
        this.blockGen = blockGen;
    }

    /**
     *
     * @param values
     * @return
     */
    public abstract int filter(int[] values);

    /**
     *
     * @param img
     * @return
     * @throws OperationException
     */
    @Override
    public AsciiImage execute(AsciiImage img) throws OperationException {
        AsciiImage retImg = new AsciiImage(img);
        int[] pixels;

        for (int x = 0; x < retImg.getWidth(); x++) {
            for (int y = 0; y < retImg.getHeight(); y++) {
                pixels = blockGen.getBlock(img, x, y);
                retImg.setPixel(x, y, retImg.getCharset().charAt(filter(pixels))); //use Filter of subclass
            }
        }

        return retImg;
    }
}