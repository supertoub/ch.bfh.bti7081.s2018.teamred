
# Leserschaft

Dieses Dokument richtet sich an die Kunden des Team Red, Kurs Software Engeneering and Design Fr\"{u}hlingssemester 2018. Es dient als Grundbeschreibung der Applikation welche durch das Team entwickelt wird.


## Version

| Versionsnummer | Author | Beschreibung |
| ------------- |:-------------:| -----:|
| 1.0 | Roccaro | Grundfassung, Bassierend auf Design Thinking |


### Versionsbegr\"{u}ndungen

| Versionsnummer | Author | Beschreibung |
| ------------- |:-------------:| -----:|
| 1.0 | Roccaro | Grundfassung des Spezifikationsdokuments, Fassung zur Ansicht der Spezifikation durch Kunden. |



### Versions\"{a}nderungen

| Versionsnummer | Author | Beschreibung |
| ------------- |:-------------:| -----:|
| 1.0 | Roccaro | Grundfassung des Spezifikationsdokuments, Fassung zur Ansicht der Spezifikation durch Kunden. |



# Einleitung

Das System wird ben\"{o}tigt im Umgang mit Angstst\"{o}rungen bzw. Sozialen \gls{Phobien}. Aktuell existieren keine L\"{o}sungen f\"{u}r Patienten in ambulanter Behandlung die an Angstst\"{o}rungen leiden. Unsere Applikation wird den Patienten bei der Genesung unterst\"{u}tzen und im mehr Lebensqualit\"{a}t geben. Auch soll es dem Patienten erm\"{o}glichen durch weniger Angst wieder ein produktives Mitglied der Gesellschaft zu werden.

## Kurzbeschreibung der Funktionen des Systems

Unsere Applikation bietet \"{u}ber \gls{Gameification} einen Anreiz sich jeden Tag schrittweise an ein Ziel anzun\"{a}hern. Die Applikation bietet die M\"{o}glichkeit, das der Patient zusammen mit dem Therapeuten \gls{Challenges} erstellt. Diese \gls{Challenges} sind Aufgaben welche der Patient anschliessend gestellt bekommt. Nach der Ausf\"{u}hrung einer Challenge wird der Patient nach einer Beschreibung des Erlebnisses gefragt. Diese Bechreibungen sind f\"{u}r den Therapeuten zug\"{a}nglich, sp\"{a}ter w\"{a}hrend den Therapiesitzungen k\"{o}nnen sie besprochen werden.

## Wie wird es mit anderen Systemen zusammen arbeiten

Die Applikation wird selbst laufen bzw. keinen Zugang zu anderen Systemen ben\"{o}tigen. Es m\"{u}ssen keine Schnittstellen zu anderen Systemen f\"{u}r den Datenabgleich vorgesehen werden. 
Die Applikation komuniziert nicht mit anderen Systemen. Die Verbindungen welche projektiert werden, sind Emails oder Push Nachrichten an den Therapeuten, welche von unserer Applikation ausgel\"{o}st werden.


# \"{U}bersicht der System Architektur

Die Applikation wird als Webapplikation mit \gls{Vaadin} umgesetzt. Dabei wird ein hoher Wert auf die Simplizit\"{a}t auf Clientseite gesetzt. S\"{a}mtliche Daten werden auf dem Webserver abgelegt bzw. dessen verbundenen Datenbank. Auf der Clientsite werden keine Installationen durchgef\"{u}hrt.

Alle Daten werden ausschliesslich von der Applikation verwendet und nicht Drittanbietern zur Verf\"{u}gung gestellt. Die Applikation geht mit den Personendaten voll \gls{GDPR compliant} um.

Der Server selbst wird in der Cloud positioniert, die Backups und Absicherung gegen Angriffe werden durch den Hoster des Servers durchgef\"{u}hrt.
