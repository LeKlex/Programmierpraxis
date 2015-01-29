// FILL IN

/**
 * Diese Klasse repräsentiert ein Schaf. Ein Schaf 
 * wird eindeutig über eine im Konstruktor automatisch 
 * vergebene Identifikationsnummer identifiziert. 
 * Das erste erzeugte Schaf hat hierbei die Identifkationsnummer 
 * 1, das zweite erzeugte Schaf die 2 usw. Beachten 
 * Sie, dass diese Zahl immer der Anzahl an bereits 
 * erzeugten Sheep-Objekten entspricht. Verwenden 
 * Sie ein entsprechendes Datenelement (mit entsprechenden 
 * Modifikatoren) in der Klasse Sheep um dies zu 
 * realisieren. 
 *  
 * Jedes Schaf hat außerdem noch eine als String 
 * definierte Farbe und eine Menge an Wolle, die 
 * es pro Monat geben kann. 
 *
 * (4.5 Punkte)
 * 
 */
public class Sheep {
	
	// Fortlaufende ID
	static int runningId = 0;
	
	//Interne ID
	private int id;
	
	//Farbe
	private String color;
	
	//Wolle per Monat
	private double woolPM;

	/**
	 * Initialisiert dieses Sheep Objekt mit den angegebenen 
	 * Parametern. Die Identifikationsnummer wird automatisch 
	 * bestimmt und gespeichert. 
	 *
	 * @param color Die Farbe des Schafs als String 
	 * @param woolPerMonth Die Wollmenge, die das 
	 * 	Schaf pro Monat produzieren kann 
	 */
	public Sheep(String color, double woolPerMonth) {
		this.color = color;
		this.woolPM = woolPerMonth;
		//Set ID and Increase running ID
		this.id = ++this.runningId;
	}

	/**
	 * Klont das übergeben Schaf - sprich initialisiert 
	 * dieses Sheep Objekt als Kopie des übergebenen 
	 * Schafs. Hierbei bleibt die Farbe des Schafs bestehen, 
	 * es wird jedoch für das neue Schaf eine neue (eindeutige) 
	 * Identfikationsnummer vergeben. Es wird davon 
	 * ausgegangen, dass ein geklontes Schaf im Vergleich 
	 * zum Original nur 90% der Menge an Wolle pro Monat 
	 * produzieren kann. 
	 *
	 * @param sheep Das Schaf, das geklont werden soll 
	 */
	public Sheep(Sheep sheep) {
		this(sheep.color, (sheep.woolPM * 0.9 ));
	}

	/**
	 * Gibt die Farbe dieses Schafs als String zurück. 
	 *
	 * @return Die Farbe dieses Schafs als String 
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * Gibt die eindeutige Identifikationsnummer des 
	 * Schafs, gefolgt von seiner Farbe und der Wollmenge 
	 * pro Monat zurück. Die korrekte Formatierung ist: 
	 *  
	 * ERWARTETE FORM DER RÜCKGABE:
	 * #1: white, woolPerMonth=2.5 
	 *
	 * @return Eine lesbare Repräsentation des Schafs 
	 */
	public String toString() {
		return "#" + this.id + ": " + this.color + ", woolPerMonth=" + this.woolPM; // REMOVE THIS
	}

}