import java.util.Scanner;
import java.util.Arrays;

public class Scrabble {
	
	/**
	* main-Methode: liest von der Standardeingabe ein und arbeitet die
	* einegegebenen Befehle ab. Erzeugt entsprechende Ausgaben.
	*/
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		String eingabe = sc.next();
		String tmpInput = new String();
		
		//macht aus einem String ein char-Array
		char[] charSet = eingabe.toCharArray(); 
		
		while(sc.hasNext()){ 
			
			switch (sc.next()) {
				case "print": 
					System.out.println(Arrays.toString(charSet));
					break;
					
				case "occurrences":
					System.out.println(occurrences(charSet, sc.next().charAt(0)));
					break;
				
				case "distinct": 
					System.out.println(distinct(sc.next()));
					break;
					
				case "buildword":
					System.out.println(buildWord(sc.next(), charSet));
					break;
					
				case "moveleft":
					moveLeft(charSet, sc.next().charAt(0));
					System.out.println(charSet);
					break;
					
				default: 
					System.out.println("Folgende Befehle:\n print\n occurrences x\n distinct abc\n buildword abc\n moveleft");
					break;		
			}	
		}
	}
	
	/**
	* bewegt alle Vorkommnisse des Zeichens c im Array charSet ganz nach 
	* links. Die Reihenfolge aller anderen Zeichen im Array ist danach 
	* beliebig.
	* @param charSet Das Array mit der Zeichenmenge
	* @param c Alle Vorkommnisse dieses Zeichens sollen im Array ganz nach 
	* links bewegt werden.
	*/
	public static void moveLeft (char[] charSet, char c) {

		String otherChars = new String();
		String movedChars = new String();
		
		for(char actualC : charSet) {
			if (actualC == c) {
				movedChars += actualC;
			} else {
				otherChars += actualC;
			}
		}
		
		movedChars += otherChars; //combine both string parts
		charSet = movedChars.toCharArray(); //convert to charArray
		System.out.println(movedChars + otherChars);
	}
	
	/**
	* liefert die Haeufigkeit des angegebenen Zeichens c in der 
	* Zeichenfolge charSet zuraeck
	* @param charSet Das Array mit der Zeichenmenge
	* @param c Alle Vorkommnisse dieses Zeichens werden gezaehlt
	* @return Die Anzahl der Vorkommnisse
	*/
	public static int occurrences(char[] charSet, char c) {
		
		//Char occurrence counter
		int counter = 0;
		
		//For each char in charSet
		for (char actualC : charSet) {
			if (actualC == c) {
				counter++;
			}
		}

		return counter;
	}
	
	
	/**
	* liefert die Haeufigkeit des angegebenen Zeichens c im 
	* String word
	* @param word Eine Zeichenkette in der die Anzahl des angegebenen 
	* Zeichens bestimmt wird
	* @param c Alle Vorkommnisse dieses Zeichens werden gezaehlt
	* @return Die Anzahl der Vorkommnisse
	*/
	public static int occurrences(String word, char c) {
		//Convert string to char array, and pass through
		return occurrences(word.toCharArray(), c);  
	}
	
	/**
	* liefert einen String, der alle Zeichen enthaelt, die auch in word 
	* vorkommen, jedoch keine Zeichen mehrfach enthaelt. Die Reihenfolge der 
	* Zeichen ist beliebig.
	* @param word Der Eingabestring
	* @return Ein String in dem die Zeichen des Eingabestrings einmalig
	* vorkommen.
	*/
	public static String distinct(String word) {
		
		String result = new String();
		
		for (char actualC : word.toCharArray()) {
			if (result.indexOf(actualC) < 0) {
				result += actualC;
			}
		}

		return result;
	}
	
	/**
	* liefert einen boolean Wert der angibt, ob das als Parameter 
	* angegebene Wort word aus den im Array from gespeicherten Zeichen
	* gebildet werden kann (true) oder nicht (false).
	* @param word Das zu bildende Wort
	* @param from Aus den Zeichen dieses Arrays soll das Wort gebildet 
	* werden
	* @return true wenn das Wort gebildet werden kann, sonst false
	*/
	public static boolean buildWord(String word, char[] from) {
		
		boolean result = true;
		//Make to string to use indexOf()
		String fromString = new String(from);
		
		for (char actualC : word.toCharArray()) {
			//if char is not found, result is flase
			if (fromString.indexOf(actualC) < 0) {
				result = false;
				break; // end loop to save time and resources
			}
		}
		
		return result;
	}
	
}
