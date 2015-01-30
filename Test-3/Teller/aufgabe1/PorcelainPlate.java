package aufgabe1;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public abstract class PorcelainPlate extends Plate {

    protected boolean hasGoldRim;
    protected int washingCycles = 1000;

    public PorcelainPlate(double diameter, double depth) {
        super(diameter, depth);
    }

    public void decreseWashingCycles() {
        washingCycles--;
    }

    @Override
    public String toString() {
        return super.toString() + ", washing cycles: " + washingCycles + ", gold rim:" + hasGoldRim;
    }

}
