//Aufgabe 4

import java.beans.EventHandler;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AsciiShop {

    /**
     * Image Object
     */
    protected static AsciiImage img;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Init Scanner, read from System in

        try {
            //Create new Image
            create(sc);
            //Read Commands
            while (sc.hasNext()) {
                String cmd = sc.next();

                //Built back to if-statements, in jdk 1.5 strings are not allowed in Switch.....
                if (cmd.equals("load")) {
                    load(sc);
                } else if (cmd.equals("clear")) {
                    img.clear();
                } else if (cmd.equals("uniqueChars")) {
                    System.out.println(img.getUniqueChars());
                } else if (cmd.equals("replace")) {
                    replace(sc);
                } else if (cmd.equals("transpose")) {
                    img.transpose();
                } else if (cmd.equals("flip-v")) {
                    img.flipV();
                } else if (cmd.equals("fill")) {
                    fill(sc);
                } else if (cmd.equals("symmetric-h")) {
                    String isSym = (img.isSymmetricH()) ? "true" : "false";
                    System.out.println(isSym);
                } else if(cmd.equals("line")) {
                    line(sc);
                } else if(cmd.equals("print")) {
                    System.out.println(img.toString());
                } else {
                    //System.out.println("Fehler mit kommando: " + cmd);
                    //If no command matches
                    throw new UnsupportedOperationException("cmd");
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("INPUT MISMATCH");
            //e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("INPUT MISMATCH");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("OPERATION FAILED");
            //e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            System.out.println("UNKNOWN COMMAND");
            //e.printStackTrace();
        }

    }

    /**
     *
     * @param sc Scanner
     * @throws IllegalArgumentException
     * @throws IndexOutOfBoundsException
     */
    protected static void fill(Scanner sc) throws IllegalArgumentException, IndexOutOfBoundsException {

        //Need to read x, y and char
        if (!sc.hasNextInt()) throw new IllegalArgumentException("fill no x");
        int fillX = sc.nextInt(); //Read X-Coord

        if (!sc.hasNextInt()) throw new IllegalArgumentException("fill no y");
        int fillY = sc.nextInt(); //Read Y-Coord

        //Check if x and y is in valid area
        if (!img.isBetween(fillX, 0, img.getWidth()) || !img.isBetween(fillY, 0, img.getHeight())) {
             throw new IndexOutOfBoundsException("fill coordinate");
        }

        //Check with regex pattern if we have exactly 1 character
        if (!sc.hasNext(".")) throw new IllegalArgumentException("fill no replace char");

        img.fill(fillX, fillY, sc.next().charAt(0));
    }

    /**
     * Load Image from CLI / System in
     * @param sc Scanner
     */
    protected static void load(Scanner sc) throws IllegalArgumentException, InputMismatchException {
        String end = sc.next();
        sc.nextLine();
        for (int i = 0; i < img.getHeight(); i++) {
            String line = sc.nextLine();
            //Check if line is as long as set
            if (line.length() != img.getWidth()) throw new IllegalArgumentException("Line length does not match");
            //Write each "Pixel" from line to image
            for(int idx = 0; idx < img.getWidth(); idx++) {
                img.setPixel(idx, i, line.charAt(idx));
            }
        }
        //now end-symbol
        sc.next(end);
    }

    /**
     * Read and process the "create" command
     * @param sc Scanner
     * @throws IllegalArgumentException if no "create" command, or X or Y less then 1
     */
    protected static void create (Scanner sc) throws IllegalArgumentException {
        //Check if we have "read" command..
        sc.next("create");
        Integer sizeX = new Integer(sc.nextInt()); //.. with x pixels
        Integer sizeY = new Integer(sc.nextInt()); //.. with y pixels

        if (sizeX <= 0 || sizeY <= 0)
            throw new IllegalArgumentException("readline to lt 1"); //Line nr must be >= 1

        img = new AsciiImage(sizeX, sizeY);
    }

    /**
     * Prepares Params to draw a line in AsciiImage
     * @param sc Scanner
     * @throws IllegalArgumentException
     */
    protected static void line(Scanner sc) throws IllegalArgumentException {
        //Read start coords
        int xStart = sc.nextInt();
        int yStart = sc.nextInt();
        //Read end Coords
        int xEnd = sc.nextInt();
        int yEnd = sc.nextInt();

        //Check Ranges
        if(!checkMultiIntsGreaterTahn(0, xStart, xEnd, yStart, yEnd)
                || xStart >= img.getWidth()
                || xEnd >= img.getWidth()
                || yStart >= img.getHeight()
                || yEnd >= img.getHeight())
        {
            throw new IllegalArgumentException("Line-Coords out of Image range");
        }

        img.drawLine(xStart, yStart, xEnd, yEnd, sc.next(".").charAt(0));

    }

    /**
     * Check if Ints gt number
     * @param number Integer
     * @param ints Integer Multiple
     * @return boolean
     */
    protected static boolean checkMultiIntsGreaterTahn(Integer number, Integer... ints) {
        Boolean check = true;
        for(int i : ints) {
            if (i < number) {
                check = false;
                break;
            }
        }
        return check;
    }

    /**
     * Replace characters
     * @param sc Scanner
     * @throws IllegalAccessException
     */
    protected static void replace(Scanner sc) throws IllegalArgumentException {
        img.replace(sc.next(".").charAt(0), sc.next(".").charAt(0));
    }

}
