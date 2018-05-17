package UserInterface;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.VerticalLayout;

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
public class LoginViewPage extends VerticalLayout implements ChallengeBoard {

    public LoginViewPage() {
        Design.read(this);
    }

    // TODO: Disscuss how to implement listeners
    private List<ChallengeBoard.ChallengeBoardViewListener> listeners =
            new ArrayList<ChallengeBoard.ChallengeBoardViewListener>();

    public void addListener(ChallengeBoard.ChallengeBoardViewListener listener) {
        listeners.add(listener);
    }

    public void buttonClick(Button.ClickEvent event) {
        for (ChallengeBoard.ChallengeBoardViewListener listener: listeners)
            listener.buttonClick(event.getButton().getCaption());
    }

    private VerticalLayout LoginViewPageLayout;
    private Label usernameLabel = new Label("Username");
    private Label pwdLabel= new Label("Password");
    private Label returnMessageLabel= new Label("ReturnMessage");
    private TextField usernameTextField = new TextField("Enter your Username");
    private TextField pwdTextField = new TextField("Enter your Password");
    private TextField returnMessageTextField = new TextField("Reply from Login");
    private Button LoginButton = new Button("Login");
    public Label getusernameLabel() {
        return usernameLabel;
    }
    public Label getpwdLabel() {
        return pwdLabel;
    }
    public Label getreturnMessageLabel() { return usernameLabel; }
    public TextField getusernameTextField() { return usernameTextField; }
    public TextField getpwdTextField() { return pwdTextField; }
    public TextField getreturnMessageTextField() { return returnMessageTextField; }
    public Button getLoginButton() { return LoginButton; }


    public VerticalLayout getLoginViewPageLayout() {
        return LoginViewPageLayout;
    }
}
