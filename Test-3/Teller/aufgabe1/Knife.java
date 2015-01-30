package aufgabe1;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class Knife {

    protected int length;
    protected int washingCycles = 700;

    public Knife(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "knife length: " + length + "washing cycles: " + washingCycles;
    }

}
