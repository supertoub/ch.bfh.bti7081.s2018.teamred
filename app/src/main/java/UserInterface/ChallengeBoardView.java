package UserInterface;

import Business.LevelState;
import Business.ChallengeState;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Label;

import java.util.ArrayList;
import java.util.List;

/**
 * !! DO NOT EDIT THIS FILE !!
 * <p>
 * This class is generated by Vaadin Designer and will be overwritten.
 * <p>
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class ChallengeBoardView extends HorizontalLayout implements ChallengeBoard, View {
    private VerticalLayout challBoaLevelLayout;
    private Label challBoaLevelLabel;
    private VerticalLayout challBoaChallActiveLayout;
    private Label challBoaActiveLabel;
    private VerticalLayout challBoaChallPassiveLayout;
    private Label challBoaPassivLabel;
    private VerticalLayout challBoaChallDetailLayout;
    private Label challBoaChallDetailsLabel;

    private List<ChallengeBoardViewListener> listeners = new ArrayList<>();

    public void addListener(ChallengeBoardViewListener listener) {
        listeners.add(listener);
    }


    public void buttonClick(Button.ClickEvent event) {
        for (ChallengeBoardViewListener listener: listeners)
            listener.buttonClick(event.getButton());
    }

    public ChallengeBoardView() {
        Design.read(this);
    }

    public void addBackButton(){
        Button back = new Button("Back", this::buttonClick);
        back.setId("back");
        back.setWidth("100%");
        challBoaChallDetailLayout.addComponent(back);
    }

    public void addLevel(String levelLabel, LevelState state) {
        Button level = new Button(levelLabel, this::buttonClick);
        level.setId("level");
        level.setWidth("100%");
        if (state == LevelState.closed){
            level.setEnabled(false);
        }

        this.challBoaLevelLayout.addComponent(level);
    }



    public void addChallenge(String title, String desc, ChallengeState challengeState, int levelOfAnxiety) {
        Panel challenge = new Panel(title);
        final VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.addComponent(new Label(desc));
        challenge.setContent(contentLayout);
        challenge.setHeight("100%");
        challenge.setWidth("100%");


        if (challengeState == challengeState.closed){
            this.challBoaChallPassiveLayout.addComponent(challenge);
            challenge.setEnabled(true);
            challenge.addStyleName("captionPassive");
            Button reOpen = new Button("reopen",this::buttonClick);
            reOpen.setId("reOpen");
            contentLayout.addComponent(reOpen);

        }

        if (challengeState == challengeState.open){
            this.challBoaChallActiveLayout.addComponent(challenge);
            challenge.setEnabled(true);
            challenge.addStyleName("captionActive");
            Button close = new Button("close",this::buttonClick);
            close.setId("close");
            contentLayout.addComponent(close);

        }
    }
    public void removeChallenges(){
        this.challBoaChallActiveLayout.removeAllComponents();
        this.challBoaChallActiveLayout.addComponent(challBoaActiveLabel);
        this.challBoaChallActiveLayout.setComponentAlignment(challBoaActiveLabel,Alignment.TOP_CENTER);
        this.challBoaChallPassiveLayout.removeAllComponents();
        this.challBoaChallPassiveLayout.addComponent(challBoaPassivLabel);
        this.challBoaChallPassiveLayout.setComponentAlignment(challBoaPassivLabel,Alignment.TOP_CENTER);
    }

    public VerticalLayout getChallBoaLevelLayout() {
        return challBoaLevelLayout;
    }

    public Label getChallBoaLevelLabel() {
        return challBoaLevelLabel;
    }

    public VerticalLayout getChallBoaChallActiveLayout() {
        return challBoaChallActiveLayout;
    }

    public Label getChallBoaActiveLabel() {
        return challBoaActiveLabel;
    }

    public VerticalLayout getChallBoaChallPassiveLayout() {
        return challBoaChallPassiveLayout;
    }

    public Label getChallBoaPassivLabel() {
        return challBoaPassivLabel;
    }

    public VerticalLayout getChallBoaChallDetailLayout() {
        return challBoaChallDetailLayout;
    }

    public Label getChallBoaChallDetailsLabel() {
        return challBoaChallDetailsLabel;
    }


}
