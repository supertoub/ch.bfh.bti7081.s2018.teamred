package Business;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "level_id")
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="challenge_id")

    private List<Challenge> challenges;

    @Enumerated(EnumType.STRING)
    private LevelState levelState;

    private String levelLabel;

    public Level() {}

    // TODO: Korrektes Level ChallengeState handling
    public Level(String label){
        this.levelLabel = label;
        this.levelState = LevelState.open;
        challenges = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public LevelState getLevelState() {
        return levelState;
    }

    public void setLevelState(LevelState levelState) {
        this.levelState = levelState;
    }

    public String getLevelLabel() {
        return levelLabel;
    }

    public void setLevelLabel(String levelLabel) {
        this.levelLabel = levelLabel;
    }

    void createChallenge(String level){
        challenges.add(new Challenge(level +" Challenge " + (challenges.size()+1),"test", ChallengeState.closed,4));
    }
    void createChallenge(String levelTitle, String cTitle, String cDesc, int lOfAx){
        challenges.add(new Challenge(levelTitle+ " " +cTitle, cDesc, ChallengeState.open,lOfAx));
    }

    void deleteChallenge(Challenge challenge){}
}
