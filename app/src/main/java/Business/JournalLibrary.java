package Business;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="journallibrary")
public class JournalLibrary {
    //region Variablen
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "journallibrary_id")
    private long id;

    @OneToMany(mappedBy = "journalLibrary", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<JournalEntry> journalEntries;

    @OneToOne
    @JoinColumn(name="user_id")
    private Patient patient;
    //endregion

    //region Getter
    public long getId() {
        return id;
    }

    public List<JournalEntry> getJournalEntries() {
        if (journalEntries == null){
            journalEntries = new ArrayList<>();
        }

        return journalEntries;
    }
    public Patient getPatient() {
        return patient;
    }
    //endregion

    //region Setter
    public void setJournalEntries(List<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }


    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    //endregion

    //region Konstruktoren
    public JournalLibrary(List<JournalEntry> journalEntries, Patient patient) {
        this.journalEntries = journalEntries;
        this.patient = patient;
    }

    // no-arg constructur needed by hibernate for object creation via reflection
    public JournalLibrary(){}

    //endregion

}
