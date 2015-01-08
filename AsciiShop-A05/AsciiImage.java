//Aufgabe 4

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class AsciiImage {

    /**
     * Image widht
     */
    protected Integer width;

    /**
     * Image height
     */
    protected Integer height;

    /**
     * Image
     */
    protected char[][] image;

    /**
     * Constructor
     * @param width Integer
     * @param height Integer
     */
    public AsciiImage(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        image = new char[height][width];
        this.clear(); //Init with "empty" pixels ('.')
    }

    /**
     * Set every "Pixel" to '.'
     */
    public void clear() {
        String pix = new String(new char[getWidth()]).replace("\0", "."); // \0 ... NULL Character, because we create an empty char Array
	for(int i = 0; i < image.length; i++) {
             image[i] = pix.toCharArray();
        }
    }

    /**
     * Returns the image width
     *
     * @return Integer width of image
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Returns the image height
     *
     * @return Integer height of image
     */
    public Integer getHeight() {
        return height;
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
     * Set/Replace a single char-Pixel
     * @param x Integer
     * @param y Integer
     * @param c char
     */
    public void setPixel(Integer x, Integer y, char c) {
        //System.out.println(x + "  " + y + "   :: " + width + " " + height);
        image[y][x] = c;
    }

    /**
     * Replace all oldChar with newChar
     * @param oldChar char
     * @param newChar char
     */
    public void replace(char oldChar, char newChar) {
        for(int idx = 0; idx < getHeight(); idx++) {
            //Create string from char array to use String.replace()
            image[idx] = new String(image[idx]).replace(oldChar, newChar).toCharArray();
        }
    }


    /**
     * Returns the actual Image (with NL at the end of each line!)
     * @return String
     */
    @Override
    public String toString() {
        //Size = (width + 1 (for '\n')) * height
        StringBuilder ret = new StringBuilder((getWidth()+1) * getHeight());
        for (char[] line : image) ret.append(line).append('\n');
        return ret.toString();
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
            for (char c : line) uChars.add(c); //Add/Replace each char in image
        }
        return uChars.size(); //return count of elements
    }

    /**
     * Flip image vertical
     */
    public void flipV() {
        char[][] flipped = new char[getWidth()][getHeight()];
        //Push first element of image to "size" in flipped, the second to size-1, aso.
        for (int idx = 0; idx < getHeight(); idx++) {
            flipped[getHeight() - idx] = image[idx];
        }
        image = flipped;
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
     *
     * @param x The X Coord.
     * @param y The Y Coord
     * @param c The char
     */
    public void fill(int x, int y, char c) {

        //Store original char
        char origChar = getPixel(x, y);

        //Only if char is different - else everything is as it should be
        if (origChar != c) {

            //Replace single character on position x
            setPixel(x, y, c);

            //Check all 4 directions/neighbours
            //left
            if (isFillable(x - 1, y, origChar)) {
                fill(x - 1, y, c);
            }
            //right
            if (isFillable(x + 1, y, origChar)) {
                fill(x + 1, y, c);
            }
            //above
            if (isFillable(x, y + 1, origChar)) {
                fill(x, y + 1, c);
            }
            //below
            if (isFillable(x, y - 1, origChar)) {
                fill(x, y - 1, c);
            }
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
     * Check if image is horizontal symmetric
     * @return Boolean
     */
    public boolean isSymmetricH() {
        boolean isSym = true;

        //For each line
        for (int iX = 0; iX < getWidth(); iX++) {
            int start = 0;
            int end = getWidth() -1;
            while (end > start) { //until we reach the middle
                if (getPixel(iX, end) != getPixel(iX, start)) {
                    isSym = false;
                    break;
                }
                end--;
                start++;
            }
        }
        return isSym;
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
}
