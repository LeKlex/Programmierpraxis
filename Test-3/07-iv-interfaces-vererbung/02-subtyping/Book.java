/**
 * Die Klasse Book representiert ein Buch, das im MediaShop zum Verkauf angeboten wird
 * Von einem Buch sind der Name sowie die Seitenzahl bekannt
 */
public class Book implements Item {
	private String name;
	private int pages;
	
	public Book (String name, int pages) {
		this.name = name;
		this.pages = pages;
	}
	
	/**
	 * Liefert den Namen des Buchs zurück
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Liefert die Seitenzahl des Buchs zurück
	 * @return pages
	 */
	public int getPages() {
		return this.pages;
	}

	/**
	 * Liefert den Preis des Buchs zurück
	 * @return price
	 */
	public int getPrice() {
		return this.pages / 100;
	}
	
	/**
	 * Liefert eine lesbare Representation eines Buchs zurück:
	 * @return 
	 */
	@Override
	public String toString() {
		return "Book: " + getName() + " (" + getPrice() + " Euro)";
	}
}
