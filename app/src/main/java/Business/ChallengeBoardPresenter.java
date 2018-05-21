package Business;


import UserInterface.AddChallenge;
import UserInterface.ChallengeBoard;
import UserInterface.ChallengeBoardView;
import ch.bfh.MyUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

import java.util.ArrayList;
import java.util.List;

// implemented as singleton
public class ChallengeBoardPresenter implements ChallengeBoard.ChallengeBoardViewListener {

    public void buttonClick(String buttonTitle) {
        // same Button was clicked before
        if(buttonTitle.equals("Back")){
            UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
        }
        if(clickedLevel.getLevelLabel().equals(buttonTitle)){
            boardView.removeChallenges();
            clickedLevel=new Level("");
        }
        else{
            boardView.removeChallenges();
            clickedLevel = findClickedLevel(buttonTitle);
            updateChallengeView(clickedLevel);
        }
    }

    @Override
    public void buttonClick(Button openClose) {
        if(openClose.getId()=="newChall"){
            newWindowAddChall();
        }
        else if (openClose.getId()=="close" || openClose.getId()=="reOpen"){
            if(openClose.getId()=="close") findChallenge(openClose.getParent().getParent().getCaption()).setChallengeState(ChallengeState.closed);
            else findChallenge(openClose.getParent().getParent().getCaption()).setChallengeState(ChallengeState.open);
            boardView.removeChallenges();
            updateChallengeView(clickedLevel);
        }
    }

    private void newWindowAddChall() {
        List<String> lvls = new ArrayList<>();
        for (int i=0;i<lvlLibrary.getLevels().size();i++){
            lvls.add(lvlLibrary.getLevels().get(i).getLevelLabel());
        }
        AddChallenge aC = new AddChallenge(lvls);
        aC.addListener(this);
        // Add it to the root component
        UI.getCurrent().addWindow(aC);
    }

    @Override
    public void buttonClick(String levelTitle, String cTitle, String cDesc, int lOfAx) {
        Level level = findClickedLevel(levelTitle);
       level.createChallenge(levelTitle,cTitle,cDesc,lOfAx);
    }


    private Level findClickedLevel(String buttonTitle) {
        for (int i = 0; i < lvlLibrary.getLevels().size(); i++) {
            if (lvlLibrary.getLevels().get(i).getLevelLabel().equals(buttonTitle)) {
                return lvlLibrary.getLevels().get(i);
            }
        }
        return new Level(""); //hier Exception machen falls es das LVL nicht findet
    }
    private Challenge findChallenge(String panelName){
        for (int i = 0; i < clickedLevel.getChallenges().size();i++){
            if(clickedLevel.getChallenges().get(i).getChallengeTitle().equals(panelName)){
                return clickedLevel.getChallenges().get(i);
            }
        }
        return null; //hier Exception machen falls es das challenge nicht findet
    }


    private static ChallengeBoardPresenter instance;

    private ChallengeBoardView boardView;

    private LevelLibrary lvlLibrary;

    private Level clickedLevel = new Level("");

    //<editor-fold desc="getter">

    public ChallengeBoardView getBoardView() {
        return boardView;
    }

    public static ChallengeBoardPresenter getInstance() {
        if (instance == null) {
            instance = new ChallengeBoardPresenter();
        }

        return instance;
    }

    //</editor-fold>

    //<editor-fold desc="constructors">

    private ChallengeBoardPresenter() {
        boardView = new ChallengeBoardView();
        boardView.addListener(this);
        lvlLibrary = new LevelLibrary();
        boardView.addBackButton();
        boardView.addChallengeButton();
        for (int i = 1; i <= 5; i++) {
            lvlLibrary.createNewLevel();
        }
        lvlLibrary.getLevels().get(3).setLevelState(LevelState.closed);
        //add 6 Challanges for each Level
        for (int i = 0; i <= lvlLibrary.getLevels().size() - 1; i++) {
            for (int j = 1; j < 7; j++) {
                lvlLibrary.getLevels().get(i).createChallenge("lvl "+(i+1)+":");
                if (j % 2 == 0) {
                    lvlLibrary.getLevels().get(i).getChallenges().get(j - 1).setChallengeState(ChallengeState.open);
                }
            }
        }

        updateLevelView();
    }

    //</editor-fold>

    private void updateLevelView() {
        List<Level> levels = lvlLibrary.getLevels();
        for (Level level : levels) {
            boardView.addLevel(level.getLevelLabel(), level.getLevelState());
            //um das Layout anzuschauen, sollte mit button click kommen auf challange
            //if(level.getLevelState()==LevelState.open) {
            //    updateChallengeView(level);
            //}
        }
    }

    private void updateChallengeView(Level level) {
        List<Challenge> challenges = level.getChallenges();
        for (Challenge challenge : challenges) {
            boardView.addChallenge(challenge.getChallengeTitle(), challenge.getChallengeDesc(), challenge.getChallengeState(), challenge.getChallengeLevelOfAnxiety());
        }
    }


    void addClick() {
    }

    void deleteClick(Object sender) {
    }

    void changeClick() {
    }


}
