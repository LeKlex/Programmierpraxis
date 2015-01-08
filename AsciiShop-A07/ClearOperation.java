/**
 * Clear Operation
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class ClearOperation implements Operation {

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
        char brightest = ret.getBrightestPixel();

        for(int i = 0; i < ret.getWidth(); i++) {
            for(int j = 0; j < ret.getHeight(); j++) {
                ret.setPixel(i, j, brightest);
            }
        }

        return ret;
    }
}
