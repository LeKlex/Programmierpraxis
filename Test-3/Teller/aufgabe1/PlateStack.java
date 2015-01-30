package aufgabe1;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class PlateStack {

    protected Plate head;

    public PlateStack() {
        head = null;
    }

    public void push(Plate p) {
        if (head == null) {
            head = p;
        } else {
            p.next = head;
            head = p;
        }
    }
}
