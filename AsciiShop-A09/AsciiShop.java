import java.util.Arrays;
import java.util.HashMap;
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

    /**
     * Store Factory-Instances
     */
    private static HashMap<String, Factory> cmds;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Init Scanner, read from System in
        buildMenue();

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

                 if ("print".equals(cmd)) {
                    System.out.println(img.toString());

                } else if ("undo".equals(cmd)) {
                    if (imgStack.empty()) {
                        System.out.println("STACK EMPTY");
                    } else {
                        img = imgStack.pop();
                    }

                } else  if (cmds.get(cmd) != null) {
                    img = cmds.get(cmd).create(sc).execute(img);
                } else {
                    //If no command matches
                    throw new UnsupportedOperationException("cmd: " + cmd);
                }

            }

        } catch (InputMismatchException e) {
            System.out.println("INPUT MISMATCH");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("OPERATION FAILED");
            //System.out.println(e.getMessage());
            //e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            System.out.println("UNKNOWN COMMAND");
            //e.printStackTrace();
        } catch (OperationException e) {
            System.out.println("OPERATION FAILED");
            //System.out.println(e.getMessage());
            //e.printStackTrace();
        } catch (FactoryException e) {
            System.out.println("INPUT MISMATCH");
            //System.out.println(e.getMessage());
            //e.printStackTrace();
        }

    }

    /**
     * Build up HashMap with Factories for menue
     * @param cmds
     */
    private static void buildMenue () {
        cmds = new HashMap<String, Factory>();
        cmds.put("clear", new ClearFactory());
        cmds.put("binary", new BinaryFactory());
        cmds.put("replace", new ReplaceFactory());
        cmds.put("load", new LoadFactory());
        cmds.put("filter", new FilterFactory());
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