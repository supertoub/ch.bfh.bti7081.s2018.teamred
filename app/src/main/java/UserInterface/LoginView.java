package UserInterface;

import Business.ChallengeBoardPresenter;
import Business.JournalLibraryPresenter;
import Business.StartpagePresenter;
import Data.PatientPersistence;
import ch.bfh.MyUI;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

public class LoginView extends LoginViewPage implements View {

    public LoginView () {
        super();
        loginButton.addClickListener(this::LoginbuttonClick);
    }
        /*
    based on Login Example:
    source: https://examples.javacodegeeks.com/enterprise-java/vaadin/vaadin-login-example/
     */
    
    public Boolean authenticate(String username, String password){
       Patient patient = PatientPersistence.getInstance().getByName(username);

       if(password.equals(patient.getPwd())){
           return true;
        } else {
            return false;
        }
    }

    public void LoginbuttonClick(Button.ClickEvent event) {
            if(authenticate(usernameField.getValue(), passwordField.getValue())){
                VaadinSession.getCurrent().setAttribute("user", usernameField.getValue());

                StartpagePresenter startpagePresenter = StartpagePresenter.getInstance();
                ChallengeBoardPresenter challengeBoardPresenter = ChallengeBoardPresenter.getInstance();
                JournalLibraryPresenter journalPresenter = JournalLibraryPresenter.getInstance();

                getUI().getNavigator().addView(MyUI.STARTPAGEVIEW, startpagePresenter.getStartView());
                getUI().getNavigator().addView(MyUI.CHALLENGEVIEW, challengeBoardPresenter);
                getUI().getNavigator().addView(MyUI.JOURNALVIEW, journalPresenter);

                UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
            }else{
                Notification.show("Invalid credentials", Notification.Type.ERROR_MESSAGE);
            }
    }
}
