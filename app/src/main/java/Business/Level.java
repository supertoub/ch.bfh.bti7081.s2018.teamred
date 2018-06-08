package Business;

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
public class Level extends Observable implements Observer{

    //region Variablen

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
    @JoinColumn(name="levellibrary_id")
    private LevelLibrary levelLibrary;

    private String levelLabel;
    private int levelDoneCount;
    private int levelCount;
    boolean isDone = false;

    //endregion

    //region Getter

    public String getLevelLabel(){return levelLabel;}

    List<Challenge> getChallenges() {return challenges;}

    LevelState getLevelState() { return levelState; }

    int getLevelCount(){return levelCount;}

    int getLevelDoneCount(){return this.levelDoneCount;}

    int getClosedChallengesCount(){return (int) this.challenges.stream().filter(cha -> cha.getChallengeState() == ChallengeState.closed).count();}

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

    //region Konstruktoren
    public Level() {}

    // TODO: Korrektes Level ChallengeState handling
    public Level(String label, int count, LevelLibrary levelLibrary, Observer observer){
        this.levelLabel = label;
        this.levelState = LevelState.open;
        this.challenges = new ArrayList<>();
        this.levelCount = count;
        this.levelLibrary = levelLibrary;
        this.levelDoneCount = (count + 1) * 2;
        this.addObserver(observer);
    }

    // no-arg constructur needed by hibernate for object creation via reflection
    public Level(){}

    //endregion

    //region Methoden

    public void createChallenge(String level) {
        Challenge newChallange = new Challenge(level + " Challenge " + (challenges.size() + 1), "Go shopping at Migros and get all the answers the saleswoman asks. Also talk to a stranger and ask them if they know where the coffee is.", ChallengeState.open, 4, this);
        challenges.add(newChallange);
    }

    public void createChallenge(String levelTitle, String cTitle, String cDesc, int lOfAx) {
        challenges.add(new Challenge(levelTitle + " " + cTitle, cDesc, ChallengeState.open, lOfAx, this));
    }

    public void deleteChallenge(Challenge challenge){
        challenges.remove(challenge);
    }

    //endregion

    //region Event

    @Override
    public void update(Observable o, Object arg) {
        int countClosedChallanges = (int) this.challenges.stream().filter(ch -> ch.getChallengeState() == ChallengeState.closed).count();
        if (countClosedChallanges >= levelDoneCount){
            this.isDone = true;
            this.setChanged();
            this.notifyObservers();
        }
    }

    //endregion
