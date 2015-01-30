/**
 * Diese Klasse repr�sentiert eine Note. Eine Note ist der kleinste Bestandteil
 * einer Melodie und ist charakterisiert durch H�he und L�nge. Die Notenl�nge
 * wird in Schl�gen angegeben. Es gibt insgesamt 7 Noten. In aufsteigender
 * Reihenfolge: do - re - mi - fa - sol - la - si. Die Notennamen haben
 * numerische Entsprechungen.
 * 
 * do re mi fa sol la si 
 *  0  1  2  3   4  5  6
 * 
 * Speichern Sie die Notennamen in einer geeigneten Datenstruktur und stellen
 * Sie sicher, dass Sie �ber den numerischen Index auf den Notennamen zugreifen
 * k�nnen. Die Namen sollen nicht ver�nderlich sein und sind au�erdem f�r alle
 * Instanzen der Klasse Note gleich: W�hlen Sie geeignete Modifier, um diese
 * zwei Forderungen zu erf�llen.
 */
public class Note {
	static final String[] namen = { "do", "re", "mi", "fa", "sol", "la", "si" } ;
	private int index;
	private int beats;
	/**
	 * erzeugt eine neue Instanz von Note. beats gibt die L�nge der Note an. Die
	 * H�he der Note wird als numerischer Wert angegeben (noteIndex). Speichern
	 * Sie den Notennamen nicht als String, sondern behalten Sie ihn als
	 * numerischen Wert.
	 * 
	 * @param noteIndex
	 *            Der Index des Notennamens
	 * @param beats
	 *            Die Dauer der Note in Schl�gen
	 */
	public Note(int noteIndex, int beats) {
		this.index = noteIndex;
		this.beats = beats;
	}

	/**
	 * ist ein Kopierkonstruktor und gibt eine Kopie der �bergebene Instanz von
	 * Note zur�ck.
	 * 
	 * @param note
	 *            Die zu kopierende Note
	 */
	public Note(Note note) {
		this(note.index, note.beats);
	}

	/**
	 * gibt die Notenl�nge in Schl�gen zur�ck.
	 * 
	 * @return Die Dauer dieser Note in Schl�gen
	 */
	public int getBeats() {
		return this.beats; 
	}

	/**
	 * transponiert die Note um den angegebenen Wert nach oben oder nach unten.
	 * Ist die gespeicherte Note beispielsweise do, so lauten diese nach Aufruf
	 * der Methode mit steps=3 fa. Dabei liegt ein zyklischer Abschluss vor: Die
	 * sieben Noten lauten do - re - mi - fa - sol - la - si. Auf die letzte
	 * Note si folgt wieder do.
	 * 
	 * @param steps
	 *            Um wieviele Schritte transponiert werden soll
	 */
	public void transpose(int steps) {
		this.index += steps;
		if ( this.index > 6 ) 
			this.index -= 7;
		if ( this.index < 0 ) 
			this.index += 7;
		
		//this.index = (this.index % 7)	;	
	}

	/**
	 * gibt den Namen der Note gefolgt von einem Leerzeichen und deren L�nge in
	 * Schl�gen zur�ck.
	 * 
	 * do 1
	 * 
	 * @return Eine lesbare Repr�sentation dieser Note
	 */
	public String toString() {
		return Note.namen[this.index] + " " + getBeats();
	}

}
