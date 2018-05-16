package UserInterface;

import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.declarative.Design;

public class LoginView {
    private VerticalLayout LoginViewLayout;
    private Label usernameLabel;
    private Label pwdLabel;
    private Label returnMessageLabel;
    private TextField usernameTextField;
    private TextField pwdTextField;
    private TextField returnMessageTextField;
    private Button LoginButton;
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

    //public LoginView() {
    //    Design.read(this);
    //}
    public VerticalLayout getLoginViewLayout() {
        return LoginViewLayout;
    }



}
