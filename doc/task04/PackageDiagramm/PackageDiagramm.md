# Package Diagramm

[<Taks 04](../Task04.md)

Wir haben uns ein Package Diagramm überlegt, welches uns ermöglichen soll möglichst flexibel Packages zu ersetzten/hinzufügen, ohne dass die Hauptlogik (enthalten im "Business Layer" und im "Common Layer") verändert werden muss.

![Package Diagramm](./PackageDiagramm.svg)

## UI Layer

Im UI Layer wird die ganze UI Logik gehandelt, es wird das "Business Layer" und das "Common Layer" Package verwendet. Ziel dabei ist es, falls ein neues oder zusätzliches UI erstellt werden soll, dass das Package möglichst einfach an die Kern Logik angebunden werden kann.

## Business Layer

Im Business Layer wird die gesammte Logik der Applikation abgebildet.

## Data Layer

Das Data Layer ist für die Speicherung und für das Abrufen von Daten zuständig.

## Common Layer

Im Common Layer sind die Klassen bzw. Models enthalten die in allen anderen Packages verwendet werden. Z.B: die User Klasse oder die Challange Klasse.