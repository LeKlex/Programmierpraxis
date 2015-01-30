
class DiningCar extends PassengerCar {

    private boolean open;

    DiningCar(double gewicht, double laenge, int plaetze, boolean open) {
        super(gewicht, laenge, plaetze);
        this.open = open;
    }

    boolean isOpen() {
        return this.open;
    }

    @Override
    public String toString() {
        return super.toString() + " geoeffnet: " + (isOpen() ? "ja" : "nein");
    }

}
