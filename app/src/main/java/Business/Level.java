package Business;

import java.util.ArrayList;
import java.util.List;

class Level {

    //region Variablen

    private List<Challenge> challenges;
    private LevelState levelState;
    private String levelLabel;

    //endregion

    //region Getter

    String getLevelLabel(){
        return levelLabel;
    }
    List<Challenge> getChallenges() {return challenges;}
    LevelState getLevelState() { return levelState; }

    //endregion

    //region Setter

    public void setLevelState(LevelState levelState) {
        this.levelState = levelState;
    }

    //endregion

    //region Konstruktoren

    // TODO: Korrektes Level ChallengeState handling
    Level(String label){
        this.levelLabel = label;
        this.levelState = LevelState.open;
        challenges = new ArrayList<>();
    }

    //endregion

    //region Methoden

    void createChallenge(String level){
        challenges.add(new Challenge(level +" Challenge " + (challenges.size()+1),"test", ChallengeState.closed,4));
    }

    void deleteChallenge(Challenge challenge){}

    //endregion

}
