# Scrum backlog
## Project team
Name | GitHub Alias | Function
--- | --- | --- 
Thomas Baumann | lopof | Developer
Frédéric Lehmann | frediLehmann | Developer
Severin Thalmann | manfred00 | Developer
Ismael Riedo | riedoi | Developer
Fridolin Zurlinden | ifrido | Developer
Roland Roccaro | MehrLinard | Developer
Tobias Weissert | supertoub | Developer/ Scrummaster
Jürgen Vogel, | | Product Owner

## Product Backlog
ID | Storyname | Description | Priority | Effort plan original | Effort plan updated | Effort acutal | Status
--- | --- | --- | --- | --- | --- | --- | ---
 1 | Challenge Board | Als Patient möchte ich auf einer Seite eine Übersicht aller Challenges mit ihrer Beschreibung, ihrem Status und den verfügbaren Levels sehen, so dass er sich einen Überblick über alle seine Challenges machen kann. | High | 63 | - | - | Done
 2 | Challenges verwalten | Als Patient möchte ich Möglichkeit haben neue Challenges für sich zu erfassen, bestehende Challenges zu bearbeiten oder abzuschliessen und zu bewerten, sodass der Patient lernt sich seinen Ängsten zu stellen . | High | 80  | - | - | Open
 3 | Journal | Als Patient möchte ich die Möglichkeit haben einen Journaleintrag zu einem Erlebnis oder einer Challenge zu erfassen, damit er seinen aktuellen Heilungsprozess dokumentieren kann. | Medium | 10 | - | - | Open
 4 | Statistik | Als Arzt möchte ich die Möglichkeit haben eine Auswertung aller abgeschlossenen Challenges eines Patienten darzustellen, sodass er den aktuellen Fortschritt eines Patienten besser bewerten kann. | Low | 57 | - | - | Open

