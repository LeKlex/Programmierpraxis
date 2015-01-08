/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class CreateOperation implements Operation {

    final private int width;
    final private int height;
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
     *
     * @param img
     * @return
     * @throws OperationException
     */
    @Override
    public AsciiImage execute(AsciiImage img) throws OperationException {
        return new AsciiImage(width, height, charset);
    }
}