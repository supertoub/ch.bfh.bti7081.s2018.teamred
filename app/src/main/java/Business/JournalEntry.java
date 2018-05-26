package Business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity
class JournalEntry {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "journalentry_id")
    private long id;

    @Column(length = 256)
    private String title;

    @Column(length = 1024)
    private String desc;

    private Date date;

    void change(){}
}
