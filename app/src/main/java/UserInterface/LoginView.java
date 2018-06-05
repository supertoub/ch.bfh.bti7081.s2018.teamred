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
//
//    @PersistenceContext
//    private EntityManager entityManager;
//    @Test
//    public void genericDAOShouldSaveAChallengeEntity() throws Exception {
//        // Save a person
//        GenericDataFacade<Patient, String> patientDao = new GenericDataFacadeJPA<>(Patient.class);
//
//        patientDao.setEntityManager(entityManager);
//        Patient patient = new Patient("Roccaro", "Roland","Pass",null,null,null);
//        patient = patientDao.save(patient);
//        Patient anotherPatient = patientDao.get(patient.getName());
//    }

    private String username = "test";
    private String password = "test";

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
    public void LoginbuttonClick(Button.ClickEvent event) {
            if(authenticate(usernameField.getValue(), passwordField.getValue())){

           // if(this.authenticate(usernameField.getValue(), passwordField.getValue())){
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