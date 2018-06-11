package Business;

import javax.persistence.*;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class JournalLibrary /*extends Observable implements Observer*/ {
    @Id
    @GeneratedValue(strategy = AUTO)
    //@Column(name = "journallibrary_id")
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name="journalentry_id")
    private List<JournalEntry> journalEntries;

    public JournalLibrary() {
        this.journalEntries = new ArrayList<>();
    }

    public JournalLibrary(List<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }

    public long getId() {
        return id;
    }

    public List<JournalEntry> getJournalEntries() {
        if (journalEntries == null){
            journalEntries = new ArrayList<>();
        }

        return journalEntries;
    }

    public void setJournalEntries(List<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }
    //region Methoden


    public void createJournalEntry(Date Date, String jTitle, String jDesc){
        if (journalEntries == null){
            journalEntries = new ArrayList<>();
        }
        journalEntries.add(new JournalEntry(Date, ""+jTitle, jDesc));
    }

    //endregion



   /* public void createEntry(){
        if (journalEntries == null){
            journalEntries = new ArrayList<>();
        }
        journalEntries.add(new JournalEntry());
    }*/

    void deleteEntry(JournalEntry entry){
        if (journalEntries == null){
            journalEntries = new ArrayList<>();
            return;
        }
        journalEntries.remove(entry);
    }


}
