/**
 * Operation Create
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @version AsciiShop 10
 */
public class CreateOperation implements Operation {

    /**
     * X-Axis dimension
     */
    final private int width;

    /**
     * Y-Axis dimension
     */
    final private int height;

    /**
     * Allowed charset
     */
    final private String charset;

    /**
     * Creates a new AsciiImage
     * @param width Image Width
     * @param height Image height
     * @param charset Image Charset
     */
    public CreateOperation(int width, int height, String charset) {

        //Store params
        //Tought about createing AsciiImage instance already here, but it would cause
        // problems if we generate multiple new AsciiImages with this CreateOperationInstance!

        this.width = width;
        this.height = height;
        this.charset = charset;
    }

    /**
     * Create new AsciiImage with given params
     * @param img
     * @return new AsciiImage
     * @throws OperationException
     */
    @Override
    public AsciiImage execute(AsciiImage img) throws OperationException {
        return new AsciiImage(width, height, charset);
    }
}