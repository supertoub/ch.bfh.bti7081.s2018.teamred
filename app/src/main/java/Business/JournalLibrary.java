package Business;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="journallibrary")
public class JournalLibrary {
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

    public JournalLibrary(List<JournalEntry> journalEntries, Patient patient) {
        this.journalEntries = journalEntries;
        this.patient = patient;
    }

    public long getId() {
        return id;
    }

    public List<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void setJournalEntries(List<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
