package Business;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="patient")
public class Patient extends User {

    //region Variablen
    private Date lastEntryWritten;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private LevelLibrary levelLibrary;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private JournalLibrary journalLibrary;

    //endregion

    //region Konstruktor

    public Patient(String userName,String name, String surname, String pwd, Date lastEntryWritten, JournalLibrary journalLibrary, LevelLibrary levelLibrary) {
        super(name, surname, pwd);
        this.lastEntryWritten = lastEntryWritten;
        this.journalLibrary = journalLibrary;
        this.levelLibrary = levelLibrary;
    }

    public Patient(String name, String surname, String pwd) {
        super(name, surname, pwd);
    }

    // no-arg constructur needed by hibernate for object creation via reflection
    public Patient(){}
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
