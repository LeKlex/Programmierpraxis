/*
 * Aufgabe: Rekursion
 *
 * DER INHALT DIESER DATEI WIRD BEWERTET!
 */

/**
 * Repräsentiert eine russische Puppe.
 * 
 * Eine russische Puppe hat ein Gewicht und 
 * kann eine weitere russische Puppen beinhalten.
 */
public class RussianDoll {
	
	private double weight;	
	private RussianDoll content;
	
	/**
	 * Initialisiert eine neue russische Puppe mit 
	 * dem angegebenen Gewicht.
	 * 
	 * @param weight Das Gewicht dieser russischen Puppe
	 */
	public RussianDoll(double weight) {
		
		this.weight = weight;
		
	}
	
	/**
	 * Legt die übergebenen Puppe in diese Puppe hinein. Falls sich
	 * bereits eine Puppe darin befindet, wird diese überschrieben.
	 * 
	 * @param russianDoll Die Puppe, die hineingelegt werden soll
	 */	
	public void insert(RussianDoll russianDoll) {
		
		this.content = russianDoll;
		
	}
	
	/**
	 * Gibt Auskunft darüber, ob die Puppen richtig verschachtelt wurden. Richtig 
	 * verschachtelt sind Puppen dann, wenn in jeder Puppe nur leichtere Puppen
	 * enthalten sind (das muss rekursiv für alle Puppen gelten).
	 *
	 * @return true, wenn alle in dieser Puppe enthaltenen Puppen richtig 
	 * verschachtelt sind, sonst false.
	 */
	public boolean isWellNested() {
		
		// FILL IN
		return false; // REMOVE THIS
				
	}
	
	/**
	 * Liefert die Anzahl an Puppen, einschließlich dieser Puppe, die mit
	 * ihrem Gewicht im angebenen Intervall liegen. 
	 *
	 * @param lower Die Untergrenze des Intervalls (inklusive)
	 * @param upper Die Obergrenze des Intervalls (inklusive)
	 * @return Die Anzahl an Puppen in dem angegeben Gewichts-Intervall
	 */
	public int numberOfDollsBetween(double lower, double upper) {
		
		// FILL IN
		return -1; // REMOVE THIS
		
	}
	
}
