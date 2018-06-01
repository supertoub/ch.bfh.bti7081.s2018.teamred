package UserInterface;

import ch.bfh.MyUI;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import Business.*;

public class LoginView extends LoginViewPage implements View {

    public LoginView () {
        super();
        loginButton.addClickListener(this::LoginbuttonClick);
    }
/*
    public void LoginButtonClick(Button.ClickEvent event) {
       UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
    }*/
        /*
    based on Login Example:
    source: https://examples.javacodegeeks.com/enterprise-java/vaadin/vaadin-login-example/
     */


    private String username = "testTest";
    private String password = "testTest";

    private void setUsername(String username) {
        this.username = username;
    }

    private String getUsername(){
        return this.username;
    }


    private void setPassword(String password) {
        this.password = password;
    }
    private String getPassword(){
        return this.password;
    }

    public Boolean authenticate(String username, String password){
        if(username.equals(getUsername()) && password.equals(getPassword())){
            return true;
        }else{
            return false;

        }
    }

    public void LoginbuttonClick(Button.ClickEvent event) {

            if(authenticate(usernameField.getValue(), passwordField.getValue())){
                //LoginView.AUTH.authenticate(usernameField.getValue(), passwordField.getValue())
                //VaadinSession.getCurrent().setAttribute("user", username.getValue());
                //getUI().getNavigator().addView(SecurePage.NAME, SecurePage.class);
                //getUI().getNavigator().addView(OtherSecurePage.NAME, OtherSecurePage.class);
                //Page.getCurrent().setUriFragment("!"+SecurePage.NAME);
                UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
            }else{
                Notification.show("Invalid credentials", Notification.Type.ERROR_MESSAGE);
            }
    }



}