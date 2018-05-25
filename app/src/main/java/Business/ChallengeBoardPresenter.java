package Business;



import UserInterface.AddChallenge;
import UserInterface.ChallengeBoard;
import UserInterface.ChallengeBoardView;
import ch.bfh.MyUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

import java.util.ArrayList;
import java.util.List;

public class ChallengeBoardPresenter implements ChallengeBoard.ChallengeBoardViewListener {

    //region Variablen

    private static ChallengeBoardPresenter instance;

    private ChallengeBoardView boardView;

    private LevelLibrary lvlLibrary;

    private Level clickedLevel = new Level("");

    //endregion

    //region Getter

    public ChallengeBoardView getBoardView() {
        return boardView;
    }

    public static ChallengeBoardPresenter getInstance() {
        if (instance == null) {
            instance = new ChallengeBoardPresenter();
        }

        return instance;
    }

    //endregion

    //region Setter
    //endregion

    //region Konstruktoren

    private ChallengeBoardPresenter() {
        boardView = new ChallengeBoardView();
        boardView.addListener(this);
        boardView.addBackButton();
        boardView.addChallengeButton();
        lvlLibrary = new LevelLibrary();
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

    //endregion

    //region Methoden

    void addClick() {
    }

    void deleteClick(Object sender) {
    }

    void changeClick() {
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

    // TODO: Event in Level handeln
    private Level findClickedLevel(String buttonTitle) {
        for (int i = 0; i <= lvlLibrary.getLevels().size(); i++) {
            if (lvlLibrary.getLevels().get(i).getLevelLabel().equals(buttonTitle)) {
                return lvlLibrary.getLevels().get(i);
            }
        }
        return null; //hier Exception machen falls es das LVL nicht findet
    }

    // TODO: Event in Challange handeln
    private Challenge findChallenge(String panelName){
        for (int i = 0; i < clickedLevel.getChallenges().size();i++){
            if(clickedLevel.getChallenges().get(i).getChallengeTitle().equals(panelName)){
                return clickedLevel.getChallenges().get(i);
            }
        }
        return null; //hier Exception machen falls es das challenge nicht findet
    }

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
            boardView.addChallenge(challenge.getTitle(), challenge.getDesc(), challenge.getChallengeState(), challenge.getLevelOfAnxiety());
        }
    }

    //endregion

    //region Events

    @Override
    public void buttonClick(Button clickedButton) {
        if(clickedButton.getId()=="back"){
            UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
        }
        else if(clickedButton.getId()=="level"){
            if(clickedLevel.getLevelLabel().equals(clickedButton.getCaption())){
                boardView.removeChallenges();
                clickedLevel=new Level("");
            }
            else{
                boardView.removeChallenges();
                clickedLevel = findClickedLevel(clickedButton.getCaption());

                if (clickedLevel == null){
                    return;
                }

                updateChallengeView(clickedLevel);
            }
        }

        else if(clickedButton.getId()=="newChall"){
            newWindowAddChall();
        }
        else if (clickedButton.getId()=="close" || clickedButton.getId()=="reOpen"){
            if(clickedButton.getId()=="close") findChallenge(clickedButton.getParent().getParent().getCaption()).setChallengeState(ChallengeState.closed);
            else findChallenge(clickedButton.getParent().getParent().getCaption()).setChallengeState(ChallengeState.open);
            boardView.removeChallenges();
            updateChallengeView(clickedLevel);
        }

    }

    @Override
    public void buttonClick(String levelTitle, String cTitle, String cDesc, int lOfAx) {
        Level level = findClickedLevel(levelTitle);
        level.createChallenge(levelTitle,cTitle,cDesc,lOfAx);
    }

    //endregion

}
