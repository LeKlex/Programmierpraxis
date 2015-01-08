import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Class Ascii Image (Unit AsciiShop 6)
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
     * Represents an empty Pixel
     */
    final protected char dot = '.';

    /**
     * Constructor
     * @param width Integer
     * @param height Integer
     */
    public AsciiImage(Integer width, Integer height) {
        image = new char[height][width];
        this.clear(); //Init with "empty" pixels ('.')
    }

    /**
     * Copy Constructor
     *
     * Needed to rewrite this method to avoid references for stack-usage
     *
     * @param img AsciiImage
     */
    public AsciiImage(AsciiImage img) {
        image = new char[img.getHeight()][];
        for(int idx = 0; idx < img.getHeight(); idx++) {
            image[idx] = img.image[idx].clone(); //Clone instead of = to avoid refs.
        }
    }

    /**
     * Returns a clone of the internal Image
     * @return image char[][]
     */
    public char[][] getInternalImage() {
        return this.image.clone();
    }

    /**
     * Set every "Pixel" to '.'
     * Should stay final becaus it's used in constructor!
     */
    final public void clear() {
        // \0 ... NULL Character, because we create an "empty" char Array
        String pix = new String(new char[getWidth()]).replace("\0", String.valueOf(dot));
	for(int i = 0; i < image.length; i++) {
             image[i] = pix.toCharArray();
        }
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
     *
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
    public char getPixel(Integer x, Integer y) {
        return image[y][x];
    }

    /**
     * Returns a single char-Pixel
     * Wrapper for getPixel(Integer, Integer)
     * @param p AsciiPoint
     * @return char
     */
    public char getPixel(AsciiPoint p) {
        return getPixel(p.getX(), p.getY());
    }

    /**
     * Set/Replace a single char-Pixel
     * @param x Integer
     * @param y Integer
     * @param c char
     */
    public void setPixel(Integer x, Integer y, char c) {
        image[y][x] = c;
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
     * Replace all oldChar with newChar
     * @param oldChar char
     * @param newChar char
     */
    public void replace(char oldChar, char newChar) {
        for(AsciiPoint p : getPointList(oldChar)) {
            setPixel(p, newChar);
        }
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
        return ret.toString();
    }


    /**
     * Transpose image (like matrix)
     */
    public void transpose() {
        char[][] transposed = new char[getWidth()][getHeight()]; //width and height change
        for (int iX = 0; iX < getWidth(); iX++) {
            for(int iY = 0; iY < getHeight(); iY++) {
                transposed[iX][iY] = getPixel(iX, iY);
            }
        }
        image = transposed;
    }

    /**
     * Recursive method to replace neighbour pixels
     * <a href="http://en.wikipedia.org/wiki/Flood_fill#Stack-based_recursive_implementation_.28Four-way.29">4-Way Flood Fill algorythm</a>
     * @param x The X Coord.
     * @param y The Y Coord
     * @param c The char
     */
    public void fill(int x, int y, char c) {
        if(getPixel(x, y) != c) {
            fill(new AsciiPoint(x, y), getPixel(x, y), c);
        }
    }

    /**
     * Recursive method to replace neighbour pixels by replacing cOld with cNew
     * <a href="http://en.wikipedia.org/wiki/Flood_fill#Stack-based_recursive_implementation_.28Four-way.29">4-Way Flood Fill algorythm</a>
     * @param p AsciiPoint Start-Point
     * @param cOld char Old Char
     * @param cNew char New Char
     */
    public void fill(AsciiPoint p , char cOld, char cNew) {
        //Set Pixel
        setPixel(p, cNew);

        //Call recursivly for all neighbour pixels
        for(AsciiPoint nbp : getNearbyPoints(p, cOld)) {
            fill(nbp, cOld, cNew);
        }
    }

    /**
     * Check if the field on coords x,y should be replaced
     *
     * @param x int X-Coordinate
     * @param y int Y-Coordinate
     * @param c char
     * @return boolean
     */
    protected boolean isFillable(int x, int y, char c) {
        return (isBetween(x, 0, getWidth()) && isBetween(y, 0, getHeight()) && getPixel(x, y) == c);
    }

    /**
     * Check if a number is between low and high
     *
     * @param number int Number to Check
     * @param low int Lower number
     * @param high int Higher number
     * @return boolean
     */
    public boolean isBetween(int number, int low, int high) {
        return (number >= low && number < high);
    }

    /**
     * Draw a lin (implemented wit DDA Algorithm)
     * @param x0 int
     * @param y0 int
     * @param x1 int
     * @param y1 int
     * @param c Character
     * @see <a href="http://en.wikipedia.org/wiki/Digital_Differential_Analyzer_%28graphics_algorithm%29">DDL Algorithm</a>
     */
    public void drawLine(int x0, int y0, int x1, int y1, char c) {
        boolean swap = false; //
        // swap x, y axes (|dy| <= |dx|)
        if(Math.abs(y1 - y0) > Math.abs(x1 - x0)) {
            swap = true;
            int tmp = x0; //Change x0 <-> y0
            x0 = y0;
            y0 = tmp;
            tmp = x1; //Change x1 <-> y1
            x1 = y1;
            y1 = tmp;
        }

        //if end lt start, change start with end
        if(x1 < x0) {
            int tmp = x0; //Change x0 <-> x1
            x0 = x1;
            x1 = tmp;
            tmp = y0; //Change y0 <-> y1
            y0 = y1;
            y1 = tmp;
        }

        //Calculate m (slope of the line)
        double m = (double) (y1 - y0) / (double) (x1 - x0);
        double y = y0 + 0.5;
        //draw pixels dependend on swap
        if(swap) {
            for(int x = x0; x <= x1; x++, y += m) {
                setPixel((int) y, x, c);
            }
        } else {
            for(int x = x0; x <= x1; x++, y += m) {
                setPixel(x, (int) y, c);
            }
        }
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

    /**
     * Returns all near bys (above, below, left, right) of given point with equal content
     * @param p AsciiPoint
     * @param c char
     * @return ArrayList of AsciiPoints
     */
    private ArrayList<AsciiPoint> getNearbyPoints(AsciiPoint p, char c) {
        ArrayList<AsciiPoint> nbl = new ArrayList<AsciiPoint>();

        //Check if we have an equal nearby on +/- x
        //if we are on pont (0, y)
        if ((p.getX()) > 0 && getPixel((p.getX() - 1), p.getY()) == c) {
            nbl.add(new AsciiPoint((p.getX() - 1), p.getY()));
        }
        if ((p.getX() + 1) < getWidth() && getPixel((p.getX() + 1), p.getY()) == c) {
            nbl.add(new AsciiPoint((p.getX() + 1), p.getY()));
        }

        //Check if we have an equal nerby on +/- y
        //if we are on point (x, 0)
        if ((p.getY()) > 0 && getPixel(p.getX(), (p.getY() - 1)) == c) {
            nbl.add(new AsciiPoint(p.getX(), (p.getY() - 1)));
        }
        if ((p.getY() + 1) < getHeight() && getPixel(p.getX(), (p.getY() +1)) == c) {
            nbl.add(new AsciiPoint(p.getX(), (p.getY() + 1)));
        }

        return nbl;
    }

    /**
     * Returns the centroid Point of all pixels "c"
     * @param c char
     * @return AsciiPoint
     */
    public AsciiPoint getCentroid(char c) {
        ArrayList<AsciiPoint> plist = getPointList(c);

        //If list is empty - protect from dvision by 0!
        if (plist.size() == 0) {
            return null;
        }

        //Sum up all x and y
        int xSum = 0, ySum = 0;
        for (AsciiPoint p : plist) {
            xSum += p.getX();
            ySum += p.getY();
        }

        //Calculate the Centroid: xC = (p1.x + p2.x + ... + pn.x) / n
        //same way for yC
        int xC = (int) Math.round((double) xSum / (double) plist.size());
        int yC = (int) Math.round((double) ySum / (double) plist.size());

        return new AsciiPoint(xC, yC);
    }

    /**
     * Grows the region of all pixels witch character "c" by replacing empty pixels {@link #dot}
     * @param c char
     */
    public void growRegion(char c) {
        //If "pixel" is same as "empty", no need to replace...
        if (dot != c) {
            for(AsciiPoint p : getPointList(c)) {
                for(AsciiPoint nb : getNearbyPoints(p, dot)) {
                    setPixel(nb, c);
                }
            }
        }
    }


    /**
     * ## BONUS-Aufgabe ##
     *
     * Straightens a region of pixels equal to c.
     * All pixels with less or equal 2 nearby pixels will be removed (set to "dot")
     *
     * @param c char
     */
    public void straightenRegion(char c) {
        Boolean changed;

        //Run at least one time and ...
        do {
            changed = false;

            //Get List-Iterator
            Iterator<AsciiPoint> iterator = getPointList(c).iterator();

            //For each List-Element
            while (iterator.hasNext()) {
                //Load Point
                AsciiPoint p = iterator.next();
                //If less or equal 2 neighbors
                if (getNearbyPoints(p, c).size() <= 1) {
                    changed = true; //We made a change
                    iterator.remove(); //Remove
                    setPixel(p, dot); //Set Pixel with dot
                }
            }

        } while (changed); // ... until no more changes are done

    }


    /**
     * Returns the count of unique chars
     *
     * @return Intger Count of unique chars
     */
    public Integer getUniqueChars() {
        Set<Character> uChars = new HashSet<Character>();
        //Iterate each line
        for (char[] line : image) {
            //Foreach each single Char
            for (char c : line) {
                uChars.add(c); //Add/Replace each char in image
            }
        }
        return uChars.size(); //return count of elements
    }

    /**
     * Flip image vertical
     */
    public void flipV() {
        char[][] flipped = new char[getHeight()][];
        for (int idx = 0; idx < getHeight(); idx++) {
            flipped[idx] = image[getHeight() - idx -1].clone();
        }
        image = flipped;
    }

}