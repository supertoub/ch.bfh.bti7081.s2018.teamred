# Use Cases

## Use Case 1

| Beizeichnung | Beschreibung |
| - |- |
| Name | Challange erstellen |
| Nummer | 1 |
| Kurzbeschreibung | Der Patient erfasst eine neue Challange. |
| Beteiligte Akteure | Benutzer |
| Auslöser / Vorbedingung | keine |
| Ergebnisse / Nachbedingung | Die Challange erscheint im richtigen Level mit dem richtigen Status. Sie wird für die Statistik berücksichtigt. |

### Ablauf

| Nr. | Wer | Was |
| - | - | - |
| 1.0 | Benutzer | Der Patient betätigt den Hinzufügen Buttton. |
| 1.1 | Benutzer | Über die Erstellungsmaske werden die Details für die Challange abgefüllt. Danach wird die Challange gespeichert. |
| 1.2 | System | Überprüfung der eingegebenen Daten. |
| 1.3 | System | Ausnahme Daten nicht I.O. |
| 1.3 | System | Die Challange wird dem dazugehörigen Level angefügt und auf dem UI angezeigt. |

### Ausnahmen und Varianten

| Nr. | Wer | Was |
| - | - | - |
| 1.3 | | Daten nicht I.O. |
| 1.3.1 | Benutzer | Falsche Daten aufgrund von übersteuerung durch den Benutzer eingefügt. |
| 1.3.2 | System | Fehlermeldung wird angezeigt. |
| 1.3.3 | Benutzer | Korrektur der Eingabe. |