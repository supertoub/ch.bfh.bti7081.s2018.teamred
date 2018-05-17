package Business;

import UserInterface.LoginView;
import UserInterface.LoginViewPage;

public class LoginViewPagePresenter implements LoginView.ChallengeBoardViewListener {
    @Override
    public void buttonClick(String buttonTitle) {
        // same Button was clicked before
        //check the login credentials given
/*
        if(clickedLevel.getLevelLabel().equals(buttonTitle)){
            boardView.removeChallanges();
            clickedLevel=new Level("");
        }
        else{
            boardView.removeChallanges();
            clickedLevel = findClickedLevel(buttonTitle);
            updateChallengeView(clickedLevel);
        }*/
    }
    private LoginViewPage LoginView;
    public LoginViewPage getloginView() {
        return LoginView;
    }
    LoginView =
        LoginView.add(this);
    //implements singleton
    private static LoginViewPagePresenter instance;
    public static LoginViewPagePresenter getInstance() {
        if (instance == null) {
            instance = new LoginViewPagePresenter();
        }

        return instance;
    }
    private LoginViewPage loginview;
    private LoginViewPagePresenter(){
    loginview = new LoginViewPage();
    loginview.addComponent(LoginView.getComponent(getLoginViewLayout()));
    }
}

