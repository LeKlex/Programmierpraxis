
import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 * Mnr: 1328924
 *
 * Balkendiagramm zeichnen, Angaben kommen per CLI Eingabe.
 * Eingabe muss gesichert sein und die Laengenbestimmung eingehalten werden.
 *
 */
public class BarPlot {

    /**
     * Maximallaenge fuer den Balken
     */
    public static final Integer barLength = 30;
    public static final Integer labelLength = 8;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String label, line;
        Boolean errorOccured = false;
        Integer inInt = new Integer(0);
        Double inD = new Double(0.0);

        while (sc.hasNext()) { //solange noch zeilen vorhanden sind

            //Label einlesen
            label = BarPlot.drawLabel(sc.next(), BarPlot.labelLength);

            //Wert einlesen
            if (sc.hasNextInt()) {
                inInt = sc.nextInt();
                if (inInt < 0 || inInt > BarPlot.barLength) { //falls die eingegeben laenger > der definierten ist
                    errorOccured = true; break;
                }

                line = BarPlot.drawBar(label, inInt);
            } else if (sc.hasNextDouble()) {
                inD = sc.nextDouble();

                if (inD < 0 || inD > 1.0) { //falls mehr als 100%
                    errorOccured = true; break;
                }

                line = BarPlot.drawBar(label, inD);
            } else { //Wenn wir hier landen stimmt was nicht mit dem Format
                errorOccured = true;
                break;
            }

            System.out.println(line); //Diagramm-Zeile wird ausgegeben

        }

        if (errorOccured) { //Falls ein fehler aufgetreten ist
            System.out.println("INPUT ERROR");
        }
    }

    /**
     * Liefert einen String der Länge n zurück der nur aus dem Zeichen c besteht
     * (beispielsweise liefert repeat('+',4) den String "++++" zurück)
     *
     * @param c
     * @param n
     * @return
     */
    static String repeat(char c, int n) {
        String ret = new String(); //Zu befuellender String
        //n mal durchlaufen
        for (int i = 0; i < n; i++) {
            ret += c; //c dran haengen
        }
        return ret;
    }

    /**
     * Liefert einen String zurück der label beinhaltet aber genau n Zeichen
     * lang ist. Wenn label zu lange ist wird es abgeschnitten, wenn label zu
     * kurz ist, wird der Rückgabewert mit Leerzeichen aufgefüllt.
     * Beispielsweise liefert drawLabel("abc",5) den String "abc " zurück.
     *
     * @param label
     * @param n
     * @return
     */
    static String drawLabel(String label, int n) {
        String correctLabe = new String();
        if (label.length() < n) { //If label is too short
            correctLabe = label + BarPlot.repeat(' ', n - label.length()); //fill with empty string
        } else if (label.length() > n) { //if label too long
            correctLabe = label.substring(0, n); //cut it
        }
        return correctLabe;
    }

    /**
     * Generiert eine Zeile des Balkendiagramms. value bezeichnet dabei die
     * absolute Länge des Balkens.
     *
     * @param label
     * @param value
     * @return
     */
    static String drawBar(String label, int value) {
        //Concat all parts to a line
        return label + "|" + BarPlot.repeat('#', value) + BarPlot.repeat(' ', BarPlot.barLength - value) + "|";
    }

    /**
     * Generiert eine Zeile des Balkendiagramms. value bezeichnet die
     * prozentuelle Länge des Balkens. Wird ein Prozentwert als Balken
     * dargestellt muss eine ganzzahlige Balkenlänge berechnet werden. Diese
     * soll durch Runden zur nächstgelegenen Ganzzahl entstehen.
     *
     * @param label
     * @param value
     * @return
     */
    static String drawBar(String label, double value) {
        //Prozentuellen Anteil ausrechnen, Aufrunden, und an die drawBar(INT) weitergebe damit doppelter code verhindert wird
        return BarPlot.drawBar(label, (int) Math.round(BarPlot.barLength * value));
    }

}
