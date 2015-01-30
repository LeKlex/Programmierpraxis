public class Softcover extends Book {
	public Softcover (String name, int pages) {
		super(name, pages);
	}

	/**
	 * Liefert den Preis des Buchs zurück
	 * @return price
	 */
	public int getPrice() {
		return 5 + this.getPages() / 100;
	}
}
