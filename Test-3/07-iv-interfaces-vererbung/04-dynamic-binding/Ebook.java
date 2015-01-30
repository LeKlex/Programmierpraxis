public class Ebook extends Book {
	public Ebook (String name, int pages) {
		super(name, pages);
	}

	/**
	 * Liefert den Preis des Buchs zurück
	 * @return price
	 */
	public int getPrice() {
		return this.getPages() / 70;
	}
}
