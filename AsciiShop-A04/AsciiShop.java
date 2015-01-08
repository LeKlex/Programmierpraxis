//Aufgabe 4

import java.util.Scanner;

public class AsciiShop {

    protected static AsciiImage img;

    public static void main(String[] args) {
        img = new AsciiImage(); //Init AsciiImage
        Scanner sc = new Scanner(System.in); //Init Scanner, read from System in

        try {
            //Check if we have "read" command..
            if (!sc.hasNext() ||  !sc.next().equals("read") || !sc.hasNextInt())
                throw new IllegalArgumentException("no param / read cmd / no line count");

            Integer readLines = new Integer(sc.nextInt()); //.. with lines

            if (readLines <= 0) throw new IllegalArgumentException("readline to lt 1"); //Line nr must be >= 1

            if (!sc.hasNextLine()) throw new IllegalArgumentException("no image"); //if no next line

            //Jump to nex line
            sc.nextLine();

            //Import Image
            if (!importImage(sc, readLines)) throw new IllegalArgumentException("importImage");

            while (sc.hasNext()) {
                String cmd = sc.next();

                //Built back to if-statements, in jdk 1.5 strings are not allowed in Switch.....
                if (cmd.equals("uniqueChars")) {
                    System.out.println(img.getUniqueChars());
                } else if (cmd.equals("transpose")) {
                    img.transpose();
                } else if (cmd.equals("flip-v")) {
                    img.flipV();
                } else if (cmd.equals("fill")) {
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
                } else if (cmd.equals("symmetric-h")) {
                    String isSym = (img.isSymmetricH()) ? "true" : "false";
                    System.out.println(isSym);
                } else {
                    //If no command matches
                    throw new IllegalArgumentException("cmd");
                }

            }

            System.out.print(img.toString());
            System.out.println(img.getWidth() + " " + img.getHeight());


        } catch (IllegalArgumentException e) {
            System.out.println("INPUT MISMATCH");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("OPERATION FAILED");
        }

    }

    /**
     * Imports image from CLI / System.in
     *
     * @param sc Scanner
     * @param readLines Integer
     * @return Boolean
     */
    protected static boolean importImage(Scanner sc, Integer readLines) {
        int cnt = 0;
        while (cnt < readLines && sc.hasNextLine()) {
            img.addLine(sc.nextLine());
            cnt++;
        }
        //Check if img is as long as defined
        return (cnt == readLines);
    }

}
