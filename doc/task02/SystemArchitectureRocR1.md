 


#Leserschaft
Dieses Dokument richtet sich an die Kunden des Team Red, Kurs Software Engeneering and Design Frühlingssemester 2018.  Es dient als Grundbeschreibung der Applikation welche durch das Team entwickelt wird.


##Version
| Versionsnummer        |   Author         | Beschreibung  |
| ------------- |:-------------:| -----:|
| 1.0     | Roccaro | Grundfassung, Bassierend auf Design Thinking |

##Versionsbegründungen 
| Versionsnummer        |   Author         | Beschreibung  |
| ------------- |:-------------:| -----:|
| 1.0     | Roccaro | Grundfassung des Spezifikationsdokuments, Fassung zur Ansicht der Spezifikation durch Kunden. |

##Versionsänderungszusammenfassung:
| Versionsnummer        |   Author         | Beschreibung  |
| ------------- |:-------------:| -----:|
| 1.0     | Roccaro | Grundfassung des Spezifikationsdokuments, Fassung zur Ansicht der Spezifikation durch Kunden. |

#Einleitung
Das System wird benötigt im Umgang mit Angststörungen bzw. Sozialen Phobien((Glossar)). Aktuell existieren keine Lösungen für Patienten in ambulanter behandlung die an Angststörungen leiden. Unsere Applikation wird den Patienten bei der Genesung unterstützen und im mehr Lebensqualität geben. Auch soll es dem Patienten ermöglichen durch weniger Angst wieder ein produktives Mitglied der Gesellschaft zu werden.
Kurzbeschr. Der Funktionen des Systems.
Unsere Applikation bietet über Gameification einen Anreiz sich jeden Tag schrittweise an ein Ziel anzunähern. Die Applikation bietet die Möglichkeit, das der Patient zusammen mit dem Terapeuten sogenannte «Challenges» erstellt. Diese Challenges sind Aufgaben welche der Patient anschliessend gestellt bekommt. Nach der Ausführung einer Challenge wird der Patient nach einer Beschreibung des Erlebnisses gefragt. Diese Bechreibungen sind für den Terapeuten zugänglich, später während den Terapiesitzungen können Sie besprochen werden.

Wie wird es mit anderen Systemen zusammen arbeiten
Wie passt die Applikation in das übergreifende Business und die Strategischen Ziele der Organisation welche die Softwre ordert
Die Applikation wird im wesentlichen selbst laufen bzw. keinen Zugang zu anderen Systemen benötigen. Es müssen keine Schnittstellen zu anderen Systemen für den Datenabgleich vorgesehen werden. Die Verbindungen welche projektiert werden, sind Emails oder Push Nachrichten an den Terapeuten welche jedoch von unserer Applikation ausgelöst werden.

#Übersicht der System Architektur

Die Applikation wird als Webapplikation mit Vaadin umgesetzt. Dabei wird ein hoher Wert auf die Simplizität auf Clientseite gesetzt. Sämtliche Daten werden auf dem Webserver abgelegt bzw. dessen verbundenen Datenbank. Auf der Clientsite werden keine Installationen durchgeführt.
Alle Daten werden ausschliesslich von der Applikation verwendet und nicht Drittanbietern zur Verfügung gestellt. Die Applikation geht mit den Personendaten voll GDPR compliant((Glossar)) um.
Der Server selbst wird in der Cloud positioniert und abgesichert.
