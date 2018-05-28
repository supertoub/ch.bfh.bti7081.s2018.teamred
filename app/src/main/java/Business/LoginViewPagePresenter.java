package Business;

import UserInterface.LoginView;
import ch.bfh.MyUI;
import com.vaadin.ui.*;

public class LoginViewPagePresenter {

    //region Variablen

    //implements singleton
    private static LoginViewPagePresenter instance;

    private LoginView loginview;

    //endregion

    //region Getter

    public LoginView getLoginView() {
        return loginview;
    }

    public static LoginViewPagePresenter getInstance() {
        if (instance == null) {
            instance = new LoginViewPagePresenter();
        }
        return instance;
    }

    //endregion

    //region Konstruktoren

    private LoginViewPagePresenter() {
        loginview = new LoginView();
    }

    //endregion

    //region Methoden

    //endregion

    //region Events

    public void buttonClick(String buttonTitle) {
        if(buttonTitle.equals("Login")) {
            UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
        }
    }


    //endregion

}

