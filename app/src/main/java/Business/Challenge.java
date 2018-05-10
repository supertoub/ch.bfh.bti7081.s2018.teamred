package Business;

class Challenge {
    private String title;
    private String desc;
    private ChallengeState challengeState;
    private int levelOfAnxiety;

    String getChallengeTitle(){
        return title;
    }
    ChallengeState getChallengeState() { return challengeState; }
    String getChallengeDesc() {return desc;}
    int getChallengeLevelOfAnxiety() {return levelOfAnxiety;}


    // TODO: Korrektes Level ChallengeState handling
    Challenge(String title, String desc, ChallengeState challengeState, int levelOfAnxiety){
        this.title = title;
        this.desc = desc;
        this.challengeState = challengeState;
        this.levelOfAnxiety = levelOfAnxiety;
    }


    void change(){}
}
