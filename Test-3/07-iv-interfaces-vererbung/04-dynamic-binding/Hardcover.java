public class Hardcover extends Book {
	public Hardcover (String name, int pages) {
		super(name, pages);
	}

	/**
	 * Liefert den Preis des Buchs zurück
	 * @return price
	 */
	public int getPrice() {
		return 10 + this.getPages() / 80;
	}
}
