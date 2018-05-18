package UserInterface;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import java.util.ArrayList;

public class NavigatorUI extends UI {

    Navigator navigator;
    protected static final String MAINVIEW = "main";

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Navigation Example");

        // Create a navigator to control the views
        navigator = new Navigator(this, this);

        // Create and register the views


        navigator.addView("", new StartpageView());

        //navigator.addView("", new StartView());


        navigator.addView("", new StartpageView());
        //navigator.addView("", new StartView());
        navigator.addView(MAINVIEW, new StartpageView());
        navigator.addView("ChallengeBoardView", new ChallengeBoardView());
    }

}