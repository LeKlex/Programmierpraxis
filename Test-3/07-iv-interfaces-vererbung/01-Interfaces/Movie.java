/**
 * Die Klasse Movie representiert einen Film, der im MediaStore zum Verkauf angeboten wird
 * Von einem Film sind der Name sowie der Preis bekannt
 */
public class Movie {
	private String name;
	private int price;
	
	public Movie(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	/**
	 * Liefert den Namen des Films zurück
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Liefert den Preis des Films zurück
	 * @return price
	 */
	public int getPrice() {
		return this.price;
	}
	
	/**
	 * Liefert eine lesbare Representation eines Films zurück:
	 * @return 
	 */
	@Override
	public String toString() {
		return "Movie: " + getName() + " (" + getPrice() + " Euro)";
	}
}
