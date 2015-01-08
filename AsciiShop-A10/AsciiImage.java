import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Set;

/**
 * Class Ascii Image (Unit AsciiShop 7)
 *
 * Class represents an ascii image.
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class AsciiImage {

    /**
     * Image
     */
    protected char[][] image;

    /**
     * Contains allowed charset
     */
    private String charset;

    /**
     * Constructor
     * @param width Integer
     * @param height Integer
     * @param charset String, allowed charset of image
     *
     */
    public AsciiImage(Integer width, Integer height, String charset) throws InputMismatchException, OperationException {
        if (height < 1 || width < 1 || charset.isEmpty() || !hasUniqueChars(charset)) {
            throw new InputMismatchException();
        }

        this.image = new char[height][width];
        this.charset = charset;
    }

    /**
     * Copy Constructor
     *
     * Needed to rewrite this method to avoid references for stack-usage
     *
     * @param img AsciiImage
     */
    public AsciiImage(AsciiImage img) {
        this.charset = img.getCharset();
        this.image = new char[img.getHeight()][];
        for(int idx = 0; idx < img.getHeight(); idx++) {
            this.image[idx] = img.image[idx].clone(); //Clone instead of = to avoid refs.
        }
    }

    /**
     * Calculates the HashCode (Sum of all ASCII values of all pixels)
     * @return
     */
    @Override
    public int hashCode() {
        int hc = 0;

        //Iterate each line
        for (char[] line : image) {
            //Foreach each single Char
            for(char c : line) {
               hc += c; //Add ASCII value of each char in image
            }
        }

        return hc;
    }

    @Override
    public boolean equals(Object o) {
        //If not null and same class
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        //Typecast to use AsciiImage methods
        AsciiImage that = (AsciiImage) o;

        //Specific comparison - hashCode is not used, because it does not include the
        // Dimensions and Pixel-Positions in its calculation! (So an transposed image would have
        // the same hashcode!)

        //Dimensions
        if (this.getWidth() != that.getWidth() || this.getHeight() != that.getHeight()) {
            return false;
        }

        //Compare each pixel - Maybe could have used Arrays.deepEquals(arr1, arr2)...
        for (int x = 0; x < this.getWidth(); x++) {
            for(int y = 0; y < this.getHeight(); y++) {
                if (this.image[x][y] != that.image[x][y]) {
                    return false;
                }
            }
        }

        //If everything fits - it fits :-)
        return true;
    }

    /**
     * Returns the count of unique chars
     *
     * @return Intger
     */
    public int getUniqueChars() {
        Set<Character> uChars = new HashSet<Character>();

        //Iterate each line
        for (char[] line : image) {
            //Foreach each single Char
            for(char c : line) {
                uChars.add(c); //Add/Replace each char in image
            }
        }

        return uChars.size(); //return count of elements
    }


    /**
     * Checks if a string only contains unique characters
     * @param str String to check
     * @return boolean If string only contains unique characters
     */
    private boolean hasUniqueChars(String str) {
        for (char c : str.toCharArray()) {
            //If first and last occurence of char are not equal, it occures >= 2 times
            if(str.lastIndexOf(c) != str.lastIndexOf(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the brightest pixel color
     * @return
     */
    public char getBrightestPixelColor() {
        //Brightest pixel color is the last one in charset string
        return getCharset().charAt(getCharset().length() - 1);
    }

    /**
     * Returns the darkest pixel color
     * @return
     */
    public char getDarkestPixelColor() {
        return getCharset().charAt(0);
    }

    /**
     * Returns the allowed charset
     * @return
     */
    public String getCharset() {
        return charset;
    }

    /**
     * Returns the image width
     * @return Integer width of image
     */
    public Integer getWidth() {
        return (getHeight() > 0) ?  image[0].length : 0;
    }

    /**
     * Returns the image height
     * @return Integer height of image
     */
    public Integer getHeight() {
        return image.length;
    }

    /**
     * Returns a single char-Pixel
     * @param x Integer
     * @param y Integer
     * @return char
     */
    public char getPixel(Integer x, Integer y) throws IndexOutOfBoundsException {
        if( !isPixelInDimension(x, y) ) {
            throw new IndexOutOfBoundsException();
        }
        return image[y][x];
    }

    /**
     * Returns a single char-Pixel
     * Wrapper for getPixel(Integer, Integer)
     * @param p AsciiPoint
     * @return char
     */
    public char getPixel(AsciiPoint p) throws IndexOutOfBoundsException {
        return getPixel(p.getX(), p.getY());
    }

    /**
     * Set/Replace a single char-Pixel
     * @param x Integer
     * @param y Integer
     * @param c char
     */
    public void setPixel(Integer x, Integer y, char c) {
        /*System.out.println(isPixelInDimension(x, y));
        System.out.println(isCharValid(c));
        System.out.println(x + " " + y);*/

        if( !isPixelInDimension(x, y) || !isCharValid(c)) {
            throw new IndexOutOfBoundsException();
        }
        image[y][x] = c;
    }

    /**
     * Checkif Pixel-Coordinates are in the images dimensions
     * @param x
     * @param y
     * @return
     */
    public boolean isPixelInDimension(Integer x, Integer y) {
        return (x >= 0 && x < getWidth() && y >= 0 && y < getHeight() );
    }

    /**
     * Check if  a Character is in the allowed Characterset
     * @param c
     * @return
     */
    public boolean isCharValid(char c) {
        return (getCharset().indexOf(c) > -1);
    }

    /**
     * Set/Replace a single char-Pixel
     * Wrapper for setPixel(Integer, Integer, char)
     * @param p AsciiPoint
     * @param c char
     */
    public void setPixel(AsciiPoint p, char c) {
        setPixel(p.getX(), p.getY(), c);
    }

    /**
     * Returns the actual Image (with NL at the end of each line!)
     * @return String
     */
    @Override
    public String toString() {
        //Size = (width + 1 (for '\n')) * height
        StringBuilder ret = new StringBuilder((getWidth() + 1) * getHeight());
        for (char[] line : image) ret.append(line).append('\n');
        return ret.toString(); //trim() ?!
    }

    /**
     * Returns a list of AsciiPoints which equals c in image
     * @param c char Character to search for
     * @return ArrayList of AsciiPoint
     */
    public ArrayList<AsciiPoint> getPointList(char c) {
        ArrayList<AsciiPoint> plist = new ArrayList<AsciiPoint>();
        //for all lines
        for (int y = 0; y < getHeight(); y++) {
            //for all columns
            for (int x = 0; x < getWidth(); x++) {
                if (getPixel(x, y) == c) {
                    plist.add(new AsciiPoint(x, y));
                }
            }
        }
        return plist;
    }

}