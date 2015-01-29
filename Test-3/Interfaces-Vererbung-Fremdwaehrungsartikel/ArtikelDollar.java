final public class ArtikelDollar extends Fremdwaehrungsartikel {

    public ArtikelDollar(String name) {
        super(name);
    }

    public ArtikelDollar(String name, double price) {
        super(name, price);
    }

    @Override
    protected void setup() {
        setCurrency("USD");
        setRate(1.313);
    }

}