## Backlog Sprint 1
ID | Name | Description | Components | Owner | Reviewer | Priority | Effort plan original | Effort plan updated | Effort actual | Status
--- | --- | --- | --- | --- | --- | --- | --- | --- | --- | ---
1.1 | Projektsetup |  Projektsetup so wie erstellen des globalen CSS.| | TWE | FLE | High | 3 | - | 3 | Done
1.2 | Package und Klassen setup | Packages und Klassen gemäss UML erstellen. | | FLE | TWE | High | 3 | - | 3 | Done
1.3 | Farbschema CSS |  | | TWE | RRO | Low | 3 | - | 3 | Done
1.4 | Font/Icon Schema |  | | TWE | RRO | Low | 3 | - | 3 | Done
1.5 | Level Layout | Das Layout für die Level übersicht erstellen. | <ul><li>Challengebaord</li></ul> | FLE | TWE | High | 3 | - | 2 | Done
1.6 | Level List | Levels erstellen und auf dem Level Layout darstellen. | <ul><li>Challengebaord</li></ul> | FLE | IRI | High | 3 | - | 2 | Done
1.7 | Level Details | Die Levels werden mit den Challenges verknüpft, damit man wenn man auf ein Level klickt die jeweiligen Challenges ersichtlich werden. | <ul><li>Challengebaord</li></ul> | IRI | FLE | High | 3 | - | 3 | Done
1.8 | Minimale Funktionalität für die Level | Damit man weiss welches Level aktiv und passiv ist, werden sie anhand des Attributes entsprechend angezeigt.  | <ul><li>Challengebaord</li></ul> | IRI | FLE | High | 3 | - | 3 | Done
1.9 | Challenge Layout (Aktiv/Abgeschlossen) | Die Challanges werden an der richtigen Ort platziert anhand ihres Status (Aktiv/Abgeschlossen). | <ul><li>Challengeboard</li><li>Challengdetail</li></ul> | IRI | FZU | High | 3 | - | 3 | Done
1.10 | Loginseite Layout | Hinzufügen der Funktionalität, Passwortprüfung, Fehlermeldungen, Weitergabe eines Loginobjekts an Startseite | <ul><li>Loginview</li></ul> | RRO | STH | Low | 3 | - | 3 | Done
1.11 | Challenge Aktiv | Die aktive Challenge wird grün angezeigt. Funktionalität bei klick auf Challenge. | <ul><li>Challengeboard</li><li>Challengdetail</li></ul> | TBA | STH | High | 3 | - | 4 | Done
1.12 | Challenge Abgeschlossen | Die abgeschlossene Challenge wird ausgegraut angezeigt. Funktionalität bei klick auf Challenge. | <ul><li>Challengeboard</li><li>Challengdetail</li></ul> | TBA | STH | High | 3 | - | 4 | Done
1.13 | Funktionalität für Challenges aktivieren/abzuschliessen | Jede aktive Challenge kann mit einem klick als abgeschlossen markiert werden. Damit wird sie von der aktiv Spalte in die Abgeschlossene verschoben. | <ul><li>Challengeboard</li><li>Challengdetail</li></ul> | TBA | STH | High | 3 | - | 3 | Done
1.14 | Startseite Layout | Erstellen der Startview in der, der User auswählen kann ob er auf das Challengeboard oder auf das Journalboard springen möchte. | <ul><li>Startview</li></ul> | STH | RRO | Medium | 3 | - | 3 | Done
1.15 | Funktionalität Startseite (Butons/Links) | Bei Klick auf Challenge wird die Challengeboardview angezeigt. Welcome Message mit dem Namen des Users. | <ul><li>Startview</li></ul> | STH | RRO | Medium | 3 | - | 2 | Open
1.16 | Loginseite Layout |  | <ul><li>Loginview</li></ul> | RRO | STH | Low | 3 | - | 3 | Done
1.17 | Maven Infrastructure Setup | Die Infrastrukturkomponenten (Datenbank und Applikationsserver) sollen mit Hilfe von Maven automatisiert gestartet werden um so das Testen und Demonstrieren der Entwickelten einfacher zu machen. | | FZU | TWE | High | 3 | - | 3 | Done
1.18 | Database Setup | Evaluieren und vorbereiten einer Lösung für einen Datenbankserver und die Einbindung in die Entwicklungsumgebung. Die Datenbank soll beim starten mit Beispielwerten befüllt werden, so dass die Entwickler die Anbindung testen können. | | FZU | IRI | High | 3 | - | 5 | Done
1.19 | App-Server Setup | Evaluieren und vorbereiten einer Lösung für einen Applikationsserver und die Einbindung in die Entwicklungsumgebung. | | FZU | IRI | High | 3 | - | 4 | Done
1.20 | Reserve |  |  |  |  |  | 6 | - | 0 | Open

## Retro Sprint 1
### Positiv
- Sprint Goal erreicht

### Negativ
- merge Chaos
- keine Zeiten erfasst
- Vaadin Lernkurve sehr flach

### Actions
- Master ist Master, jeder arbeitet auf seinem eigenen Branch
- Codereview seriös machen, nicht einfach Pull Request akzeptieren (Code auschecken, testen)
- Zeiten erfassen für Burndown

