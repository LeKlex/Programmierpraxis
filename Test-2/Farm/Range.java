import java.util.ArrayList;

/**
 * Diese Klasse stellt eine Weidefläche dar, auf 
 * ihr können beliebig viele Schafe weiden. Für die 
 * Aufgabenstellung ist es erforderlich alle Sheep 
 * Objekte durchlaufen zu können. 
 *
 * (9.5 Punkte)
 * 
 */
public class Range {

	ArrayList<Sheep> range;

	/**
	 * Initialisierte diese Weidefläche auf der 
	 * sich anfangs keine Schafe befinden. 
	 */
	public Range() {
		this.range = new ArrayList<Sheep>();
	}

	/**
	 * Fügt das übergebene Schaf der Weidefläche hinzu. 
	 *
	 * @param sheep das hinzuzufügende Schaf 
	 */
	public void addSheep(Sheep sheep) {
		range.add(sheep);
	}

	/**
	 * Gibt zurück wieviele Schafe sich 
	 * auf der Weidefläche befinden. 
	 *
	 * @return die Anzahl an Schafen auf dieser Weidefläche 
	 */
	public int countSheep() {
		return range.size();
	}

	/**
	 * Verschiebt alle Schafe dieser Range mit der angegebenen 
	 * Farbe auf die spezifizierte Range. Beachten Sie, 
	 * dass es erforderlich ist die verschobenen Schafe 
	 * aus der Ursprungs-Weidefläche zu entfernen. Sie 
	 * können dafür eine eigene temporäre ArrayList 
	 * erzeugen, in der Sie nur die Schafe einfügen, 
	 * die Sie in der aktuellen Range behalten müssen. 
	 *
	 * @param color die Farbe der zu verschiebenden 
	 * 	Schafe als String 
	 * @param destination die Weidefläche, auf die 
	 * 	die Schafe verschoben werden sollen 
	 */
	public void moveSheep(String color, Range destination) {
		
		//Man koennte es auch ueber den Iterator verarbeiten

		ArrayList<Sheep> newRange = new ArrayList<Sheep>();
		for(Sheep s : this.range) {
			if(s.getColor().equals(color)) {
				destination.addSheep(s);				
			} else {
				newRange.add(s);
			}
		}
		this.range = newRange;

	}

	/**
	 * Verkauft alle Schafe dieser Range mit der angegebenen 
	 * Farbe. Das Verkaufen von Schafen kann als Verschieben 
	 * auf eine (temporäre) Range (die nicht Teil der 
	 * Farm ist) verstanden werden. Nutzen Sie dies 
	 * um hier doppelten Code einzusparen. 
	 *
	 * @param color die Farbe der zu verkaufenden 
	 * 	Schafe als String 
	 */
	public void sellSheep(String color) {
		moveSheep(color, new Range());
	}

	/**
	 * Gibt für jedes Schaf auf dieser Weidefläche die 
	 * eindeutige Identifikationsnummer, seine Farbe 
	 * und die Wolle pro Monat (für jedes Schaf in einer 
	 * eigenen Zeile) zurück: 
	 *  
	 * ERWARTETE FORM DER RÜCKGABE:
	 * #1: white, woolPerMonth=2.5 
	 * #4: black, woolPerMonth=2.0 
	 * #5: white, woolPerMonth=4.2 
	 *
	 * @return Eine lesbare Repräsentation der Weidefläche 
	 */
	public String toString() {
		String ret = "";
		for(Sheep s : this.range) {
			ret += s.toString() + "\n";
		}
		return ret.trim();
	}

}