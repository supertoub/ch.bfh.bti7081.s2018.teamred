## System evolution

Software Evolution in Zusammenhang mit diesen acht Gesetzen von Lehmans (https://en.wikipedia.org/wiki/Lehman%27s_laws_of_software_evolution).


Die Gesetze beschreiben ein Gleichgewicht zwischen den Kräften, die neue Entwicklungen vorantreiben, und den Kräften, die den Fortschritt verlangsamen. In den letzten Jahrzehnten wurden die Gesetze mehrfach überarbeitet und erweitert.


Law | Description
-----|--------
Continuing Change | an E-type system must be continually adapted or it becomes progressively less satisfactory
Increasing Complexity | as an E-type system evolves, its complexity increases unless work is done to maintain or reduce it
Self Regulation | E-type system evolution processes are self-regulating with the distribution of product and process measures close to normal
Conservation of Organisational Stability | the average effective global activity rate in an evolving E-type system is invariant over the product's lifetime
Conservation of Familiarity | as an E-type system evolves, all associated with it, developers, sales personnel and users, for example, must maintain mastery of its content and behaviour to achieve satisfactory evolution. Excessive growth diminishes that mastery. Hence the average incremental growth remains invariant as the system evolves.
Continuing Growth | the functional content of an E-type system must be continually increased to maintain user satisfaction over its lifetime
Declining Quality |  the quality of an E-type system will appear to be declining unless it is rigorously maintained and adapted to operational environment changes
Feedback System | E-type evolution processes constitute multi-level, multi-loop, multi-agent feedback systems and must be treated as such to achieve significant improvement over any reasonable base


An E-program is written to perform some real-world activity; how it should behave is strongly linked to the environment in which it runs, and such a program needs to adapt to varying requirements and circumstances in that environment


### Was wir für unsere Anwendung beachten müssen im Design

* Der Aufbau der Datenbank. Skalierbarkeit, Erweiterbarkeit und der Zugriff

* Die Darstellung der App muss auf verschiedensten Geräten funktionieren. Falls Browser App, Darstellung auf Smartphone oder Tablet beachten.

* Verschiedene Betriebssysteme. Mac und Windows, Linux ausgenommen.

* Die Erweiterbarkeit des Journals falls vom Patienten oder Doktor erwünscht. Z.B. neue Punkte die er ins Journal aufnehmen will. Die Challenges erweitern, etc.

* Sprachsteuerung mit Sprache zu Text Integration.