# Use Cases

## Use Case 2

| Bezeichnung | Beschreibung |
| - | - |
| Name | Neuer Journaleintrag |
| Nummer | 2 |
| Kurzbeschreibung | Der Patient erfasst einen neuen Journaleintrag. |
| Beteiligte Akteure | Benutzer |
| Auslöser / Vorbedingung | keine |
| Ergebnisse / Nachbedingung | Der Journal eintrag wird erstellt und ist in der Übersicht der Journaleinträge ersichtlich. Der neue Journaleintrag wird für die Statistik berücksichtigts |

### Ablauf

| Nr. | Wer | Was |
| - | - | - |
| 1.0 | Benutzer | Der Benutzer wählt den Hinzufügen Button. |
| 1.1 | Benutzer | Über die Erstellungsmaske werden die Details für den Journaleintrag eingefügt. Danch wird er gespeichert. |
| 1.2 | System | Überprüfung der eingegebenen Daten. |
| 1.3 | System | Ausnahme Daten nicht I.O. |
| 1.4 | System | Der Eintrag wird denn bestehenden Einträgen angefügt und im UI dargestellt. |

### Ausnahmen und Varianten

| Nr. | Wer | Was |
| - | - | - |
| 1.3 | | Daten nicht I.O. |
| 1.3.1 | Benutzer | Falsche Daten aufgrund von Übersteuerung durch den Benutzer eingefügt. |
| 1.3.2 | System | Fehlermeldung wird angezeigt. |
| 1.3.3 | Benutzer | Korrektur der Eingabe. |
