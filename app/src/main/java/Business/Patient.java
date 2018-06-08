package Business;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Patient extends User {

    //region Variablen

    private Date lastEntryWritten;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="journallibrary_id")
    private JournalLibrary journalLibrary;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="levellibrary_id")
    private LevelLibrary levelLibrary;

    //endregion

    //region Konstruktor

    public Patient(String userName,String name, String surname, String pwd, Date lastEntryWritten, JournalLibrary journalLibrary, LevelLibrary levelLibrary) {
        super(userName,name, surname, pwd);
        this.lastEntryWritten = lastEntryWritten;
        this.journalLibrary = journalLibrary;
        this.levelLibrary = levelLibrary;
    }

    //endregion

    //region Getter

    public Date getLastEntryWritten() {
        return lastEntryWritten;
    }

    public JournalLibrary getJournalLibrary() {
        return journalLibrary;
    }

    public LevelLibrary getLevelLibrary() {
        return levelLibrary;
    }

    //endregion

    //region Setter

    public void setLastEntryWritten(Date lastEntryWritten) {
        this.lastEntryWritten = lastEntryWritten;
    }

    public void setJournalLibrary(JournalLibrary journalLibrary) {
        this.journalLibrary = journalLibrary;
    }

    public void setLevelLibrary(LevelLibrary levelLibrary) {
        this.levelLibrary = levelLibrary;
    }

    //endregion

}
