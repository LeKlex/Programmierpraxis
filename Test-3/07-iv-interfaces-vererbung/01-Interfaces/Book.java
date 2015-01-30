/**
 * Die Klasse Book representiert ein Buch, das im MediaShop zum Verkauf angeboten wird
 * Von einem Buch sind der Name sowie der Preis bekannt
 */
public class Book {
	private String name;
	private int price;
	
	public Book (String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	/**
	 * Liefert den Namen des Buchs zurück
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Liefert den Preis des Buches zurück
	 * @return price
	 */
	public int getPrice() {
		return this.price;
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
