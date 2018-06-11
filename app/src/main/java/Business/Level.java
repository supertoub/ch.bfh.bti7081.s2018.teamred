package Business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="level")
public class Level extends Observable implements Observer {

    //region Variablen
    private static final Logger logger = LogManager.getLogger(Level.class);

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "level_id")
    private long id;

    @OneToMany(mappedBy = "level", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Challenge> challenges;

    @Enumerated(EnumType.STRING)
    private LevelState levelState;

    @ManyToOne
    @JoinColumn(name = "levellibrary_id")
    private LevelLibrary levelLibrary;

    private String levelLabel;
    private int levelDoneCount;
    private int levelCount;
    boolean isDone = false;

    //endregion

    //region Getter

    public String getLevelLabel() {
        return levelLabel;
    }

    List<Challenge> getChallenges() {
        return challenges;
    }

    LevelState getLevelState() {
        return levelState;
    }

    int getLevelCount() {
        return levelCount;
    }

    int getLevelDoneCount() {
        return this.levelDoneCount;
    }

    int getClosedChallengesCount() {
        return (int) this.challenges.stream().filter(cha -> cha.getChallengeState() == ChallengeState.closed).count();
    }

    public long getId() {
        return id;
    }

    //endregion

    //region Setter

    public void setLevelState(LevelState levelState) {
        this.levelState = levelState;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public void setLevelLabel(String levelLabel) {
        this.levelLabel = levelLabel;
    }

    //endregion

    // TODO: Korrektes Level ChallengeState handling
    public Level(String label, LevelState state, int count, LevelLibrary levelLibrary, Observer observer) {
        this.levelLabel = label;
        this.levelState = state;
        this.challenges = new ArrayList<>();
        this.levelCount = count;
        this.levelLibrary = levelLibrary;
        this.levelDoneCount = (count + 1) * 2;
        this.addObserver(observer);
    }

    // no-arg constructur needed by hibernate for object creation via reflection
    public Level(){}

    public void deleteChallenge(Challenge challenge){
        challenges.remove(challenge);
    }

    //region Event

    @Override
    public void update(Observable o, Object arg) {
        logger.debug("got level: " + this.getLevelLabel());
        logger.debug("got challenges: " + this.challenges.toString());
        int countClosedChallanges = (int) this.challenges.stream().filter(ch -> ch.getChallengeState() == ChallengeState.closed).count();
        if (countClosedChallanges >= levelDoneCount) {
            this.isDone = true;
            this.setChanged();
            this.notifyObservers();
        }
    }

    //endregion
}
