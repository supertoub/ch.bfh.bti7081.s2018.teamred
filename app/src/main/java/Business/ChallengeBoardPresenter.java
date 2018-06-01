package Business;

import UserInterface.AddChallenge;
import UserInterface.ChallengeBoard;
import UserInterface.ChallengeBoardView;
import UserInterface.ChallengeBoardViewPage;
import ch.bfh.MyUI;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;
import com.vaadin.navigator.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class ChallengeBoardPresenter extends ChallengeBoardViewPage implements Observer, View, ChallengeBoard.ChallengeBoardViewListener {

    //region Variablen

    private static ChallengeBoardPresenter instance;

    //private ChallengeBoardViewPage boardView;

    public LevelLibrary lvlLibrary;

    private Level currentLevel;

    //endregion

    //region Getter

   /* public ChallengeBoardViewPage getBoardView() {
        return boardView;
    }*/

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
        super();
        getBack().addClickListener(this::BackClick);
        getNewChall().addClickListener(this::NewChallClick);
        getAddLevelButton().addClickListener(this::AddLevelButtonClick);

        // Creates Levels for a example view
        lvlLibrary = new LevelLibrary(this);
        for (int i = 1; i <= 5; i++) {
            if (i == 1) lvlLibrary.createNewLevel(LevelState.open);
            else lvlLibrary.createNewLevel(LevelState.closed);

        }
        lvlLibrary.getLevels().get(3).setLevelState(LevelState.closed);

        //add 6 Challenges for each Level for example
        for (int i = 0; i <= lvlLibrary.getLevels().size() - 1; i++) {
            for (int j = 1; j < 7; j++) {
                lvlLibrary.getLevels().get(i).createChallenge("lvl " + (i + 1) + ":");
            }
        }

        updateLevelView();
    }

    //endregion

    //region Methoden


    // TODO: Methoden löschen?
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
        clearLevels();
        List<Level> levels = lvlLibrary.getLevels();
        for (Level level : levels) {
            addLevel(level.getLevelLabel(), level.getLevelState());
            //um das Layout anzuschauen, sollte mit button click kommen auf challange
            //if(level.getLevelState()==LevelState.open) {
            //    updateChallengeView(level);
            //}
        }
    }

    private void addLevelToLevelView(Level levelToAdd) {
        addLevel(levelToAdd.getLevelLabel(), levelToAdd.getLevelState());
    }

    private void updateChallengeView(Level level) {
        List<Challenge> challenges = level.getChallenges();
        for (Challenge challenge : challenges) {
            addChallenge(challenge.getTitle(), challenge.getDesc(), challenge.getChallengeState(), challenge.getLevelOfAnxiety());
        }
    }

    public void removeChallenges(){
        this.getChallBoaChallActiveLayout().removeAllComponents();
        this.getChallBoaChallActiveLayout().addComponent(this.getChallBoaActiveLabel());
        this.getChallBoaChallActiveLayout().setComponentAlignment(this.getChallBoaActiveLabel(), Alignment.TOP_CENTER);
        this.getChallBoaChallPassiveLayout().removeAllComponents();
        this.getChallBoaChallPassiveLayout().addComponent(this.getChallBoaPassivLabel());
        this.getChallBoaChallPassiveLayout().setComponentAlignment(getChallBoaPassivLabel(),Alignment.TOP_CENTER);
    }

    public void removeChallengeDetails(){
        this.getChallBoaChallDetailLayout().removeComponent(this.getDetails());
    }

    public void addChallengeDetails(Challenge challenge) {
        this.getDetails().setWidth("100%");
        final VerticalLayout content = new VerticalLayout();
        content.setWidth("100%");
        this.getDetails().setContent(content);
        this.getChallBoaChallDetailLayout().addComponent(this.getDetails());
        content.addComponent(new Label(challenge.getTitle().toUpperCase()));
        //content.addComponent(new Label(challenge.getDesc(), ContentMode.TEXT));
        content.addComponent(new Label(challenge.getChallengeState().toString()));
        String levelAnx = Integer.toString(challenge.getLevelOfAnxiety());
        content.addComponent(new Label("Level of Anxiety: "+levelAnx));
        Label Description = new Label(challenge.getDesc());
        Description.setWidth("100%");
        //Description.setHeight("100%");
        content.addComponent(Description);
        //content.setExpandRatio(Description,2);
        this.getDetails().setDescription("Challenge Details");

    }

    public void addChallenge(String title, String desc, ChallengeState challengeState, int levelOfAnxiety) {
        Panel challenge = new Panel(title);
        final VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.addComponent(new Label(desc));
        challenge.setContent(contentLayout);
        challenge.setHeight("100%");
        challenge.setWidth("100%");


        if (challengeState == challengeState.closed){
            this.getChallBoaChallPassiveLayout().addComponent(challenge);
            challenge.setEnabled(true);
            challenge.addStyleName("captionPassive");
            Button reOpen = new Button("reopen",this::reOpenClick);
            reOpen.setId("reOpen");
            contentLayout.addComponent(reOpen);
            Button details = new Button("Details",this::detailsClick);
        }

        if (challengeState == challengeState.open){
            this.getChallBoaChallActiveLayout().addComponent(challenge);
            challenge.setEnabled(true);
            challenge.addStyleName("captionActive");
            Button close = new Button("close",this::closeClick);
            close.setId("close");
            contentLayout.addComponent(close);
            Button details = new Button("Details",this::detailsClick);
            details.setId("details");
            contentLayout.addComponent(details);

        }
    }

    public void addLevel(String levelLabel, LevelState state) {
        Button level = new Button(levelLabel, this::AddLevelClick);
        level.setId("level");
        level.setWidth("100%");

        if (state == LevelState.closed) {
            level.setIcon(VaadinIcons.LOCK);
            level.setEnabled(false);
        }
        else{
            level.setIcon(VaadinIcons.UNLOCK);
        }

        // Getting index for new element
        int compCount = this.getChallBoaLevelLayout().getComponentCount() - 1;
        this.getChallBoaLevelLayout().addComponent(level, compCount);
    }

    public void setLevelInfoLabel(int closedCount, int neededToBeClosed, int allCount){
        Label newLabel = null;
        for (int i = this.getChallBoaLevelLayout().getComponentCount() - 1; i >= 0; i--) {
            Component comp = this.getChallBoaLevelLayout().getComponent(i);
            if (comp.getId().equals("lvlInfoLbl")){
                newLabel = (Label) comp;
            }
        }

        String labelText = closedCount + " of " + neededToBeClosed + ", Total: " + allCount;

        if (newLabel == null){
            newLabel = new Label("");
            newLabel.setId("lvlInfoLbl");
        }

        newLabel.setValue(labelText);
        this.getChallBoaLevelLayout().addComponent(newLabel, 1);
    }

    public void clearLevels(){
        for (int i = this.getChallBoaLevelLayout().getComponentCount() - 1; i >= 0; i--){
            Component comp = this.getChallBoaLevelLayout().getComponent(i);
            if (comp.getId().equals("level")) {
                this.getChallBoaLevelLayout().removeComponent(comp);
            }
        }
    }



    //endregion

    //region Events

    public void BackClick(Button.ClickEvent event) {
        UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
    }

    public void NewChallClick(Button.ClickEvent event) {
        newWindowAddChall();
    }

    public void AddLevelButtonClick(Button.ClickEvent event) {
        Level createdLevel = this.lvlLibrary.createNewLevel(LevelState.closed);
        this.addLevelToLevelView(createdLevel);
    }

    public void reOpenClick(Button.ClickEvent event) {
        findChallenge(event.getButton().getParent().getParent().getCaption()).setChallengeState(ChallengeState.open);
        removeChallenges();
        setLevelInfoLabel(currentLevel.getClosedChallengesCount(), currentLevel.getLevelDoneCount(), currentLevel.getChallenges().size());
        updateChallengeView(currentLevel);
    }

    public void detailsClick(Button.ClickEvent event) {
        removeChallengeDetails();
        addChallengeDetails(findChallenge(event.getButton().getParent().getParent().getCaption()));
    }

    public void closeClick(Button.ClickEvent event) {
        findChallenge(event.getButton().getParent().getParent().getCaption()).setChallengeState(ChallengeState.closed);
        removeChallenges();
        setLevelInfoLabel(currentLevel.getClosedChallengesCount(), currentLevel.getLevelDoneCount(), currentLevel.getChallenges().size());
        updateChallengeView(currentLevel);
    }

    public void AddLevelClick(Button.ClickEvent event) {
        currentLevel = findClickedLevel(event.getButton().getCaption());
        removeChallenges();

        if (currentLevel == null) {
            return;
        }

        setLevelInfoLabel(currentLevel.getClosedChallengesCount(), currentLevel.getLevelDoneCount(), currentLevel.getChallenges().size());
        updateChallengeView(currentLevel);

    }

    /*
    private List<ChallengeBoardViewListener> listeners;

    public void addListener(ChallengeBoardViewListener listener) {
        this.listeners.add(listener);
    }

    public void buttonClick(Button.ClickEvent event) {
        for (ChallengeBoardViewListener listener: this.listeners)
            listener.buttonClick(event.getButton());
    }
    */




    /*

    @Override
    public void buttonClick(Button clickedButton) {
        if (clickedButton.getId().equals("back")) {
            UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
        } else if (clickedButton.getId().equals("level")) {
            currentLevel = findClickedLevel(clickedButton.getCaption());
            removeChallenges();

            if (currentLevel == null) {
                return;
            }

            setLevelInfoLabel(currentLevel.getClosedChallengesCount(), currentLevel.getLevelDoneCount(), currentLevel.getChallenges().size());
            updateChallengeView(currentLevel);
        } else if (clickedButton.getId().equals("newChall")) {
            newWindowAddChall();
        } else if (clickedButton.getId().equals("close") || clickedButton.getId() == "reOpen") {
            if (clickedButton.getId().equals("close"))
                findChallenge(clickedButton.getParent().getParent().getCaption()).setChallengeState(ChallengeState.closed);
            else
                findChallenge(clickedButton.getParent().getParent().getCaption()).setChallengeState(ChallengeState.open);
            removeChallenges();
            setLevelInfoLabel(currentLevel.getClosedChallengesCount(), currentLevel.getLevelDoneCount(), currentLevel.getChallenges().size());
            updateChallengeView(currentLevel);
        } else if (clickedButton.getId().equals("AddLevelButton")) {
            Level createdLevel = this.lvlLibrary.createNewLevel(LevelState.closed);
            this.addLevelToLevelView(createdLevel);
        }
        else if (clickedButton.getId()=="details"){
            removeChallengeDetails();
            addChallengeDetails(findChallenge(clickedButton.getParent().getParent().getCaption()));
        }

    }
*/
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
        if (level.getLevelState()==LevelState.open) {
            removeChallenges();
            updateChallengeView(level);
        }
    }

    //endregion

}