## Backlog Sprint 2
ID | Name | Description | Components | Owner | Reviewer | Priority | Effort plan original | Effort plan updated | Effort actual | Status
--- | --- | --- | --- | --- | --- | --- | --- | --- | --- | ---
2.1 | Login prüfen auf DB | Als Benutzer möchte ich, dass ich mich mit meinem Passwort (aus der DB) einloggen kann, sodass nur ich und mein Therapeuten Zugriff auf meine Daten hat. | <ul><li>LoginView</li></ul> | RRO | IRI | High| 8h | - | 11.5h | open
2.2 | Challange erstellen | Als Patient möchte ich, eine neue Challenge erstellen, sodass ich die mit meinem Therapeuten vereinbarten Challanges tracken kann. | <ul><li>Challengeboard</li></ul> | IRI | TBA | high | 8h | - | 10h | done
2.3 | Challange in der DB persistieren | Als Patient möchte ich, dass die Challange auf der DB persistiert wird, sodass meine Challanges auch nach eines reboots des Servers noch da sind. | <ul><li>Challengeboard</li></ul> | FZU | TBA | High | 4h | - | | open
2.4 | Level in DB persistieren | Als Patient möchte ich, dass die Levels auf der DB persistiert wird, sodass meine Levels auch nach eines reboots des Servers noch da sind. | <ul><li>Challengeboard</li></ul> | FZU | TBA | High | 4h | - | | open
2.5 | Testuser anlegen | mehrere Testuser auf der Datenbank anlegen | | FZU | STH | High | 4h | - | 4h | done
2.6 | Challengedetail anzeigen | Als Patient kann ich beim klick auf eine Challange die Details jeder Challange sehen. | <ul><li>Challengeboard</li></ul> | TBA | FZU | High | 4h |  | 8h | done
2.7 | Challenge bearbeiten | Als Patient möchte ich eine Challenge bearbeiten können, sodass ich nach dem erreichen einer Challenge bewerten kann, wie ich mich dabeu gefühlt habe. | <ul><li>Challengeboard</li></ul> | TBA | FZU | High | 4h | - | | open
2.8 | Level erstellen | Als Patient möchte ich ein neues Level erstellen können, welches auch auf der Datenbank gesichert wird. | <ul><li>Levelboard</li></ul> | FLE | STH | High | 2h | - | 2.gh | done
2.9 | Level Status anzeigen | Auf dem Level möchte ich sehen, wie viele Challanges ich schon erledigt habe und wie viele noch offen sind. | <ul><li>Levelboard</li></ul> | FLE | TWE | High | 2h | - | 3h | done
2.10 | Level als gesperrt anzeigen | Wenn ich in einem Level weniger als 80% der Challanges erfüllt habe, sind alle zukünftigen Levels mit einem Schloss gesperrt. Bei einem Klick auf ein Level kann ich dieses zwar ansehen aber keine Challanges erledigen.  | <ul><li>Levelboard</li></ul> | FLE | TWE | High | 2h | - | 3h | done
2.11 | Startscreen Name einfügen | Auf der Startseite solle der Patient mit seinem Namen begrüsst werden. Der aktuell angemeldete Benutzer soll ich Header angezeigt werden. | <ul><li>Startview</li><li>Headerview</li></ul> | STH | RRO | High | 4h | - | 4h | done
2.12 | Startscreen aufräumen | Die Startseite soll über den Designer gemacht werden, dass sie besser gestylet werden kann und aufgeräumter aussieht. | <ul><li>Startview</li></ul> | STH | RRO | High | 4h | - | 2.5h | done
2.13 | Journal vorbereiten | Vorbereiten des Journals für Sprint 3 | <ul><li>Journalview</li></ul> | STH | TWE | High | 4h | - | 3h | done
2.14 | Seiten aufbau über den Designer machen | Als Entwickler möchte ich, dass die Views im Designer aufgebaut werden um diese einfacher anzupassen | <ul><li>Journalview</li></ul> | FLE | TWE | High | 3h | - | 3h | done
2.15 | Styling | Als Benutzer soll das ganze Projekt optisch ansprechend sein. | <ul><li>Journalview</li></ul> | TWE | IRI | High | 4h | - | 6h | done
Task 1 | Projekt aufräumen | | | FLE | IRI | High | 2h | - | 2h | done
Task 2 | Backlog Sprint 2 erstellen | | | TWE | IRI | High | 1h | - | 1h | done

## Retro Sprint 2
### Positiv
- Sprint Goal erreicht
- Merge funktioniert besser
- Zeiten wurden besser erfasst

### Negativ
- Wenig Kommentare

