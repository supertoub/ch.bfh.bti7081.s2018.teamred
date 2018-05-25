package Business;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Patient extends User {
    private Date lastEntryWritten;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="journallibrary_id")
    private JournalLibrary journalLibrary;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="levellibrary_id")
    private LevelLibrary levelLibrary;

    public Patient(String name, String surname, String pwd, Date lastEntryWritten, JournalLibrary journalLibrary, LevelLibrary levelLibrary) {
        super(name, surname, pwd);
        this.lastEntryWritten = lastEntryWritten;
        this.journalLibrary = journalLibrary;
        this.levelLibrary = levelLibrary;
    }

    public Patient() {
    }

    public Date getLastEntryWritten() {
        return lastEntryWritten;
    }

    public void setLastEntryWritten(Date lastEntryWritten) {
        this.lastEntryWritten = lastEntryWritten;
    }

    public JournalLibrary getJournalLibrary() {
        return journalLibrary;
    }

    public void setJournalLibrary(JournalLibrary journalLibrary) {
        this.journalLibrary = journalLibrary;
    }

    public LevelLibrary getLevelLibrary() {
        return levelLibrary;
    }

    public void setLevelLibrary(LevelLibrary levelLibrary) {
        this.levelLibrary = levelLibrary;
    }
}
