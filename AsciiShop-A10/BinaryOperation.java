/**
 * Operation Binary
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class BinaryOperation implements Operation {

    /**
     * Treshold Char
     */
    final private char threshold;

    /**
     *
     * @param threshold Border between white and black reduction
     */
    public BinaryOperation(char threshold) {
        this.threshold = threshold;
    }

    /**
     * Renders image to binary spectrum
     * @param img
     * @return
     * @throws OperationException if treshold is not part of imgs charset
     */
    @Override
    public AsciiImage execute(AsciiImage img) throws OperationException {
        //Check if Treshold is in charset of image
        if (!img.isCharValid(threshold)) {
            throw new OperationException("Treshold not in charset");
        }

        AsciiImage retImg = new AsciiImage(img);

        //Position of treshold
        int tresholdIndex = retImg.getCharset().indexOf(threshold);

        //Each row
        for (int x = 0; x < retImg.getWidth(); x++) {
            //Each col
            for (int y = 0; y < retImg.getHeight(); y++) {
                //Decide "black" or "white"
                char p = retImg.getBrightestPixelColor();
                if (retImg.getCharset().indexOf(retImg.getPixel(x, y)) < tresholdIndex) {
                    p = retImg.getDarkestPixelColor();
                }
                retImg.setPixel(x, y, p);
            }
        }

        return retImg;
    }

}
