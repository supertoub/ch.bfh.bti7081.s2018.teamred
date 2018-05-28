package Business;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class JournalLibrary {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "journallibrary_id")
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="journalentry_id")
    private List<JournalEntry> journalEntries;

    public JournalLibrary() {}
    public JournalLibrary(List<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void setJournalEntries(List<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }

    void createEntry(){}

    void deleteEntry(JournalEntry entry){}

}
