# AsciiShop
Angaben laut TOSCA Stand WS2014: https://pp.caa.tuwien.ac.at/tosca


### Autor
Ing. [Alexander Poschenreithner]

Angaben und Testfälle wurden durch die [Fakultät für Informatik] der Technischen Universität Wien bereit gestellt.


### Abgeschlossene Übungsrunden

  - AsciiShop 1
  - AsciiShop 2
  - AsciiShop 3
  - AsciiShop 4
  - AsciiShop 5
  - AsciiShop 6
  - AsciiShop 7
  - AsciiShop 8
  - AsciiShop 9
      - Bonusaufgaben
  - AsciiShop 10
  

### Java Version
1.5


### Tipps für die Entwicklung

Bei Verwendung einer Java-Version >1.5 sollte beim kompilieren folgender Befehl verwendet werden um die Kompatibilität mit der in TOSCA verwendeten Java-Version 1.5 sicher zu stellen:

```sh
$ javac -source 1.5 *.java
```

Zum Ausführen der Programme sollte man auf die TOSCA Einstellungen Rücksicht nehmen:

```sh
$ java -Duser.language=en -Duser.country=US AsciiShop
```

Zur Überprüfung der Ausgaben empfiehlt sich folgendes:

```sh
$ java -Duser.language=en -Duser.country=US AsciiShop < test-case.in > output.txt
$ diff -B -b -c -w test-case.out output.txt
```
[DIFF] liefert eine gute und lesbare Übersicht der Abweichungen vom erwarteten Ergebnis.




### Todo's

 - Kommentare überarbeiten
 - Noch ein paar Bonusaufgaben erledigen
 

License
----

MIT


[Alexander Poschenreithner]:mailto:e1328924@student.tuwien.ac.at
[DIFF]:http://unixhelp.ed.ac.uk/CGI/man-cgi?diff
[Fakultät für Informatik]:http://www.informatik.tuwien.ac.at/