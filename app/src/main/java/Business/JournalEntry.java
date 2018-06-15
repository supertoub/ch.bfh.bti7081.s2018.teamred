package Business;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="journalentry")
public class JournalEntry {

    //region Variablen
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "journalentry_id")
    private long id;

    @Column(length = 256)
    private String title;

    @Column(length = 1024)
    private String desc;

    @ManyToOne
    @JoinColumn(name="journallibrary_id")
    private JournalLibrary journalLibrary;

    private Date date;
    //endregion

    //region Getter
    public long getId() {
        return id;
    }
    public String getDesc() {
        return desc;
    }
    public String getTitle() {
        return title;
    }
    public Date getDate() { return date; }
    public JournalLibrary getJournalLibrary() {
        return journalLibrary;
    }
    //endregion

    //region Setter
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setJournalLibrary(JournalLibrary journalLibrary) {
        this.journalLibrary = journalLibrary;
    }
    public void setDate(Date date) { this.date = date; }
    //endregion

    //region Konstruktoren
    public JournalEntry(Date date, String title, String desc, JournalLibrary journalLibrary){
        this.date = date;
        this.title = title;
        this.desc = desc;
        this.journalLibrary = journalLibrary;
    }
    // no-arg constructur needed by hibernate for object creation via reflection
    public JournalEntry(){}

    //endregion

}
