package UserInterface;

import ch.bfh.MyUI;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

public class StartView extends StartViewPage implements View {

    public StartView () {
        super();
        journalButton.addClickListener(this::journalButtonClick);
        challangeButton.addClickListener(this::challangeButtonClick);
        logoutButton.addClickListener(this::logoutButtonClick);
        welcomeLabel.setValue("Welcome " + VaadinSession.getCurrent().getAttribute("user") +", how are you feeling today?");
    }

    public void challangeButtonClick(Button.ClickEvent event) {
        UI.getCurrent().getNavigator().navigateTo(MyUI.CHALLENGEVIEW);
    }

    public void journalButtonClick(Button.ClickEvent event) {
        UI.getCurrent().getNavigator().navigateTo(MyUI.JOURNALVIEW);
    }

    public void logoutButtonClick(Button.ClickEvent event) {
        getUI().getNavigator().removeView(MyUI.STARTPAGEVIEW);
        getUI().getNavigator().removeView(MyUI.CHALLENGEVIEW);
        getUI().getNavigator().removeView(MyUI.JOURNALVIEW);
        UI.getCurrent().getNavigator().navigateTo(MyUI.LOGINVIEW);
    }
}
