
public class PassengerCar extends Car {

    private int plaetze;

    PassengerCar(double gewicht, double laenge, int plaetze) {
        super(gewicht, laenge);
        this.plaetze = plaetze;
    }

    @Override
    public String toString() {
        return super.toString() + " plaetze: " + this.plaetze;
    }

}
