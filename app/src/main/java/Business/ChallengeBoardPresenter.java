package Business;

import UserInterface.AddChallenge;
import UserInterface.ChallengeBoard;
import UserInterface.ChallengeBoardView;
import ch.bfh.MyUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class ChallengeBoardPresenter implements Observer, ChallengeBoard.ChallengeBoardViewListener {

    //region Variablen

    private static ChallengeBoardPresenter instance;

    private ChallengeBoardView boardView;

    private LevelLibrary lvlLibrary;

    private Level currentLevel;

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
        lvlLibrary = new LevelLibrary(this);
        boardView.addChallengeButton();
        for (int i = 1; i <= 5; i++) {
            if (i == 1) lvlLibrary.createNewLevel(LevelState.open);
            else lvlLibrary.createNewLevel(LevelState.closed);

        }

        lvlLibrary.getLevels().get(3).setLevelState(LevelState.closed);

        //add 6 Challanges for each Level
        for (int i = 0; i <= lvlLibrary.getLevels().size() - 1; i++) {
            for (int j = 1; j < 7; j++) {
                lvlLibrary.getLevels().get(i).createChallenge("lvl " + (i + 1) + ":");
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
        for (int i = 0; i < lvlLibrary.getLevels().size(); i++) {
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
    private Challenge findChallenge(String panelName) {
        for (int i = 0; i < currentLevel.getChallenges().size(); i++) {
            if (currentLevel.getChallenges().get(i).getTitle().equals(panelName)) {
                return currentLevel.getChallenges().get(i);
            }
        }
        return null; //hier Exception machen falls es das challenge nicht findet
    }

    private void updateLevelView() {
        boardView.clearLevels();
        List<Level> levels = lvlLibrary.getLevels();
        for (Level level : levels) {
            boardView.addLevel(level.getLevelLabel(), level.getLevelState());
            //um das Layout anzuschauen, sollte mit button click kommen auf challange
            //if(level.getLevelState()==LevelState.open) {
            //    updateChallengeView(level);
            //}
        }
    }

    private void addLevelToLevelView(Level levelToAdd) {
        boardView.addLevel(levelToAdd.getLevelLabel(), levelToAdd.getLevelState());
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
        if (clickedButton.getId().equals("back")) {
            UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
        } else if (clickedButton.getId().equals("level")) {
            currentLevel = findClickedLevel(clickedButton.getCaption());
            boardView.removeChallenges();

            if (currentLevel == null) {
                return;
            }

            boardView.setLevelInfoLabel(currentLevel.getClosedChallengesCount(), currentLevel.getLevelDoneCount(), currentLevel.getChallenges().size());
            updateChallengeView(currentLevel);
        } else if (clickedButton.getId().equals("newChall")) {
            newWindowAddChall();
        } else if (clickedButton.getId().equals("close") || clickedButton.getId() == "reOpen") {
            if (clickedButton.getId().equals("close"))
                findChallenge(clickedButton.getParent().getParent().getCaption()).setChallengeState(ChallengeState.closed);
            else
                findChallenge(clickedButton.getParent().getParent().getCaption()).setChallengeState(ChallengeState.open);
            boardView.removeChallenges();
            boardView.setLevelInfoLabel(currentLevel.getClosedChallengesCount(), currentLevel.getLevelDoneCount(), currentLevel.getChallenges().size());
            updateChallengeView(currentLevel);
        } else if (clickedButton.getId().equals("AddLevelButton")) {
            Level createdLevel = this.lvlLibrary.createNewLevel(LevelState.closed);
            this.addLevelToLevelView(createdLevel);
        }

    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        if (o instanceof LevelLibrary) {
            this.updateLevelView();
        }
    }

    @Override
    public void buttonClick(String levelTitle, String cTitle, String cDesc, int lOfAx) {
        Level level = findClickedLevel(levelTitle);
        level.createChallenge(levelTitle, cTitle, cDesc, lOfAx);
    }

    //endregion

}
