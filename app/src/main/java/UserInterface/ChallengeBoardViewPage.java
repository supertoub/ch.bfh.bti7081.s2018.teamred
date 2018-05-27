package UserInterface;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Label;

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
public class ChallengeBoardViewPage extends HorizontalLayout {
    protected VerticalLayout challBoaLevelLayout;
    protected Label challBoaLevelLabel;
    protected VerticalLayout challBoaChallActiveLayout;
    protected Label challBoaActiveLabel;
    protected VerticalLayout challBoaChallPassiveLayout;
    protected Label challBoaPassivLabel;
    protected VerticalLayout challBoaChallDetailLayout;
    protected Label challBoaChallDetailsLabel;

    public ChallengeBoardViewPage() {
        Design.read(this);
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