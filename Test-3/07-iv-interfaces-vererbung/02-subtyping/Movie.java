/**
 * Die Klasse Movie representiert einen Film, der im MediaStore zum Verkauf angeboten wird
 * Von einem Film sind der Name sowie die Filmdauer bekannt
 */
public class Movie  implements Item {
	private String name;
	private int duration;
	
	public Movie(String name, int duration) {
		this.name = name;
		this.duration = duration;
	}
	
	/**
	 * Liefert den Namen des Films zurück
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Liefert die Dauer des Films zurück
	 * @return duration
	 */
	public int getDuration() {
		return this.duration;
	}
	
	/**
	 * Liefert den Preis des Films zurück
	 * @return price
	 */
	public int getPrice() {
		return this.duration / 10;
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
