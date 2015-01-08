/**
 * Class Ascii Point 
 *
 * Represents a single Point
 * Coordinates X and Y can only be set on init (immutable)!
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class AsciiPoint {

    /**
     * X Coord, immutable
     */
    final private int x;

    /**
     * Y Coord, immutable
     */
    final private int y;

    /**
     * Init a new Point with its coords
     * @param x int
     * @param y int
     */
    public AsciiPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns x Coord
     * @return int x
     */
    public int getX() {
        return x;
    }

    /**
     * Returns y Coord
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * Returns x and y coords in format (x,y) as string
     * Overrides std. toString
     * @return String
     */
    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
}