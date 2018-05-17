package Business;

import UserInterface.IUI;
import UserInterface.LoginViewPage;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;

public class LoginViewPagePresenter implements IUI.IUIListener {
    @Override
    public void buttonClick(String buttonTitle) {
        // same Button was clicked before
        //check the login credentials given

    }
    private LoginViewPage loginview;
    public LoginViewPage getLoginViewPage() {
        return loginview;
    }

    //implements singleton
    private static LoginViewPagePresenter instance;

    public static LoginViewPagePresenter getInstance() {
        if (instance == null) {
            instance = new LoginViewPagePresenter();
        }

        return instance;
    }


    private LoginViewPagePresenter() {
        loginview = new LoginViewPage();
        loginview.addListener((Component.Listener) this);
        VerticalLayout LoginPageVerticalLayout = getLoginViewPage();


        loginview.addComponent(LoginPageVerticalLayout);

    }

    @Override
    public void JournalClick() {

    }

    @Override
    public void LogoutClick() {

    }
}

