import java.util.Collection;
import java.util.LinkedHashSet;

/**
 *Metric Set
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * @param <E>
 * @version AsciiShop 10
 */
public class MetricSet<E> extends LinkedHashSet<E> {

    /**
     * Constructor
     */
    public MetricSet() {}

    /**
     * Constructor
     * @param c
     */
    public MetricSet(Collection<? extends E> c) {
        super(c);
    }

    /**
     * Search
     * @param e
     * @param m Metric to be used for distance calculation
     * @return new instance of MetricSet with result
     */
    public MetricSet<E> search(E e, Metric<? super E> m) {
        MetricSet<E> retMet = new MetricSet<E>();
        int curDis = Integer.MAX_VALUE; //Start from "max distance"
        int tmpDis;

        //Loop through every contained obj
        for(E obj : this) {
            tmpDis = m.distance(obj, e); //Calculate with given Metric

            //If actual distance is smaller than the smallest until now clear all object
            if (tmpDis < curDis) {
                curDis = tmpDis;
                retMet.clear();
            }

            //If we have the same distance  or new closer distance from above, add object
            if (tmpDis == curDis) {
                retMet.add(obj);
            }

            //If distance is bigger, ignore obj, we already found at least one closer
        }

        return retMet;
    }
}