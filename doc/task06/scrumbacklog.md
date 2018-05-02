# Scrum backlog
## Project team
Name | GitHub Alias
--- | ---
Thomas Baumann| lopof
Frédéric Lehmann | frediLehmann
Severin Thalmann | manfred00
Ismael Riedo | riedoi
Fridolin Zurlinden | ifrido
Roland Roccaro | MehrLinard
Tobias Weissert | supertoub

## Product Backlog
ID | Storyname | Description | Priority | Effort plan original | Effort plan updated | Effort acutal | Status
--- | --- | --- | --- | --- | --- | --- | ---
 1 | Challenge Board | Als Patient möchte ich auf einer Seite eine Übersicht aller Challenges mit ihrer Beschreibung, ihrem Status und den verfügbaren Levels sehen, so dass er sich einen Überblick über alle seine Challenges machen kann. | High | 63 | - | - | Open
 2 | Journal | Als Patient möchte ich die Möglichkeit haben einen Journaleintrag zu einem Erlebnis oder einer Challenge zu erfassen, damit er seinen aktuellen Heilungsprozess dokumentieren kann. | Medium | 80 | - | - | Open
 3 | Statistik | Als Arzt möchte ich die Möglichkeit haben eine Auswertung aller abgeschlossenen Challenges eines Patienten darzustellen, sodass er den aktuellen Fortschritt eines Patienten besser bewerten kann. | Low | 10 | - | - | Open
 4 | Challenges verwalten | Als Patient möchte ich Möglichkeit haben neue Challenges für sich zu erfassen, bestehende Challenges zu bearbeiten oder abzuschliessen und zu bewerten, sodass der Patient lernt sich seinen Ängsten zu stellen . | High | 57  | - | - | Open
## Sprint Backlog
ID | Sprint | Name | Description | Components | Owner | Reviewer | Priority | Effort plan original | Effort plan updated | Effort actual | Status
--- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | ---
 1.1 | 1 | UI Grundgerüst |  Projektsetup so wie erstellen des globalen CSS.| | TWE | FLE | Medium | 13 | - | - | Open
 1.2 | 1 | Übersicht aller Levels | Implementieren der Levelsidebar. Darstellen aller Levels, noch nicht freigegebene Levels sind ausgegraut und mit einem Schloss markiert. | <ul><li>Challengebaord</li></ul> | FLE | IRI/TBA | High | 13 | - | - | Open
 1.3 | 1 | Darstellen aller Challenges eines Levels | Beim Klick auf ein Level, welches der Patient öffnen darf wird auf der rechten Seite alle Challenges angezeigt. Die Ansicht ist in 2 Spalten aufgeteilt. Links sind die noch zu erledigenden Challenges dargestelllt. Auf der rechten Seite sind die abgeschlossenen Challenges dargestellt. Beim klick auf eine Challange wird rechts eine zusätzliche spalte angezeigt auf der die Detailsicht der Challenges dargestellt werden.<br/><br/>Abgrenzung: Detailview wird zu einem späteren Zeitpunkt umgesetzt. | <ul><li>Challengeboard</li><li>Challengdetail</li></ul> | IRI/TBA | FZU | High | 14 | - | - | Open
 1.4 | 1 | Startseite | Erstellen der Startview in der, der User auswählen kann ob er auf das Challengeboard oder auf das Journalboard springen möchte. Bei Klick auf Challenge wird die Challengeboardview angezeigt| <ul><li>Startview</li></ul> | STH | RRO | Medium | 7 | - | - | Open
 1.5 | 1 | Loginseite | Erstellen der Loginview. Auf der Loginseite gibt es 2 Eingabefelder für Benutzername (E-Mail) und Passwort und ein Button mit der Aufschrift anmelden. Beim klick auf diesen Button wird geprüft ob der Benutzer das entsprechende richtige Paswort eingegeben hat. Falls nicht, erscheint eine Meldung, dass das Passwort nicht stimmt. Bei richtigem Passwort wird der User auf die Startseite weiter geleitet. | <ul><li>Loginview</li></ul> | RRO | STH | Low | 7 | - | - | Open
 1.6 | 1 | Infrastruktur | Evaluieren Development Datenbank (z.B. MariaDB, HSQL, SQLlite...) installation mittels Maven, sodass diese im gleichen .jar ausgeliefert werden kann wie der Webserver.| | FZU | TWE | High | 9 | - | - | Open

## Burndown Chart
Sprint | Time of record | Remaining effort | Remaining resources
--- | --- | --- | ---
    |     |     |
    |     |     |
    |     |     |
    |     |     |
    |     |     |
