import java.util.Scanner;

/**
 * Operation Load
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class LoadOperation implements Operation {

    /**
     * Loaded Data
     */
    final private String data;

    /**
     * Scanner to be used as String tokenizer
     */
    final private Scanner sc;

    /**
     * Constructor
     * @param data Loaded Image data
     */
    public LoadOperation(String data) {
        this.data = data;
        this.sc = new Scanner(data);
    }

    /**
     * Returns a new AsciiImage instace with loaded data
     * @param img
     * @return new AsciiImage instace with loaded data
     * @throws OperationException if a char is not in charset or dimensions do not fit
     */
    @Override
    public AsciiImage execute(AsciiImage img) throws OperationException {

        //Check charset
        if (!containsOnlyCharsetChars(img.getCharset())) {
            throw new OperationException("Illegal character(s)");
        }

        //Check Dimensions
        if (!hasValidDimensions(img)) {
            throw new OperationException("Dimension(s) dont match");
        }

        //Copy Image
        AsciiImage retImage = new AsciiImage(img);

        for (int i = 0; i < retImage.getHeight(); i++) {
            String line = sc.nextLine();

            //Write each "Pixel" from line to image
            for (int idx = 0; idx < retImage.getWidth(); idx++) {
                retImage.setPixel(idx, i, line.charAt(idx));
            }
        }

        return retImage;
    }

    /**
     * Check if input data matches the AsciiImage Dimensions
     * @param img
     * @return
     */
    private boolean hasValidDimensions(AsciiImage img) {
        String[] splitted = data.split("\n");

        //First check height
        if (splitted.length != img.getHeight()) {
            return false;
        }

        //Check __each__ line length
        for(String line : splitted) {
            if (line.length() != img.getWidth()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Removes all legal chars from data, if length is >0 at the end, there is
     * at least one illegal char left
     *
     * @param charset Allowed Chars
     * @return if data only contains legal chars
     */
    private boolean containsOnlyCharsetChars(String charset) {
        //Create copy of data string, remove leading/trailing spaces and NewLines
        String dataTmp = new String(data).replaceAll("\\r|\\n", "").trim();

        //Remove all legal chars
        for (char c : charset.toCharArray()) {
            dataTmp = dataTmp.replace(String.valueOf(c), "");
        }

        //If any char is left -> it must be illegal!
        return (dataTmp.length() == 0);
    }

}
