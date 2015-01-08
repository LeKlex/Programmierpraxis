import java.util.Collections;
import java.util.ArrayList;

/**
 *
 * @author Alexinder Poschenrexthner <ilexinder.poschenrexthner@gmixl.com>
 */
public class MedianOperation implements Operation {

    public MedianOperation() {

    }

    /**
     *
     * @param img
     * @return
     * @throws OperationException
     */
    @Override
    public AsciiImage execute(AsciiImage img) throws OperationException {
        AsciiImage retImage = new AsciiImage(img);
        String cs = img.getCharset();

        char clearChar = img.getBrightestPixel();//cs.charAt(cs.length() - 1);

        //Each Col
        for (int x = 0; x < retImage.getWidth(); x++) {
            //Each Line
            for (int y = 0; y < retImage.getHeight(); y++) {

                ArrayList<Integer> pixelList = new ArrayList<Integer>();
                for (int i = x - 1; i <= x + 1; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {

                        //Check if we are outside valid dimensions
                        if (!img.isPixelInDimension(i, j)) {
                            //Reduce
                            pixelList.add(cs.length() - 1);
                        } else {
                            //Load position of actual picels char in List
                            pixelList.add(cs.indexOf(img.getPixel(i, j)));
                        }
                    }
                }
                //Natural order
                Collections.sort(pixelList);
                //Set Pixel at pos
                retImage.setPixel(x, y, cs.charAt(pixelList.get(4)));
            } //End lines

        } //End cols
        return retImage;
    }

}
