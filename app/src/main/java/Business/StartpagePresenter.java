package Business;

import UserInterface.StartView;
import ch.bfh.MyUI;
import com.vaadin.ui.Notification;
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
        try {
            if (buttonTitle.equals("Challenges")) {
                UI.getCurrent().getNavigator().navigateTo(MyUI.CHALLENGEVIEW);
            } else if (buttonTitle.equals("Journal")) {
                UI.getCurrent().getNavigator().navigateTo(MyUI.JOURNALVIEW);
            }
        }
        catch (NullPointerException e) {
            System.out.print("The requestet page does not existe: " + buttonTitle);
            Notification.show("Are you logged in?", "please login again", Notification.Type.ERROR_MESSAGE);

        }
    }

    //endregion
}
