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
    protected List<String> image;

    /**
     * Constructor
     */
    public AsciiImage() {
        width = height = 0;
        image = new ArrayList<String>();
    }

    /**
     * Adds a line to the Image
     *
     * @param line String
     * @return Boolean
     */
    public boolean addLine(String line) {
        if (0 == width) {
            width = line.length(); //Init general line length
        }
        //If line length equals length of first line append
        if (line.length() == width) {
            image.add(line);
            height++;
            return true;
        }
        return false;
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
     * Returns the actual Image (with NL at the end of each line!)
     *
     * @return String
     */
    @Override
    public String toString() {
        String ret = new String();
        //Create Iterator and iterate through each string element in list
        for (Iterator<String> i = image.iterator(); i.hasNext();) {
            ret += i.next() + "\n";
        }
        return ret;
    }

    /**
     * Returns the count of unique chars
     *
     * @return Intger
     */
    public Integer getUniqueChars() {
        Set<Character> uChars = new HashSet<Character>();

        //Iterate each line
        for (Iterator<String> i = image.iterator(); i.hasNext();) {
            //Foreach each single Char
            for (char c : i.next().toCharArray()) {
                uChars.add(c); //Add/Replace each char in image
            }
        }
        return uChars.size(); //return count of elements
    }

    /**
     * Flip image vertical
     */
    public void flipV() {
        List<String> flipped = new ArrayList<String>();
        //Push first element of image to "size" in flipped, the second to size-1, aso.
        for (int idx = 0; idx < image.size(); idx++) {
            flipped.add(idx, image.get(image.size() - (idx+1)));
        }
        image = flipped;
    }

    /**
     * Flip image vertical and horizontal
     */
    public void transpose() {
        List<String> transposed = new ArrayList<String>();
        Iterator<String> i = image.iterator();
        for (int idx = 0; i.hasNext(); idx++) {
            String line = i.next();
            for (int elemIdx = 0; elemIdx < getWidth(); elemIdx++ ) {
                if (0 == idx) transposed.add(elemIdx, ""); //Add empty string if array is empty
                //take string from index, append char, store back to position
                transposed.set(elemIdx,   transposed.get(elemIdx) + String.valueOf(line.charAt(elemIdx)));
            }
        }
        image = transposed;
        height = image.size();
        width = image.get(0).length();
    }

    /**
     * Recursive method to replace neighbour pixels
     *
     * @param image Image Array
     * @param x The X Coord.
     * @param y The Y Coord
     * @param c The Character
     */
    public void fill(int x, int y, char c) {

        //Store original char
        char origChar = image.get(y).charAt(x);

        //Only if char is different - else everything is as it should be
        if (origChar != c) {

            //Change Char with temporary var
            //Conver Line y to Char Array
            char[] tmpLine = image.get(y).toCharArray();
            //Replace single character on position x
            tmpLine[x] = c;
            //Write back changed line to image
            image.set(y, String.valueOf(tmpLine));

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
     * @param x int
     * @param y int
     * @param c char
     * @return boolean
     */
    protected boolean isFillable(int x, int y, char c) {
        return (isBetween(x, 0, getWidth()) && isBetween(y, 0, getHeight()) && image.get(y).charAt(x) == c);
    }

    /**
     * Check if a number is between low and high
     *
     * @param number
     * @param low
     * @param high
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

        //Iterate each line
        for (Iterator<String> i = image.iterator(); i.hasNext();) {
            int start = 0;
            int end = getWidth() -1;
            String line = i.next(); //get actual line
            while (end > start) { //until we reach the middle
                if (line.charAt(end) != line.charAt(start)) {
                    isSym = false;
                    break;
                }
                end--;
                start++;
            }
        }

        return isSym;
    }
}
