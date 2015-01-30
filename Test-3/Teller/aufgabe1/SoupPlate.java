package aufgabe1;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class SoupPlate extends PorcelainPlate {
    public SoupPlate(double diameter, boolean hasGoldRim) {
        super(diameter, 3);
        this.hasGoldRim = hasGoldRim;
    }
}