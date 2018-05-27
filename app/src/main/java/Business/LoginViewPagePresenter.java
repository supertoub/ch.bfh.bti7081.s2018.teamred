package Business;

import UserInterface.ILoginView;
import UserInterface.LoginView;
import ch.bfh.MyUI;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

public class LoginViewPagePresenter implements ILoginView.LoginListener {

    //region Variablen

    //implements singleton
    private static LoginViewPagePresenter instance;

    private LoginView loginview;

    private List<ILoginView.LoginListener> listeners =
            new ArrayList<>();

    //endregion

    //region Getter

    public LoginView getLoginViewPage() {
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

    public void addListener(ILoginView.LoginListener listener) {
        listeners.add(listener);
    }

    //endregion

    //region Events

    public void buttonClick(String buttonTitle) {
        if(buttonTitle.equals("Login")) {
            UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
        }
    }


    //endregion

}

