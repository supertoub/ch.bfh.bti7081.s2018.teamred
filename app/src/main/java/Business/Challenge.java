package Business;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Challenge {
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

    // TODO: Korrektes Level ChallengeState handling
    public Challenge(String title, String desc, ChallengeState challengeState, int levelOfAnxiety) {
        this.title = title;
        this.desc = desc;
        this.challengeState = challengeState;
        this.levelOfAnxiety = levelOfAnxiety;
    }

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
    }

    public int getLevelOfAnxiety() {
        return levelOfAnxiety;
    }

    public void setLevelOfAnxiety(int levelOfAnxiety) {
        this.levelOfAnxiety = levelOfAnxiety;
    }

    void change(){}
}
