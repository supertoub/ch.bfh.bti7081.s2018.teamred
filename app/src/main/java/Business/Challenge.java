package Business;

import javax.security.auth.Subject;
import java.util.Observable;
import java.util.Observer;

public class  Challenge extends Observable {

    //region Variablen

    private String title;
    private String desc;
    private ChallengeState challengeState;
    private int levelOfAnxiety;

    //endregion

    //region Getter

    String getChallengeTitle(){
        return title;
    }

    ChallengeState getChallengeState() { return challengeState; }

    String getChallengeDesc() {return desc;}

    int getChallengeLevelOfAnxiety() {return levelOfAnxiety;}

    //endregion

    //region Setter

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setChallengeState(ChallengeState challengeState) {
        this.challengeState = challengeState;
        this.setChanged();
        this.notifyObservers();
    }

    public void setLevelOfAnxiety(int levelOfAnxiety) {
        this.levelOfAnxiety = levelOfAnxiety;
    }

    //endregion

    //region Konstruktoren

    // TODO: Korrektes Level ChallengeState handling
    Challenge(String title, String desc, ChallengeState challengeState, int levelOfAnxiety, Observer observer){
        this.title = title;
        this.desc = desc;
        this.challengeState = challengeState;
        this.levelOfAnxiety = levelOfAnxiety;
        this.addObserver(observer);
    }

    //endregion

    //region Methoden

    void change(){}

    //endregion
}
