
public class PiTest {

    /**
     * Diese Methode können Sie zum Testen Ihrer Lösung verwenden. Das Programm
     * soll vor und nach der gefragten Änderung folgende Ausgabe erzeugen:
     *
     * Math.PI == 3.141592653589793. WurzelTest.pi(0) == 2.0. WurzelTest.pi(1)
     * == 2.6666666666666665. WurzelTest.pi(5) == 3.0021759545569062.
     * WurzelTest.pi(100) == 3.1337874906281584. WurzelTest.pi(5000) ==
     * 3.141435593589907.
     *
     */
    public static void main(String[] args) {

        System.out.println("Math.PI == " + Math.PI + ".");
        System.out.println("WurzelTest.pi(0) == " + pi(0) + ".");
        System.out.println("WurzelTest.pi(1) == " + pi(1) + ".");
        System.out.println("WurzelTest.pi(5) == " + pi(5) + ".");
        System.out.println("WurzelTest.pi(100) == " + pi(100) + ".");
        System.out.println("WurzelTest.pi(5000) == " + pi(5000) + ".");

    }

    /**
     * Berechnet eine Näherung von PI. Je größer grad ist, desto genauer ist die
     * Näherung.
     *
     * Wandeln Sie die Methode in eine rekursive Methode um, sodass für die
     * Implementierung keine Schleife benutzt wird.
     *
     * @param grad der Grad der Annäherung (grad >= 0).
     * @return Die Näherung von PI zum Grad grad.
     */
    public static double pi(int grad) {

        //CHANGE THIS BLOCK
        double f = 2.0;
        if (grad >= 1) {
            int a = 4 * grad * grad;
            f = pi(grad - 1) * a / (a - 1);
        }
        return f;
    }
}
