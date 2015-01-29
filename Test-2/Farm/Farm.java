import java.util.List;
import java.util.ArrayList;

/**
 * Eine Farm besteht aus einer rechteckigen, regelmäßigen, 
 * zweidimensionalen Anordnung einer bestimmten Anzahl 
 * an Weideflächen. Diese Weideflächen sind über 
 * Koordinaten (column/row) ansprechbar. Die Farm 
 * soll dafür eine rows * columns große Datenstruktur 
 * zum Speichern der Range-Objekte nutzen. Beachten 
 * Sie, dass Sie die gewählte Datenstruktur selber 
 * mit Range Objekten füllen müssen. 
 * 
 * (6 Punkte)
 * 
 */
public class Farm {

	// FILL IN
	
	List<List<Range>> farm;

	/**
	 * Initialisiert diese Farm mit der spezifizierten 
	 * Anzahl an Weideflächen. Die Farm besteht dann 
	 * insgesamt aus rows * columns Weideflächen. 
	 *
	 * @param rows die Höhe der Farm 
	 * @param columns die Breite der Farm 
	 */
	public Farm(int rows, int columns) {

		farm =  new ArrayList<List<Range>>();
		
		for (int r = 0; r < rows; r++) {
			
			List<Range> tmpRow =  new ArrayList<Range>();
			for (int c = 0; c < columns; c++ ) {
				tmpRow.add(new Range());
			}
			farm.add(tmpRow);
			
		}
		
	}

	/**
	 * Gibt die Weidefläche an der entsprechenden Position 
	 * zurück. Sie können davon ausgehen, dass column 
	 * und row nur zulässige Werte haben. 
	 *
	 * @param row die Zeilennummer 
	 * @param column die Spaltennummer 
	 *
	 * @return die Weidefläche an der entsprechenden Position 
	 */
	public Range getRange(int row, int column) {

		// FILL IN
		return farm.get(row).get(column); // REMOVE THIS

	}

	/**
	 * Gibt zurück wieviel Schafe sich im Durchschnitt 
	 * in der angegebenen Reihe befinden. Dies entspricht 
	 * der Summe der Schafe in der Reihe dividiert durch 
	 * die Anzahl an Weideflächen in der Reihe. 
	 *
	 * @param row die Zeilennummer 
	 *
	 * @return die durchschnittliche Anzahl an 
	 * 	Schafen in der angegebenen Reihe 
	 */
	public double averageSheepInRow(int row) {

		int sheepCnt = 0;
		for(Range r : farm.get(row)) {
			sheepCnt += r.countSheep();
		}
		return sheepCnt / (double) farm.get(row).size();
	}

	/**
	 * Gibt zurück wieviel Schafe sich im Durchschnitt 
	 * in der angegebenen Spalte befinden. Dies entspricht 
	 * der Summe der Schafe in der Spalte dividiert 
	 * durch die Anzahl an Weideflächen in der Spalte. 
	 *
	 * @param column die Spaltennummer 
	 *
	 * @return die durchschnittliche Anzahl an 
	 * 	Schafen in der angegebenen Spalte 
	 */
	public double averageSheepInColumn(int column) {

		int sheepCnt = 0;
		
		for (int row = 0; row < farm.size(); row++) {
			sheepCnt += getRange(row, column).countSheep();
		}
		
		return sheepCnt / (double) farm.size();
	}

}