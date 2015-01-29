public abstract class Fremdwaehrungsartikel extends Artikel {

    protected double rate;
    protected String curName;

    public Fremdwaehrungsartikel(String name) {
        super(name);
        setup();
    }

    public Fremdwaehrungsartikel(String name, double price) {
        this(name);
        setPrice(price);
    }

    /**
     * Setup currency naem and rate in subclasses
     */
    abstract protected void setup ();

    /**
     * Set price, will be calculated to Eur internal
     * @param price
     */
    @Override
    public void setPrice(double price) {
        super.setPrice(price  / getRate() ); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Set currency rate
     * @param rate
     */
    protected void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * Get currency Rate
     * @return
     */
    protected double getRate() {
        return rate;
    }

    /**
     * Set currency name
     * @param curName
     */
    protected void setCurrency(String curName) {
        this.curName = curName;
    }

    /**
     * Get currency name
     * @return
     */
    protected String getCurrency() {
        return curName;
    }

    /**
     *
     * @return
     */
    @Override
    public String format() {
        return super.format() + " (" + getCurrency() + " " + Math.round(getPrice()*getRate()*100.0)/100.0 + ")";
    }

}
