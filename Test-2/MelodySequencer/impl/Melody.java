import java.util.ArrayList;

/**
 * Diese Klasse repr�sentiert eine Melodie, die aus mehreren Noten besteht. Die
 * Noten werden in geeigneter Form gespeichert. Verschiedene Methoden
 * erm�glichen das Hinzuf�gen von Noten, das Kopieren von Notenfolgen und das
 * Transponieren der Melodie. Diese Klasse liest weder direkt von System.in ein,
 * noch gibt sie direkt auf System.out aus.
 */
public class Melody {

	private int bpm;
	private ArrayList<Note> alMelodie = new ArrayList<Note>();

	/**
	 * erzeugt eine neue Instanz von Melody und speichert das �bergebene Tempo
	 * (bpm, Schl�ge pro Minute).
	 * 
	 * @param bpm
	 *            Das Tempo in Schl�gen pro Minute
	 */
	public Melody(int bpm) {
		this.bpm = bpm;
	}

	/**
	 * f�gt am Ende der Melodie die �bergebene Note hinzu.
	 * 
	 * @param note
	 *            Die hinzuzuf�gende Note
	 */
	public void addNote(Note note) {
		this.alMelodie.add(note);
	}

	/**
	 * kopiert eine Folge von Noten und gibt diese als neue Melodie (Melody)
	 * zur�ck. Die neue Melodie hat dabei das gleiche Tempo, die kopierten Noten
	 * sollen echte Kopien der urspr�nglichen Noten sein. Die neue Melodie
	 * beinhaltet die Noten zwischen inklusive beginIndex und exklusive
	 * endIndex, hat also die L�nge endIndex - beginIndex. Besteht die
	 * gespeicherte Melodie beispielsweise aus den T�nen do - re - mi - fa -
	 * sol, so lautet die neue Melodie bei Aufruf der Methode mit den Parametern
	 * beginIndex=1 und endIndex=4 re - mi - fa und hat die L�nge 3.
	 * 
	 * @param beginIndex
	 *            Der erste Index der ersten enthaltenen Note
	 * @param endIndex
	 *            Der Index der ersten nicht mehr enthaltenen Note
	 * @return Eine neue Melody aus dem spezifizierten Notenbereich
	 */
	public Melody copy(int beginIndex, int endIndex) {
		Melody tmp = new Melody(this.bpm);
		for ( int i = beginIndex; i < endIndex; i++) 
			tmp.addNote(this.alMelodie.get(i));
		return tmp;
	}

	/**
	 * verh�lt sich wie public Melody copy(int beginIndex, int endIndex),
	 * erwartet jedoch nur den Parameter beginIndex und gibt eine neue Melodie
	 * bestehend aus den Noten von inklusive beginIndex bis zum Ende der Melodie
	 * zur�ck.
	 * 
	 * @param beginIndex
	 *            Der erste Index der ersten enthaltenen Note
	 * @return Eine neue Melody aus dem spezifizierten Notenbereich
	 */
	public Melody copy(int beginIndex) {
		return copy(beginIndex,this.alMelodie.size());
	}

	/**
	 * setzt das Tempo der Melodie auf den �bergebenen Wert (bpm, Schlage pro
	 * Minute).
	 * 
	 * @param bpm
	 *            Das neue Tempo in Schl�gen pro Minuten
	 */
	public void setBPM(int bpm) {
		this.bpm = bpm;
	}

	/**
	 * transponiert alle Noten der Melodie um den gleichen Wert nach oben oder
	 * nach unten. Besteht die Melodie beispielsweise aus den Noten do - mi -
	 * re, so lauten diese nach Aufruf der Methode mit steps=3 fa - la - sol.
	 * Dabei liegt ein zyklischer Abschluss vor: Die sieben Noten lauten do - re
	 * - mi - fa - sol - la - si. Auf die letzte Note si folgt wieder do.
	 * 
	 * @param steps
	 *            Um wieviele Schritte transponiert werden soll
	 */
	public void transpose(int steps) {
		for ( Note n : this.alMelodie )
			n.transpose(steps);
	}

	/**
	 * gibt die T�ne der Melodie in der Form Notenname gefolgt von einem
	 * Leerzeichen und der Notenl�nge (in Schl�ge pro Minute) zur�ck. Zwischen
	 * zwei Noten steht jeweils ein Leerzeichen, alle Noten stehen in der
	 * gleichen Zeile. In einer neuen Zeile wird die Dauer der Melodie in
	 * Sekunden ausgegeben. Ist die gespeicherte Melodie beispielsweise do 1 re
	 * 1 mi 2 fa 4, ist die Gesamtdauer 8 Schl�ge. Ist das Tempo der Melodie 80
	 * Schl�ge pro Minute, so betr�gt die L�nge 6 Sekunden.
	 * 
	 * do 1 re 1 mi 2 fa 4
	 * 6.0 seconds
	 * 
	 * @return Eine lesbare Repr�sentation dieser Melody
	 */
	public String toString() {
		String tmp = "";
		int length = 0;
		for ( Note n : this.alMelodie ) {
			tmp += n.toString()+" ";
			length += n.getBeats();
		}
		return tmp +"\n"+(double)length/this.bpm*60 + " seconds";
		
	}

}
