package Business;

import javax.security.auth.Subject;
import java.util.Observable;
import java.util.Observer;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class  Challenge extends Observable {

    //region Properties

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "challenge_id")
    private long id;

    @Column(length = 256)
    private String title;

    @Column(length = 1024)
    private String desc;

    @Enumerated
    private ChallengeState challengeState;

    private int levelOfAnxiety;

    //endregion

    //region Getter & Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public ChallengeState getChallengeState() {
        return challengeState;
    }

    public void setChallengeState(ChallengeState challengeState) {
        this.challengeState = challengeState;
        this.setChanged();
        this.notifyObservers();
    }

    public int getLevelOfAnxiety() {
        return levelOfAnxiety;
    }

    public void setLevelOfAnxiety(int levelOfAnxiety) {
        this.levelOfAnxiety = levelOfAnxiety;
    }

    //endregion

    //region Konstruktoren

    // TODO: Korrektes Level ChallengeState handling
    public Challenge(String title, String desc, ChallengeState challengeState, int levelOfAnxiety, Observer observer){
        this.title = title;
        this.desc = desc;
        this.challengeState = challengeState;
        this.levelOfAnxiety = levelOfAnxiety;
        this.addObserver(observer);
    }

    //endregion

    //region Methoden
    //endregion

}