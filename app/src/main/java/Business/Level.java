package Business;

import java.util.List;

class Level {
    private List<Challange> challanges;
    private LevelState levelState;
    private String levelLabel;

    String getLevelLabel(){
        return levelLabel;
    }

    LevelState getLevelState() { return levelState; }

    // TODO: Korrektes Level State handling
    Level(String label){
        this.levelLabel = label;
        this.levelState = LevelState.closed;
    }

    Level(String label, LevelState state){
        this.levelLabel = label;
        this.levelState = state;
    }

    void createChallange(){}

    void deleteChallagne(Challange challange){}


}
