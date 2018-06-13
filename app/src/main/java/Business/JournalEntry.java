package Business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Observer;
import java.util.Observable;

import static javax.persistence.GenerationType.AUTO;

@Entity
class JournalEntry /*extends Observable implements Observer*/{
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "journalentry_id")
    private long id;

    @Column(length = 256)
    private String title;

    @Column(length = 1024)
    private String desc;

    private Date date;


//region Getter & Setter
    public String getTitle() {
        return title;
    }
    public long getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public Date getDate() {
        return date;
    }

    //endregion

    //region Konstruktoren
    public JournalEntry () {}

    // TODO: Korrektes Level ChallengeState handling
    public JournalEntry(Date date, String title, String desc){
        this.title = title;
        this.desc = desc;
        this.date = date;
        //this.addObserver(observer);
    }

    //endregion


}
