package Business;

import UserInterface.LoginView;

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

    //endregion

    //region Konstruktoren

    private LoginViewPagePresenter() {
        loginview = new LoginView();
    }

    //endregion

    //region Methoden

    public static LoginViewPagePresenter getInstance() {
        if (instance == null) {
            instance = new LoginViewPagePresenter();
        }
        return instance;
    }

    //endregion

    //region Events

    //endregion

}

