import java.util.Scanner;

/**
 * Operation Load
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class LoadOperation implements Operation {

    final private String data;
    final private Scanner sc;

    public LoadOperation(String data) {
        this.data = data;
        this.sc = new Scanner(data);
    }

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
     * @param charset
     * @return
     */
    private boolean containsOnlyCharsetChars(String charset) {
        //Create copy of data string, remove leading/trailing spaces and NewLines
        String dataTmp = new String(data).replaceAll("\\r|\\n", "").trim();

        for (char c : charset.toCharArray()) {
            dataTmp = dataTmp.replace(String.valueOf(c), "");
        }

        return (dataTmp.length() == 0);
    }

}
