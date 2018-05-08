package Business;

import java.util.List;

class Level {
    private List<Challange> challanges;
    private LevelState levelState;
    private String levelLabel;

    String getLevelLabel(){
        return levelLabel;
    }

    Level(String label){
        this.levelLabel = label;
    }

    void createChallange(){}

    void deleteChallagne(Challange challange){}


}
