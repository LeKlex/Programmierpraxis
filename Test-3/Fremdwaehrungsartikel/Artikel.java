
public class Artikel extends Dinge implements Formatierung {

    /**
     * Price of Artikel
     */
    protected double priceEur = 10;

    /**
     * Constructor
     * @param name Name of Artikel
     */
    public Artikel(String name) {
        super(name);
    }

    /**
     * Constructor
     * @param name Name of Artikel
     * @param price Price of Artikel in EUR
     */
    public Artikel(String name, double price) {
        this(name);
        setPrice(price);
    }

    /**
     * Returns price in Euro
     * @return Price in Euro
     */
    public double getPrice() {
        return priceEur;
    }

    /**
     * Set new price of Artikel
     * @param price New price of Artikel
     */
    public void setPrice(double price) {
        System.out.println(price);
        this.priceEur = price;
    }

    /**
     * Returns name of Artikel
     * @return Name of Artikel
     */
    public String getName() {
        return name;
    }

    @Override
    public String format() {
        return name + ": EUR " + Math.round(priceEur*100.0)/100.0;
    }

}
