/**
 * Abstract Operation Filter
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public abstract class FilterOperation implements Operation {

    /**
     * Store the chosen BlockGenerator
     */
    final protected BlockGenerator blockGen;

    /**
     * Constructor
     * @param blockGen BlockGenerator to use
     */
    public FilterOperation(BlockGenerator blockGen) {
        this.blockGen = blockGen;
    }

    /**
     * Execute filter on values
     * @param values
     * @return
     */
    public abstract int filter(int[] values);

    /**
     * Executes Filteroperation on Image
     * @param img
     * @return new filtered Image
     * @throws OperationException
     */
    @Override
    public AsciiImage execute(AsciiImage img) throws OperationException {
        AsciiImage retImg = new AsciiImage(img);
        int[] pixels;

        //Each row
        for (int x = 0; x < retImg.getWidth(); x++) {
            //Each col
            for (int y = 0; y < retImg.getHeight(); y++) {
                pixels = blockGen.getBlock(img, x, y);
                retImg.setPixel(x, y, retImg.getCharset().charAt(filter(pixels))); //use Filter of subclass
            }
        }

        return retImg;
    }
}