/**
 * Operation Clear
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class ClearOperation implements Operation {

    /**
     * Constructor
     */
    public ClearOperation() {}

    /**
     * Clears an AsciiImage
     * @param img
     * @return
     * @throws OperationException
     */
    @Override
    public AsciiImage execute(AsciiImage img) throws OperationException {
        AsciiImage ret = new AsciiImage(img);
        char brightest = ret.getBrightestPixelColor();

        //Each row
        for(int i = 0; i < ret.getWidth(); i++) {
            //Each Col
            for(int j = 0; j < ret.getHeight(); j++) {
                //Set brightes pixel
                ret.setPixel(i, j, brightest);
            }
        }

        return ret;
    }
}
