package Business;

import UserInterface.LoginViewPage;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginViewPagePresenter implements LoginViewPage.ChallengeBoardViewListener {
    @Override
    public void buttonClick(String buttonTitle) {
        // same Button was clicked before
        //check the login credentials given

    }

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

    private LoginViewPage loginview;

    private LoginViewPagePresenter() {
        loginview = new LoginViewPage();
        loginview.addListener(this);
        VerticalLayout LoginPageVerticalLayout = getLoginViewPage();


        loginview.addComponent(LoginPageVerticalLayout);

    }
}

