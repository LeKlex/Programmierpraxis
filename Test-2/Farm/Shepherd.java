import java.util.Scanner;

public class Shepherd {

    /**
     * Test-Methode. 
     * 
     * Testen Sie in dieser Methode die Implementierung 
     * Ihres Programmes durch Objekt-Instanzierungen und 
     * Methodenaufrufe. Geben Sie Ausgaben (Rückgaben von 
     * Methoden, etc.) auf System.out aus.
     * 
     * Erstellen Sie zuletzt einen sinnvollen Testfall und 
     * beschreiben Sie kurz in einem Kommentar, wieso Sie 
     * diesen Testfall gewählt haben und was Sie damit 
     * überprüfen. Für einen sinnvollen und gut kommentierten 
     * Testfall können Sie einen zusätzlichen Punkt bekommen, 
     * der einen an einer anderen Stelle verlorenen Punkt 
     * ausgleicht (insgesamt können Sie jedoch nicht mehr 
     * als 30 Punkte erreichen). 
     * 
     * (1 Zusatzpunkt)
     * 
     * Rufen Sie Ihre Anwendung mit 
     * java Shepherd
     * auf, um diese Methode auszuführen. 
     */
    public static void testing() {

	
		System.out.println("To be implemented!");
	
	
    }
	    
    /**
     * Sammelt verschiedene Testfälle.
     * 
     * Die Methode beinhaltet verschiedene Testfälle, 
     * mit denen Sie die Funktionalität Ihres Programmes
     * testen können.  
     * 
     * Rufen Sie Ihre Anwendung mit 
     * java Shepherd [number]
     * auf, wobei [number] die Nummer des Testfalls angibt.
     * 
     * VERÄNDERN SIE DIESE METHODE NICHT! 
     * 
     * Nutzen Sie für eigene Tests die Methode
     * testing() am Beginn dieser Datei. 
     * 
     * @param testCaseNumber Die Nummer des auszuführenden Testfalls.  
     */
    public static void testCases(int testCaseNumber) {

		switch (testCaseNumber) {
		case 1:
	
		    /*
		     * spec.$1
		     * Überprüft die korrekte Basisimplementierung der Klasse Sheep.
		     * 
		     * ERWARTETER OUTPUT:
		     * #1: white, woolPerMonth=2.2
		     * white
		     * #2: brown, woolPerMonth=1.8
		     */
	
			{
			    
				Sheep s1 = new Sheep("white", 2.2);
				Sheep s2 = new Sheep("brown", 1.8);
				System.out.println(s1);
				System.out.println(s1.getColor());
				System.out.println(s2);
				
			}
	
		    break;
	
		case 2:
	
		    /*
		     * spec.$2
		     * Überprüft die korrekte Basisimplementierung der Klasse Range.
		     * 
		     * ERWARTETER OUTPUT:
		     * #1: white, woolPerMonth=2.2
		     * #2: brown, woolPerMonth=1.8
		     * 2
		     */
	
			{
		
				Range r1 = new Range();
				r1.addSheep(new Sheep("white", 2.2));
				r1.addSheep(new Sheep("brown", 1.8));
				System.out.println(r1);
				System.out.println(r1.countSheep());
				
			}
	
		    break;
		    
		case 3:
	
		    /*
		     * spec.$3
		     * Überprüft die korrekte Umsetzung des Kopierkonstruktors 
		     * der Klasse Sheep.
		     * 
		     * ERWARTETER OUTPUT:
		     * #1: brown, woolPerMonth=3.0
		     * #2: brown, woolPerMonth=2.7
		     */
	
			{
			
				Sheep s1 = new Sheep("brown", 3.0);
				Sheep dolly = new Sheep(s1);
				System.out.println(s1);
				System.out.println(dolly);
	
			}
	
		    break;
		    
		case 4:
	
		    /*
		     * spec.$4
		     * Überprüft die korrekte Umsetzung der 
		     * Methode Range#moveSheep und Range#sellSheep.
		     * 
		     * ERWARTETER OUTPUT:
		     * #2: white, woolPerMonth=4.2
		     * 1
		     * #1: black, woolPerMonth=1.8
		     * #3: black, woolPerMonth=1.1
		     * 2
		     * #5: white, woolPerMonth=3.2
		     */
	
			{
				
				Range r1 = new Range();
				r1.addSheep(new Sheep("black", 1.8));
				r1.addSheep(new Sheep("white", 4.2));
				r1.addSheep(new Sheep("black", 1.1));
				
				Range r2 = new Range();
				r1.moveSheep("black", r2);
				System.out.println(r1);
				System.out.println(r1.countSheep());
				System.out.println(r2);
				System.out.println(r2.countSheep());
				
				Range r3 = new Range();
				r3.addSheep(new Sheep("brown", 2.8));
				r3.addSheep(new Sheep("white", 3.2));
				r3.sellSheep("brown");
				System.out.println(r3);
				
			}
	
		    break;
	
		case 5:
	
		    /*
		     * spec.$5
		     * Überprüft die korrekte Implementierung der Klasse Farm.
		     * 
		     * ERWARTETER OUTPUT:
		     * 2.0
		     * 0.5
		     * 0.0
		     */
	
			{
				
				Farm f1 = new Farm(2, 3);
				Range r1 = f1.getRange(0,0);
				r1.addSheep(new Sheep("black", 1.8));
				r1.addSheep(new Sheep("white", 4.2));
				r1.addSheep(new Sheep("black", 1.1));
				r1.addSheep(new Sheep("brown", 2.1));
				r1.addSheep(new Sheep("brown", 1.9));
			
				
				
				Range r3 = f1.getRange(0,2);
				r3.addSheep(new Sheep("brown", 2.8));
				
				System.out.println(f1.averageSheepInRow(0));
				System.out.println(f1.averageSheepInColumn(2));
				System.out.println(f1.averageSheepInColumn(1));
				
			}
	
		    break;
	
		}

    }
    
    /**
     * Ausführbare Methode des Programms.
     * 
     * Die Methode verarbeitet das übergebene Argument
     * (falls vorhanden) und ruft den entsprechenden 
     * Testfall auf. 
     * 
     * VERÄNDERN SIE DIESE METHODE NICHT! 
     * 
     * Nutzen Sie für eigene Tests die Methode
     * testing() am Beginn dieser Datei. 
     * 
     * @param args Das erste Argument gibt, falls 
     * 		vorhanden, die Nummer des Testfalls 
     * 		an, der aufgerufen werden soll.
     */
    public static void main(String[] args) {

		if (args.length>0) {
	
		    Scanner argumentParser = new Scanner(args[0].replaceAll("[\\[\\]]",""));
		    if (argumentParser.hasNextInt()) {
	
				int testCaseNumber=argumentParser.nextInt();
				if (testCaseNumber>=1&&testCaseNumber<=5) {
		
				    testCases(testCaseNumber);
				    return;
		
				}
	
		    }
		    
		    System.err.println("USAGE:");
		    System.err.println("");
		    System.err.println("java Shepherd");
		    System.err.println("Ruft die Methode testing() auf.");
		    System.err.println("");
		    System.err.println("java Shepherd [number]");
		    System.err.println("Ruft den angegebenen Testfall in testCases() auf.");
		    System.err.println("[number]: Eine Zahl zwischen 1 und 5");
	
		} else {
	
		    testing();
	
		}

    }

}
