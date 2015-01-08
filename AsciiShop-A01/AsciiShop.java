import java.util.Scanner;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * Mnr: 1328924
 *
 * Einlesen eines AsciiBildes und dies auf Korrektheit ueberpruefen.
 * Zeilen muessen gleich lang sein. Leange und Hoehe sind nicht beschraenkt
 *
 */
public class AsciiShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Init der benoetigten Variablen
        Scanner sc = new Scanner(System.in);
        String line = new String();
        String msg = new String("INPUT MISMATCH"); //Ausgabe mit Fehler setztn
        int width = 0;
        int height = 0;
        boolean errorOccured = false;

        while (sc.hasNext()) { //solange noch zeilen vorhanden sind
            line = sc.next(); //zeile einlesen

            if (height == 0) { //height == 0: erste Zeile und gibt somit die Zeichenlaenge vor
                width = line.length();
            } else if (width != line.length()) { //sobald die breite nicht mehr stimmt wird abgebrochen
                errorOccured = true;
                break;
            }

            height++; //Bildhoehe um 1 erhoehen
        }

        //Entscheiden was ausgegeben wird
        if (!errorOccured) {
            msg = width +  " " + height; //b h als Ausgabe
        }
        System.out.println(msg); //Finale Ausgabe
    }

}