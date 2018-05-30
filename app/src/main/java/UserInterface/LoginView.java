package UserInterface;

import ch.bfh.MyUI;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

public class LoginView extends LoginViewPage implements View {

    public LoginView () {
        super();
        loginButton.addClickListener(this::loginButtonClick);
    }

    public void loginButtonClick(Button.ClickEvent event) {
        UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
    }
}