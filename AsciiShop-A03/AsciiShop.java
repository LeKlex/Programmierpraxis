import java.util.Scanner;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * Mnr: 1328924
 *
 * Das Programm liest eine angegebene Anzahl von Zeilen eines ASCII-Bildes ein.
 * Dabei gilt es zu überprüfen, ob alle Zeilen gleich lang sind. Anschließend
 * kann ein fill-Befehl eingegeben werden, dessen Parameter die Position der zu
 * füllenden Fläche beschreibt. Abschließend wird das veränderte Bild sowie
 * seine Breite und Höhe ausgegeben.
 *
 */
public class AsciiShop {

    /**
     * Storage for Ascii Image
     */
    private static String[] image;

    /**
     * Image width - X axis
     */
    private static Integer sizeX;

    /**
     * Image height - Y axis
     */
    private static Integer sizeY;

    /**
     * Some error messages
     */
    private static final String errorMsgInput = "INPUT MISMATCH";
    private static final String errorMsgOperation = "OPERATION FAILED";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Init var
        Scanner sc = new Scanner(System.in);
        int fillX;
        int fillY;
        Integer lines;

        try {
            //Check if order "read" exists
            if (!sc.hasNext() || !sc.next().equals("read")) {
                throw new Exception(errorMsgInput);
            }

            //Check if read order has line numbers
            if (!sc.hasNextInt()) {
                throw new Exception(errorMsgInput);
            }
            lines = sc.nextInt();

            //Check if line number is allowed
            if (lines <= 0) {
                throw new Exception(errorMsgInput);
            }
            //Jump to nex line
            sc.nextLine();

            //Import Image
            if (!importImage(sc, lines)) {
                throw new Exception(errorMsgInput);
            }

            //Read fill orders
            while (sc.hasNext()) {

                if (!sc.next().equals("fill")) {
                    throw new Exception(errorMsgInput);
                }
                if (!sc.hasNextInt()) {
                    throw new Exception(errorMsgInput);
                }
                fillX = sc.nextInt(); //Read X-Coord

                if (!sc.hasNextInt()) {
                    throw new Exception(errorMsgInput);
                }
                fillY = sc.nextInt(); //Read Y-Coord

                //Check if x and y is in valid area
                if (!isBetween(fillX, 0, sizeX) || !isBetween(fillY, 0, sizeY)) {
                    throw new Exception(errorMsgOperation);
                }

                //Check with regex pattern if we have exactly 1 character
                if (!sc.hasNext(".")) {
                    throw new Exception(errorMsgInput);
                }

                //Start recursion
                fill(image, fillX, fillY, sc.next().charAt(0));
            }

            printImage();
            System.out.println(sizeX + " " + sizeY);

        } catch (Exception e) {
            //Print error message if an exception was thrown
            System.out.println(e.getMessage());
        }

    }

    /**
     * Print Image to CLI
     */
    private static void printImage() {
        for(int i = 0; i < sizeY; i++) {
            System.out.println(image[i]);
        }
    }

    /*private static void debug(String str) {
        System.out.println(str);
    }*/

    /**
     * Import an Image with Scanner class to internal String Array
     *
     * @param Scanner sc
     * @param Integer lines
     * @return boolean
     */
    private static boolean importImage(Scanner sc, Integer lines) {
        boolean success = true;

        //Create String Array with x lines
        image = new String[lines];

        //Set Class vars
        sizeX = 0;
        sizeY = 0;

        //All lines
        while (sc.hasNextLine() && sizeY < lines) {
            image[sizeY] = sc.nextLine();
            if (sizeX == 0) { //If sizeX == 0, we are on initial run
                sizeX = image[sizeY].length();
            } else if (sizeX != image[sizeY].length()) { //if any line is different, we have an invalid format
                success = false;
                break;
            }
            sizeY++;
        }

        //If read order and lines don't match
        if (sizeY != lines) {
            success = false;
        }

        return success;
    }

    /**
     * Recursive method to replace neighbour pixels
     *
     * @param image Image Array
     * @param x The X Coord.
     * @param y The Y Coord
     * @param c The Character
     */
    public static void fill(String[] image, int x, int y, char c) {

        //Store original char
        char origChar = image[y].charAt(x);

        //Only if char is different - else everything is as it should be
        if (origChar != c) {

            //Change Char with temporary var
            //Conver Line y to Char Array
            char[] tmpLine = image[y].toCharArray();
            //Replace single character on position x
            tmpLine[x] = c;
            //Write back changed line to image
            image[y] = String.valueOf(tmpLine);

            //Check all 4 directions/neighbours
            //left
            if (isFillable(x-1, y, origChar)) {
                fill(image, x-1, y, c);
            }
            //right
            if (isFillable(x+1, y, origChar)) {
                fill(image, x+1, y, c);
            }
            //above
            if (isFillable(x, y+1, origChar)) {
                fill(image, x, y+1, c);
            }
            //below
            if (isFillable(x, y-1, origChar)) {
                fill(image, x, y-1, c);
            }
        }

    }

    /**
     * Check if the field on coords x,y should be replaced
     *
     * @param int x
     * @param int y
     * @param char c
     * @return boolean
     */
    private static boolean isFillable(int x, int y, char c) {
        //System.out.println(x + " " + y);
        return (isBetween(x, 0, sizeX) && isBetween(y, 0, sizeY) && image[y].charAt(x) == c);
    }

    /**
     * Check if a number is between low and high
     *
     * @param number
     * @param low
     * @param high
     * @return boolean
     */
    public static boolean isBetween(int number, int low, int high) {
        return (number >= low && number < high);
    }
}