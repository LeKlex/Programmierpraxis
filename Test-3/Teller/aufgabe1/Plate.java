package aufgabe1;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public abstract class Plate {
    /**
     * Diameter of Plate in cm
     */
    protected double diameter;

    /**
     * Depth of plate in cm
     */
    protected double depth;

    /**
     * Runnind ID
     */
    protected static int serialCounter = 1;

    /**
     * Internal Serialnumber
     */
    protected int serialNumber;

    /**
     * This plate stands on next Plate
     */
    protected Plate next;

    /**
     *
     * @param diameter
     * @param depth
     */
    public Plate(double diameter, double depth) {
        this.diameter = diameter;
        this.depth = depth;
        this.serialNumber = serialCounter++;
    }

    /**
     * Plate below
     * @param p
     */
    public void onPlate(Plate p) {
        this.next = p;
    }


    @Override
    public String toString() {
        return "serialNr: " +serialNumber + ", diameter: " + diameter + ", depth:" + depth;
    }

}
