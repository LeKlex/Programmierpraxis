/*
 * Aufgabe: Rekursion
 * 
 * Der Inhalt dieser Datei wird nicht bewertet.
 */
public class DollCollector {
	
	public static void main(String[] args) {
	
		RussianDoll doll1 = new RussianDoll(1.2);
		RussianDoll doll2 = new RussianDoll(1.3);
		RussianDoll doll3 = new RussianDoll(1.4);
		RussianDoll doll4 = new RussianDoll(1.6);
		RussianDoll doll5 = new RussianDoll(1.5);
		
		doll4.insert(doll3);
		doll3.insert(doll2);
		doll2.insert(doll1);
		
		/*
		 * Fall 1
		 * Sind die Puppen richtig verschachtelt?
		 */
		System.out.println(doll4.isWellNested()); 
		// Ausgabe: true
		
		/*
		 * Fall 2
		 * Sind die Puppen richtig verschachtelt?
		 */
		doll5.insert(doll4);
		System.out.println(doll5.isWellNested()); 
		// Ausgabe: false
		
		/*
		 * Fall 3
		 * Wieviele Puppen, ausgehend von doll4,
		 * haben ein Gewicht zwischen 1.3 und 1.5?
		 */
		System.out.println(doll4.numberOfDollsBetween(1.3,1.5)); 
		// Ausgabe: 2
		
	}
	
}