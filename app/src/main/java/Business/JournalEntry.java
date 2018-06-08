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

    public JournalEntry(String title, String desc, JournalLibrary journalLibrary, Date date) {
        this.title = title;
        this.desc = desc;
        this.journalLibrary = journalLibrary;
        this.date = date;
    }

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
