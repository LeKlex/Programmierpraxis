
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Mian class, handling the (User-) Input
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class AsciiShop {

    /**
     * Image Object
     */
    protected static AsciiImage img;

    /**
     * Stack for Undo
     */
    protected static AsciiStack imgStack;

    /**
     * Actions for no stack-backup
     */
    protected static final String[] noUndoActions = {
        "print",
        "undo",
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Init Scanner, read from System in

        try {
            //Image stack for undo
            imgStack = new AsciiStack();

            //Create new Image
            create(sc);
            //Read Commands
            while (sc.hasNext()) {
                String cmd = sc.next();

                //Check if we should do a copy for undo
                if (!Arrays.asList(noUndoActions).contains(cmd)) {
                    imgStack.push(new AsciiImage(img));
                }

                //Built back to if-statements, in jdk 1.5 strings are not allowed in Switch.....
                if ("load".equals(cmd)) {
                    load(sc);

                } else if ("replace".equals(cmd)) {
                    img = new ReplaceOperation(sc.next(".").charAt(0), sc.next(".").charAt(0)).execute(img);

                } else if ("clear".equals(cmd)) {
                    img = new ClearOperation().execute(img);

                } else if ("print".equals(cmd)) {
                    System.out.println(img.toString());

                } else if ("undo".equals(cmd)) {
                    if (imgStack.empty()) {
                        System.out.println("STACK EMPTY");
                    } else {
                        img = imgStack.pop();
                    }

                } else if ("filter".equals(cmd)) {
                    if (sc.hasNext() && sc.next().trim().equals("median")) {
                        img = new MedianOperation().execute(img);
                    } else {
                        throw new InputMismatchException("Unknown Filter");
                    }
                } else {
                    //If no command matches
                    //System.out.println("Fehler mit kommando: " + cmd);
                    throw new UnsupportedOperationException("cmd: " + cmd);
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("INPUT MISMATCH");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("OPERATION FAILED");
            //e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            System.out.println("UNKNOWN COMMAND");
            //e.printStackTrace();
        } catch (OperationException e) {
            System.out.println("OPERATION FAILED");
            //System.out.println(e.getMessage());
        }

    }

    /**
     *
     * @param sc
     * @throws InputMismatchException
     * @throws OperationException
     */
    protected static void load(Scanner sc) throws InputMismatchException, OperationException {
        if (!sc.hasNext()) {
            throw new InputMismatchException("No EOL specified");
        }

        String end = sc.next();
        sc.nextLine();
        String input = "";
        String tmpLine;
        Integer lineCnt = 0;

        while (sc.hasNextLine()) {

            if (lineCnt > img.getHeight()) {
                throw new InputMismatchException("Too many lines");
            }

            tmpLine = sc.nextLine();
            if (tmpLine.contains(end)) {
                break;
            } else {
                input += tmpLine + "\n";
            }
            lineCnt++;
        }

        img = new LoadOperation(input).execute(img);
    }

    /**
     * Read and process the "create" command
     *
     * @param sc Scanner
     * @throws InputMismatchException if no "create" command, or X or Y less
     * @throws OperationException
     */
    protected static void create(Scanner sc) throws InputMismatchException, OperationException {

        if(!"create".equals(sc.next())) {
            throw new InputMismatchException("No create command found");
        }


        Integer sizeX = new Integer(sc.nextInt()); //.. with x pixels
        Integer sizeY = new Integer(sc.nextInt()); //.. with y pixels

        if (sizeX <= 0 || sizeY <= 0) {
            throw new InputMismatchException("readline to lt 1"); //Line nr must be >= 1
        }

        if (sc.hasNext()) {
            img = new ClearOperation().execute(new AsciiImage(sizeX, sizeY, sc.next()));
        } else {
            throw new InputMismatchException("No charset given");
        }
    }

}