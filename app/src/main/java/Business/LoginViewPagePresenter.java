package Business;

import UserInterface.ChallengeBoard;
import UserInterface.ILoginView;
import UserInterface.IUI;
import UserInterface.LoginViewPage;
import ch.bfh.MyUI;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

public class LoginViewPagePresenter implements ILoginView.LoginListener {

    public void buttonClick(Button button) {
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
        loginview.addLoginComponents();
    }

    public void buttonClick(String buttonTitle) {
        if(buttonTitle.equals("Login")) {
            UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
        }
    }

    private List<ILoginView.LoginListener> listeners =
            new ArrayList<ILoginView.LoginListener>();

    public void addListener(ILoginView.LoginListener listener) {
        listeners.add(listener);
    }

}

