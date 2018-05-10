package Business;

import java.util.ArrayList;
import java.util.List;

class Level {
    private List<Challenge> challenges;
    private LevelState levelState;
    private String levelLabel;

    public void setLevelState(LevelState levelState) {
        this.levelState = levelState;
    }

    String getLevelLabel(){
        return levelLabel;
    }
    List<Challenge> getChallenges() {return challenges;}
    LevelState getLevelState() { return levelState; }

    // TODO: Korrektes Level ChallengeState handling
    Level(String label){
        this.levelLabel = label;
        this.levelState = LevelState.closed;
        challenges = new ArrayList<>();
    }

    void createChallenge(){
        challenges.add(new Challenge("Challenge " + (challenges.size()+1),"test", ChallengeState.closed,4));
    }

    void deleteChallenge(Challenge challenge){}


}
