package Business;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class JournalLibrary /*extends Observable implements Observer*/ {
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
    //region Methoden

    public void createJournalEntry(Date Date, String jTitle, String jDesc){
        journalEntries.add(new JournalEntry(Date, ""+jTitle, jDesc));
    }
    void deleteEntry(JournalEntry entry){}
    //endregion




}
