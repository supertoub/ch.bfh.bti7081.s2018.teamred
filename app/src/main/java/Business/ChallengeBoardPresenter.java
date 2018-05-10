package Business;

import UserInterface.ChallengeBoardView;

import java.util.List;

// implemented as singleton
public class ChallengeBoardPresenter {

    private static ChallengeBoardPresenter instance;

    private ChallengeBoardView boardView;

    private LevelLibrary lvlLibrary;

    private Level lvlChallenges;

    //<editor-fold desc="getter">

    public ChallengeBoardView getBoardView (){
        return boardView;
    }

    public static ChallengeBoardPresenter getInstance(){
        if (instance == null){
            instance = new ChallengeBoardPresenter();
        }

        return instance;
    }

    //</editor-fold>

    //<editor-fold desc="constructors">

    private ChallengeBoardPresenter(){
        boardView = new ChallengeBoardView();
        lvlLibrary = new LevelLibrary();
        lvlChallenges = new Level();
        for (int i = 1; i <= 15; i++){
            lvlLibrary.createNewLevel();
        }
        for (int i = 1; i <= 5; i++){
            lvlChallenges.createChallenge();
        }
        updateLevelView();
        updateChallengeView();
    }

    //</editor-fold>

    private void updateLevelView(){
        List<Level> levels = lvlLibrary.getLevels();
        for (Level level : levels){
            boardView.addLevel(level.getLevelLabel(), level.getLevelState());
        }

    }

    private void updateChallengeView(){
        List<Challenge> challenges = lvlChallenges.getChallenges();
        for (Challenge challenge : challenges){
            boardView.addChallenge(challenge.getChallengeTitle(), challenge.getChallengeDesc(),challenge.getChallengeState(),challenge.getChallengeLevelOfAnxiety());
        }

    }

    void addClick(){}

    void deleteClick(Object sender){}

    void changeClick(){}
}
