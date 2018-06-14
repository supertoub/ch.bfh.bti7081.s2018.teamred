package Business;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="journalentry")
public class JournalEntry {
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

    public JournalEntry(Date date, String title, String desc, JournalLibrary journalLibrary){
        this.date = date;
        this.title = title;
        this.desc = desc;
        this.journalLibrary = journalLibrary;
    }

    // no-arg constructur needed by hibernate for object creation via reflection
    public JournalEntry(){}

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public JournalLibrary getJournalLibrary() {
        return journalLibrary;
    }

    public void setJournalLibrary(JournalLibrary journalLibrary) {
        this.journalLibrary = journalLibrary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
