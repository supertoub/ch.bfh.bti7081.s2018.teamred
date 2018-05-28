package UserInterface;

import ch.bfh.MyUI;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

public class StartView extends StartViewPage implements View {

    public StartView () {
        super();
        journalButton.addClickListener(this::journalButtonClick);
        challangeButton.addClickListener(this::challangeButtonClick);
        logoutButton.addClickListener(this::logoutButtonClick);
    }

    public void challangeButtonClick(Button.ClickEvent event) {
        UI.getCurrent().getNavigator().navigateTo(MyUI.CHALLENGEVIEW);
    }

    public void journalButtonClick(Button.ClickEvent event) {
        UI.getCurrent().getNavigator().navigateTo(MyUI.JOURNALVIEW);
    }

    public void logoutButtonClick(Button.ClickEvent event) {
        UI.getCurrent().getNavigator().navigateTo(MyUI.LOGINVIEW);
    }
}
