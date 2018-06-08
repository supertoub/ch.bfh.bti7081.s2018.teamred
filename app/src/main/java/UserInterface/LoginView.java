package UserInterface;

import Business.ChallengeBoardPresenter;
import Business.JournalLibraryPresenter;
import Business.StartpagePresenter;
import ch.bfh.MyUI;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import static ch.bfh.MyUI.CHALLENGEVIEW;

public class LoginView extends LoginViewPage implements View {

    public LoginView () {
        super();
        loginButton.addClickListener(this::LoginbuttonClick);
    }
        /*
    based on Login Example:
    source: https://examples.javacodegeeks.com/enterprise-java/vaadin/vaadin-login-example/
     */
   // private Patient TestPatient = new Patient("RoccaroR","Roccaro","Roland","SavePW_1","","","");

    private String username = "RoccaroR";
    private String password = "SavePW_1";

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
        return username.equals(getUsername()) && password.equals(getPassword());
    }


/* TODO, reuse this code to do the login using DB
    public Boolean authenticate(String username, String password){
      GenericDataFacade<Patient, String> userDao = new GenericDataFacadeJPA<>(Patient.class);
      String DBpassword = userDao.get(username).getPwd();

       if(password.equals(DBpassword)){

        //if(true){
            return true;
        }else{
            return false;

        }
    }
*/
    //TODO: method to get name/surname of username

    public void LoginbuttonClick(Button.ClickEvent event) {
            if(authenticate(usernameField.getValue(), passwordField.getValue())){
                VaadinSession.getCurrent().setAttribute("user", usernameField.getValue());

                StartpagePresenter startpagePresenter = StartpagePresenter.getInstance();
                ChallengeBoardPresenter challangeBoardPresenter = ChallengeBoardPresenter.getInstance();
                JournalLibraryPresenter journalPresenter = JournalLibraryPresenter.getInstance();

                getUI().getNavigator().addView(MyUI.STARTPAGEVIEW, startpagePresenter.getStartView());
                getUI().getNavigator().addView(MyUI.CHALLENGEVIEW, challangeBoardPresenter);
                getUI().getNavigator().addView(MyUI.JOURNALVIEW, journalPresenter);

                UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
            }else{
                Notification.show("Invalid credentials", Notification.Type.ERROR_MESSAGE);
            }
    }



}