
/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class BinaryOperation implements Operation {

    final private char threshold;

    /**
     *
     * @param threshold
     */
    public BinaryOperation(char threshold) {
        this.threshold = threshold;
    }

    /**
     *
     * @param img
     * @return
     * @throws OperationException
     */
    @Override
    public AsciiImage execute(AsciiImage img) throws OperationException {

        if (!img.isCharValid(threshold)) {
            throw new OperationException("Treshold not in charset");
        }

        AsciiImage retImg = new AsciiImage(img);
        int tresholdIndex = retImg.getCharset().indexOf(threshold);

        for (int x = 0; x < retImg.getWidth(); x++) {
            for (int y = 0; y < retImg.getHeight(); y++) {
                if (retImg.getCharset().indexOf(retImg.getPixel(x, y)) < tresholdIndex) {
                    retImg.setPixel(x, y, retImg.getDarkestPixelColor());
                } else {
                    retImg.setPixel(x, y, retImg.getBrightestPixelColor());
                }
            }
        }

        return retImg;
    }

}
