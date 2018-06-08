package Business;

import UserInterface.AddChallenge;
import UserInterface.ChangeChallenge;
import UserInterface.ChallengeBoard;
import UserInterface.ChallengeBoardView;
import ch.bfh.MyUI;
import com.vaadin.event.LayoutEvents;
import com.vaadin.event.MouseEvents;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;
import com.vaadin.navigator.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class ChallengeBoardPresenter extends ChallengeBoardView implements Observer, View, ChallengeBoard.ChallengeBoardViewListener {

    //region Variablen

    private static ChallengeBoardPresenter instance;

    //private ChallengeBoardViewPage boardView;

    private LevelLibrary lvlLibrary;

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
        getBack().addClickListener(this::backClick);
        getNewChall().addClickListener(this::newChallClick);
        getAddLevelButton().addClickListener(this::addLevelButtonClick);

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
                //lvlLibrary.getLevels().get(i).createChallenge("lvl " + (i + 1) + ":");
                lvlLibrary.getLevels().get(i).createChallenge("" + (i + 1));
            }
        }
        updateLevelView();
    }

    //endregion

    //region Methoden

    private void newWindowAddChall() {

        try {
            List<String> lvls = new ArrayList<>();
            for (int i = 0; i < lvlLibrary.getLevels().size(); i++) {
                lvls.add(lvlLibrary.getLevels().get(i).getLevelLabel());
            }

            AddChallenge aC = new AddChallenge(lvls);

            aC.addListener(this);
            // Add it to the root component
            UI.getCurrent().addWindow(aC);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("newWindowAddChall: too much levels in list");
            this.createNotification("For the moment you cannot create new Challenges",
                    "please try again", Notification.Type.ERROR_MESSAGE, 1500);
        } catch (NullPointerException e) {
            System.out.print("newWindowAddChall: lvlLibrary cannot be null at this point");
            this.createNotification("For the moment you cannot create new Challenges",
                    "please try again", Notification.Type.ERROR_MESSAGE, 1500);
        }
    }

    private void newWindowChangeChall(Challenge challenge) {

        List<String> lvls = new ArrayList<>();
        try {
            for (int i = 0; i < lvlLibrary.getLevels().size(); i++) {
                lvls.add(lvlLibrary.getLevels().get(i).getLevelLabel());
            }

            ChangeChallenge cC = new ChangeChallenge(lvls, challenge);

            cC.addListener(this);
            // Add it to the root component
            UI.getCurrent().addWindow(cC);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("newWindowAddChall: too much levels in list");
            this.createNotification("For the moment you cannot create new Challenges",
                    "please try again", Notification.Type.ERROR_MESSAGE, 1500);
        } catch (NullPointerException e) {
            System.out.print("newWindowAddChall: lvlLibrary cannot be null at this point");
            this.createNotification("For the moment you cannot create new Challenges",
                    "please try again", Notification.Type.ERROR_MESSAGE, 1500);
        }

    }

    // TODO: Event in Level handeln
    private Level findClickedLevel(String buttonTitle) {
        try {
            for (int i = 0; i <= lvlLibrary.getLevels().size(); i++) {
                if (lvlLibrary.getLevels().get(i).getLevelLabel().equals(buttonTitle)) {
                    return lvlLibrary.getLevels().get(i);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.print("findClickLevel: too much levels in list");
        } catch (NullPointerException e) {
            System.out.print("findClickLevel: lvlLibrary cannot be null at this point");
        }

        return null;
    }

    // TODO: Event in Challange handeln
    private Challenge findChallenge(String panelName) {
        try {
            for (int i = 0; i < currentLevel.getChallenges().size(); i++) {
                if (currentLevel.getChallenges().get(i).getTitle().equals(panelName)) {
                    return currentLevel.getChallenges().get(i);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.print("findChallenge: too much challenges in list");
        } catch (NullPointerException e) {
            System.out.print("findChallenge: currentLevel cannot be null at this point");
        }
        return null;
    }

    // TODO: Challenge Liste dem ChangeChallenge übergeben, damit der Titel nicht zweimal vorkommt
    private List<Challenge> ChallengeLibrary() {
        return null;
    }

    private void updateLevelView() {
        clearLevels();
        try {
            List<Level> levels = lvlLibrary.getLevels();
            for (Level level : levels) {
                addLevel(level.getLevelLabel(), level.getLevelState());
            }
        } catch (NullPointerException e) {
            System.out.print("findClickLevel: lvlLibrary cannot be null at this point");
        }

    }

    private void addLevelToLevelView(Level levelToAdd) {
        try {
            addLevel(levelToAdd.getLevelLabel(), levelToAdd.getLevelState());
        } catch (NullPointerException e) {
            System.out.print("addLevelToLevelView: level cannot be null at this point");
        }
    }

    private void updateChallengeView(Level level) {
        try {
            List<Challenge> challenges = level.getChallenges();
            for (Challenge challenge : challenges) {
                addChallenge(challenge.getTitle(), challenge.getDesc(), challenge.getChallengeState(), challenge.getLevelOfAnxiety());
            }
        } catch (NullPointerException e) {
            System.out.print("updateChallengeView: level cannot be null at this point");
        }

    }

    public void removeChallenges() {
        this.getChallBoaChallActiveLayout().removeAllComponents();
        this.getChallBoaChallActiveLayout().addComponent(this.getChallBoaActiveLabel());
        this.getChallBoaChallActiveLayout().setComponentAlignment(this.getChallBoaActiveLabel(), Alignment.TOP_CENTER);
        this.getChallBoaChallPassiveLayout().removeAllComponents();
        this.getChallBoaChallPassiveLayout().addComponent(this.getChallBoaPassivLabel());
        this.getChallBoaChallPassiveLayout().setComponentAlignment(getChallBoaPassivLabel(), Alignment.TOP_CENTER);
    }

    public void removeChallengeDetails() {
        this.getChallBoaChallDetailLayout().removeComponent(this.getDetails());
    }

    public void addChallengeDetails(Challenge challenge) {
        ChallengeState challengeState = challenge.getChallengeState();
        this.getDetails().setCaption(challenge.getTitle());
        this.getDetails().setWidth("100%");
        final VerticalLayout content = new VerticalLayout();
        final HorizontalLayout buttons = new HorizontalLayout();
        content.setWidth("100%");
        this.getDetails().setContent(content);
        this.getChallBoaChallDetailLayout().addComponent(this.getDetails());
        //content.addComponent(new Label(challenge.getTitle().toUpperCase()));
        //content.addComponent(new Label(challenge.getDesc(), ContentMode.TEXT));
        content.addComponent(new Label("State: " + challenge.getChallengeState().toString()));
        String levelAnx = Integer.toString(challenge.getLevelOfAnxiety());
        content.addComponent(new Label("Level of Anxiety: " + levelAnx));
        Label Description = new Label(challenge.getDesc());
        Description.setWidth("100%");
        //Description.setHeight("100%");
        content.addComponent(Description);
        //content.setExpandRatio(Description,2);
        this.getDetails().setDescription("Challenge Details");

        Button changeChallenge = new Button("", this::changeChallenge);
        changeChallenge.setIcon(VaadinIcons.EDIT);
        buttons.addComponent(changeChallenge);

        if (challengeState == challengeState.closed) {
            Button reOpen = new Button("reopen", this::reOpenClick);
            //content.addComponent(reOpen);
            buttons.addComponent(reOpen);

        }

        if (challengeState == challengeState.open) {
            Button close = new Button("close", this::closeClick);
            //content.addComponent(close);
            buttons.addComponent(close);

        }

        Button deleteChallenge = new Button("", this::deleteChallenge);
        deleteChallenge.setIcon(VaadinIcons.TRASH);
        buttons.addComponent(deleteChallenge);
        content.addComponent(buttons);

    }

    public void addChallenge(String title, String desc, ChallengeState challengeState, int levelOfAnxiety) {
        Panel challenge = new Panel(title);
        challenge.addClickListener(e -> challengeClick1(e));
        final VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.addLayoutClickListener(e -> challengeClick(e));
        //contentLayout.addComponent(new Label(desc.substring(0,27)+"..."));
        contentLayout.setWidth("100%");
        contentLayout.setHeight("100%");
        challenge.setContent(contentLayout);
        challenge.setHeight("100%");
        challenge.setWidth("100%");


        if (challengeState == challengeState.closed) {
            this.getChallBoaChallPassiveLayout().addComponent(challenge);
            challenge.setEnabled(true);
            challenge.setIcon(VaadinIcons.CLIPBOARD.CLIPBOARD_CHECK);
            challenge.addStyleName("captionPassive");
            contentLayout.addComponent(new Label("Good job!"));
            //Button reOpen = new Button("reopen", this::reOpenClick);
            //contentLayout.addComponent(reOpen);
            //Button details = new Button("Details",this::detailsClick);
            //details.setId("details");
            //contentLayout.addComponent(details);

        }

        if (challengeState == challengeState.open) {
            this.getChallBoaChallActiveLayout().addComponent(challenge);
            challenge.setEnabled(true);
            challenge.setIcon(VaadinIcons.CLIPBOARD.CLIPBOARD_TEXT);
            challenge.addStyleName("captionActive");
            contentLayout.addComponent(new Label("You can do it!"));
            //Button close = new Button("close", this::closeClick);
            //contentLayout.addComponent(close);
            //Button details = new Button("Details",this::detailsClick);
            //details.setId("details");
            //contentLayout.addComponent(details);

        }
    }

    public void addLevel(String levelLabel, LevelState state) {
        Button level = new Button(levelLabel, this::addLevelClick);
        level.setId("level");
        level.setWidth("100%");

        if (state == LevelState.closed) {
            level.setIcon(VaadinIcons.LOCK);
            level.setEnabled(false);
        } else {
            level.setIcon(VaadinIcons.UNLOCK);
        }

        // Getting index for new element
        int compCount = this.getChallBoaLevelLayout().getComponentCount() - 1;
        this.getChallBoaLevelLayout().addComponent(level, compCount);
    }

    public void setLevelInfoLabel(int closedCount, int neededToBeClosed, int allCount) {
        Label newLabel = null;
        for (int i = this.getChallBoaLevelLayout().getComponentCount() - 1; i >= 0; i--) {
            Component comp = this.getChallBoaLevelLayout().getComponent(i);
            if (comp.getId().equals("lvlInfoLbl")) {
                newLabel = (Label) comp;
            }
        }

        String labelText = closedCount + " of " + neededToBeClosed + ", Total: " + allCount;

        if (newLabel == null) {
            newLabel = new Label("");
            newLabel.setId("lvlInfoLbl");
        }

        newLabel.setValue(labelText);
        this.getChallBoaLevelLayout().addComponent(newLabel, 1);
    }

    public void clearLevels() {
        try {
            for (int i = this.getChallBoaLevelLayout().getComponentCount() - 1; i >= 0; i--) {
                Component comp = this.getChallBoaLevelLayout().getComponent(i);
                if (comp.getId().equals("level")) {
                    this.getChallBoaLevelLayout().removeComponent(comp);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.print("findChallenge: too much challenges in list");
        }
    }

    //endregion

    //region Events

    public void backClick(Button.ClickEvent event) {
        UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
    }

    public void newChallClick(Button.ClickEvent event) {
        newWindowAddChall();
    }

    public void addLevelButtonClick(Button.ClickEvent event) {
        Level createdLevel = this.lvlLibrary.createNewLevel(LevelState.closed);
        this.addLevelToLevelView(createdLevel);
    }

    public void reOpenClick(Button.ClickEvent event) {
        try {

            findChallenge(event.getButton().getParent().getParent().getCaption()).setChallengeState(ChallengeState.open);
        } catch (NullPointerException e) {
            System.out.print("detailsClick: Could not find challenge");
        }

        removeChallenges();
        try {
            setLevelInfoLabel(currentLevel.getClosedChallengesCount(), currentLevel.getLevelDoneCount(), currentLevel.getChallenges().size());
            updateChallengeView(currentLevel);
        } catch (NullPointerException e) {
            System.out.print("reOpenClick: Level cannot be null at this point");
        }

    }

    public void detailsClick(Button.ClickEvent event) {
        removeChallengeDetails();
        try {
            addChallengeDetails(findChallenge(event.getButton().getParent().getParent().getCaption()));
        } catch (NullPointerException e) {
            System.out.print("detailsClick: Could not find challenge");
        }
    }

    public void closeClick(Button.ClickEvent event) {
        findChallenge(event.getButton().getParent().getParent().getParent().getCaption()).setChallengeState(ChallengeState.closed);
        removeChallenges();
        try {
            setLevelInfoLabel(currentLevel.getClosedChallengesCount(), currentLevel.getLevelDoneCount(), currentLevel.getChallenges().size());
            updateChallengeView(currentLevel);
        } catch (NullPointerException e) {
            System.out.print("closeClick: currentLevel cannot be null at this point");
        }
    }

    public void addLevelClick(Button.ClickEvent event) {
        currentLevel = findClickedLevel(event.getButton().getCaption());
        removeChallenges();
        try {
            setLevelInfoLabel(currentLevel.getClosedChallengesCount(), currentLevel.getLevelDoneCount(), currentLevel.getChallenges().size());
            updateChallengeView(currentLevel);
        } catch (NullPointerException e) {
            System.out.print("AddLevelClick: currentLevel cannot be null at this point");
            this.createNotification("We could not add a new level",
                    "please try again", Notification.Type.ERROR_MESSAGE, 1500);
        }

    }

    public void challengeClick(LayoutEvents.LayoutClickEvent event) {
        removeChallengeDetails();

        try {
            addChallengeDetails(findChallenge(event.getComponent().getParent().getCaption()));
        } catch (NullPointerException e) {
            System.out.print("challengeClick: could not find Challenge");
            this.createNotification("We cannot show your challenge",
                    "please try again", Notification.Type.ERROR_MESSAGE, 1500);
        }
    }

    public void challengeClick1(MouseEvents.ClickEvent event) {
        removeChallengeDetails();
        try {
            addChallengeDetails(findChallenge(event.getComponent().getCaption()));
        } catch (NullPointerException e) {
            System.out.print("challengeClick: could not find Challenge");
            this.createNotification("We could not change your challenge",
                    "please try again", Notification.Type.ERROR_MESSAGE, 1500);
        }
    }

    public void changeChallenge(Button.ClickEvent event) {
        try {
            newWindowChangeChall(findChallenge(event.getButton().getParent().getParent().getParent().getCaption()));
        } catch (NullPointerException e) {
            System.out.print("challengeClick: could not find Challenge");
            this.createNotification("We could not change your challenge",
                    "please try again", Notification.Type.ERROR_MESSAGE, 1500);
        }
    }
    @Override
    public void update(java.util.Observable o, Object arg) {
        if (o instanceof LevelLibrary) {
            this.updateLevelView();
        }
    }

    @Override
    public void newChallenge(String levelTitle, String cTitle, String cDesc, int lOfAx) {
        Level level = findClickedLevel(levelTitle);

        try {
            level.createChallenge(levelTitle, cTitle, cDesc, lOfAx);
            if (level.getLevelState() == LevelState.open) {
                removeChallenges();
                updateChallengeView(level);
            }
        } catch (NullPointerException e) {
            System.out.print("Add Challenge: Level cannot be null at this point");
            this.createNotification("We could not save your challenge",
                    "please try again", Notification.Type.ERROR_MESSAGE, 1500);
        }
    }

    @Override
    public void changeChallengeClick(String cTitleOld, String cTitle, String cDesc, int lOfAx) {
        try {
            findChallenge(cTitleOld).setTitle(cTitle);
            findChallenge(cTitle).setDesc(cDesc);
            findChallenge(cTitle).setLevelOfAnxiety(lOfAx);
            removeChallenges();
            updateChallengeView(currentLevel);
            removeChallengeDetails();
            addChallengeDetails(findChallenge(cTitle));
        } catch (NullPointerException e) {
            System.out.print("Add Challenge: Level cannot be null at this point");
            this.createNotification("We could not save your challenge",
                    "please try again", Notification.Type.ERROR_MESSAGE, 1500);
        }

    }
    public void deleteChallenge(Button.ClickEvent event) {
        try {
            findChallenge(event.getButton().getParent().getParent().getCaption());
            for (int i = 0; i <= lvlLibrary.getLevels().size() - 1; i++) {
                for (int j = 1; j < 7; j++) {
                    lvlLibrary.getLevels().get(i).deleteChallenge(findChallenge(event.getButton().getParent().getParent().getParent().getCaption()));
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.print("deleteChallenge: too much levels in list");
            this.createNotification("We could delete your challengel",
                    "please try again", Notification.Type.ERROR_MESSAGE, 1500);
        } catch (NullPointerException e) {
            System.out.print("deleteChallenge: Level or lvlLibrary cannot be null at this point");
            this.createNotification("We could delete your challenge",
                    "please try again", Notification.Type.ERROR_MESSAGE, 1500);
        }
        removeChallenges();
        updateChallengeView(currentLevel);
        removeChallengeDetails();

    }


}
//endregion


