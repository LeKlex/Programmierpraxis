final public class ArtikelYen extends Fremdwaehrungsartikel {

    public ArtikelYen(String name) {
        super(name);
    }

    public ArtikelYen(String name, double price) {
        super(name, price);
    }

    @Override
    protected void setup() {
        setCurrency("JPY");
        setRate(136.92);
    }

}