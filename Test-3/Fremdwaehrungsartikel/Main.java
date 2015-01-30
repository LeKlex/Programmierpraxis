import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // FILL IN: erzeugen Sie eine ArrayList, das folgende Artikel enthält:
        ArrayList<Artikel> artList = new ArrayList<Artikel>();

        // Artikel mit Namen "Mozartkugeln"
        // Preis in Euro: Standardpreis (10 €)
        artList.add(new Artikel("Mozartkugeln"));

        // Artikel mit Namen "Skischuh"
        // Preis in Euro: 250 €
        artList.add(new Artikel("Skischuh", 250));

        // Artikel mit Name "Erdnussbutter"
        // Preis in USD: Standardpreis (umgerechnet 10 €)
        artList.add(new ArtikelDollar("Erdnussbutter"));

        // Artikel mit Namen "Baseball"
        // Preis in USD: 50 $
        artList.add(new ArtikelDollar("Baseball", 50));

        // Artikel mit Namen "Bentobox"
        // Preis in JPY: Standardpreis (umgerechnet 10 €)
        Artikel bento = new ArtikelYen("Bentobox");
        artList.add(bento);

        // Artikel mit Namen "Kimono"
        // Preis in JPY: 40000 Yen
        artList.add(new ArtikelYen("Kimono", 40000));


        // FILL IN: geben Sie in einer Schleife alle Artikel formatiert aus
        for (Artikel a : artList) {
            System.out.println(a.format());
        }

        // FILL IN: setzen Sie den Preis des Artikels Bentobox auf 2000 Yen
        // und geben Sie den Artikel Bentobox formatiert aus
        bento.setPrice(2000);
        System.out.println(bento.format());

        }
    }