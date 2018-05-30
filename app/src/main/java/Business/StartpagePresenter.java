package Business;

import UserInterface.StartView;
import ch.bfh.MyUI;
import com.vaadin.ui.UI;

public class StartpagePresenter {

    //region Variablen

    private static StartpagePresenter instance;

    private StartView startView;

    //endregion

    //region Getter

    public StartView getStartView() {
        return startView;
    }

    public static StartpagePresenter getInstance() {
        if (instance == null) {
            instance = new StartpagePresenter();
        }

        return instance;
    }

    //endregion

    //region Kontruktoren

    private StartpagePresenter() {
        startView = new StartView();
    }

    //endregion

    //region Events

    public void buttonClick(String buttonTitle) {
        if(buttonTitle.equals("Challenges")){
            UI.getCurrent().getNavigator().navigateTo(MyUI.CHALLENGEVIEW);
        }
<<<<<<< HEAD

        else if (buttonTitle.equals("Journal")){
            UI.getCurrent().getNavigator().navigateTo(MyUI.JOURNALVIEW);
        }

=======
        else if (buttonTitle.equals("Journal")){
            UI.getCurrent().getNavigator().navigateTo(MyUI.JOURNALVIEW);
        }
>>>>>>> master
        else if (buttonTitle.equals("Logout")){
            UI.getCurrent().getNavigator().navigateTo(MyUI.LOGINVIEW);
        }
    }

    //endregion
}
