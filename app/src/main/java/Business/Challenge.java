package Business;

public class  Challenge {

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
    }

    public void setLevelOfAnxiety(int levelOfAnxiety) {
        this.levelOfAnxiety = levelOfAnxiety;
    }

    //endregion

    //region Konstruktoren

    // TODO: Korrektes Level ChallengeState handling
    Challenge(String title, String desc, ChallengeState challengeState, int levelOfAnxiety){
        this.title = title;
        this.desc = desc;
        this.challengeState = challengeState;
        this.levelOfAnxiety = levelOfAnxiety;
    }

    //endregion

    //region Methoden

    void change(){}

    //endregion
}