## Backlog Sprint 3
ID | Name | Description | Components | Owner | Reviewer | Priority | Effort plan original | Effort plan updated | Effort actual | Status
--- | --- | --- | --- | --- | --- | --- | --- | --- | --- | ---
3.1 | Journal Eintrag erstellen | Als Patient möchte ich einen neuen Journaleintrag erstellen können, so dass ich dokumentieren kann wie es mir heute ergangen ist. | <ul><li>JournalView</li></ul> | STH |  | High| 4h | - | 4h | done
3.2 | Persistenz: Challange | Die Challanges soll auf der Datenbank persistiert werden. |  | FZU |  | high | 4h | - | 4h | done
3.3 | Persistenz: User | Der User soll aus der Datanbank gelesen werden. | | RRO | TWE | High | 2h | - | 2h | done
3.4 | Persistenz: Journal | Die einzelnen Journaleinträge sollen auf der Datenbank persistiert werden. |  | FZU |  | High | 4h | - | 4h | done
3.5 | Journal darstellen | Die aus der Datenbank gelesenen Journaleiträge sollen übersichtlich dargestellt werden. | <ul><li>JournalView</li></ul> | STH | | High | 4h | - | 4h | done
3.6 | Challange bearbeiten | Als Patient möchte ich eine Challange bearbeiten können | <ul><li>Challengeboard</li></ul> | TBA |  | High | 4h |  | 4h | done
3.7 | Darstellung Challange | Überarbeiten der Darstellung der Challanges | <ul><li>Challengeboard</li></ul> | TWE |  | High | 4h | - | 4h | done
3.8 | Darstellung Journal | Journals sollen optisch ansprechend dargestellt werden | <ul><li>Journalview</li></ul> | TWE |  | High | 4h | - | 4h | done
3.9 | Darstellung Challange Detail | Das Challange Detail soll optisch ansprechender aussehen. | <ul><li>Challangeboard</li></ul> | TWE |  | High | 4h | - | 4h | done
3.10 | Login DB Integration | Als Benutzer möchte ich, dass ich mich mit meinem Passwort (aus der DB) einloggen kann, sodass nur ich und mein Therapeuten Zugriff auf meine Daten hat. | <ul><li>Loginview</li></ul> | RRO |  | High | 4h | - | 4h | done
3.11 | Journaleintrag bearbeiten | Ein Journaleintrag soll bearbeitet werden können, so dass ich Dinge korrigieren oder ergänzen kann | <ul><li>Journalview</li></ul> | STH |  | High | 4h | 6h | 4h | open
3.12 | Journaleintrag löschen | Als Patient möchte ich einen Journaleintrag löschen können, falls ich diesen versehentlich angelegt habe. | <ul><li>Journalview</li></ul> | STH |  | Low | 2h | 4h | 2h | open
3.13 | Tests aufsetzten | Als Entwickler möchte ich eine Unittest Abdeckung von min. 60%, so dass zukünftige Entwicklungen den Aktuellen stand nicht beeinträchtigen|  | FLE |  | High | 8h | - | 8h | done
3.14 | Logger integrieren | Als Entwickler möchte ich, dass die Applikation wichtige Erreignisse logged, so dass ich im Fehlerfall ein Log zur Fehleranalyse habe. |  | FZU | TWE | Low | 4h | - | 4h | done
3.15 | Bug Fix Details | Fix Nullpointer Bug auf der Challangeview. | <ul><li>Challangeview</li></ul> | TBA |  | Hight | 2h | - | 2h | done
Task 1 | Backlog Sprint 3 erstellen | | | TWE |  | High | 1h | - | 1h | done

## Final Retro
### Positiv
- Anwendung soweit fertig, dass sie brauchbar ist.

### Negativ
- Kommentare fehlen noch an einigen stellen.
- Tests noch nicht ausgereift.
- Persistenz zu spät implementiert.

### Known issues
- Anwendung nicht Multiuser fähig.
- Sprache nicht konsistent.
- Arzt nicht implementiert.
- Lizenz nicht definiert.

