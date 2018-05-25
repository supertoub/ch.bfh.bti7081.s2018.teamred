package Business;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class Level extends Observable implements Observer{

    //region Variablen

    private List<Challenge> challenges;
    private LevelState levelState;
    private String levelLabel;
    private int levelDoneCount;
    private int levelCount;
    boolean isDone = false;

    //endregion

    //region Getter

    String getLevelLabel(){return levelLabel;}

    List<Challenge> getChallenges() {return challenges;}

    LevelState getLevelState() { return levelState; }

    int getLevelCount(){return levelCount;}

    int getLevelDoneCount(){return this.levelDoneCount;}

    int getClosedChallengesCount(){return (int) this.challenges.stream().filter(cha -> cha.getChallengeState() == ChallengeState.closed).count();}

    //endregion

    //region Setter

    public void setLevelState(LevelState levelState) {
        this.levelState = levelState;
    }

    //endregion

    //region Konstruktoren

    // TODO: Korrektes Level ChallengeState handling
    Level(String label, int count, Observer observer){
        this.levelLabel = label;
        this.levelState = LevelState.open;
        this.challenges = new ArrayList<>();
        this.levelCount = count;
        this.levelDoneCount = (count + 1) * 2;
        this.addObserver(observer);
    }

    //endregion

    //region Methoden

    void createChallenge(String level){
        Challenge newChallange = new Challenge(level +" Challenge " + (challenges.size()+1),"test", ChallengeState.open,4, this);
        challenges.add(newChallange);
    }

    void createChallenge(String levelTitle, String cTitle, String cDesc, int lOfAx){
        challenges.add(new Challenge(levelTitle+ " " +cTitle, cDesc, ChallengeState.open,lOfAx, this));
    }

    void deleteChallenge(Challenge challenge){}

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

}
