package Business;
import java.util.Date;

class Patient extends User {
    Date lastEntryWritten;
    JournalLibrary journalLibrary;
    LevelLibrary levelLibrary;
}
