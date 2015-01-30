
class Locomotive extends Car {

    private int leistung;

    Locomotive(double gewicht, double laenge, int leistung) {
        super(gewicht, laenge);
        this.leistung = leistung;
    }

    @Override
    public String toString() {
        return super.toString() + " leistung: " + this.leistung;
    }
}
