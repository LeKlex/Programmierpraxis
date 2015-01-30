
public class Train {

    private Locomotive lok;
    static int first = 0;
    private Car current = null;

    Train(Locomotive lok) {
        this.lok = lok;
    }

    void add(Car wagon) {
        if (first == 0) {
            wagon.connectTo(this.lok);
        } else {
            wagon.connectTo(this.current);
        }
        this.current = wagon;
        first++;
    }

    boolean hasOpenDiningCar() {

        if (this.lok.next() == null) {
            return false;
        } else {
            Car wagon = this.lok.next();
            do {
                if (wagon instanceof DiningCar) {
                    if (((DiningCar) wagon).isOpen() == true) {
                        return true;
                    }
                }
                wagon = wagon.next();
            } while (wagon != null);
        }
        return false;

    }

    public String toString() {
        String ret = this.lok.toString() + "\n";
        if (this.lok.next() != null) {
            Car wagon = this.lok.next();
            ret = ret + wagon.toString() + "\n";
            while (wagon.next() != null) {
                wagon = wagon.next();
                ret = ret + wagon.toString() + "\n";
            }
        }

        if (this.hasOpenDiningCar() == true) {
            ret = ret + "Has open dining car";
        }
        return ret;
    }

}
