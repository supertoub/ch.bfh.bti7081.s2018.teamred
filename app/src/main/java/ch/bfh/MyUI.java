package ch.bfh;

import javax.servlet.annotation.WebServlet;

import Business.ChallengeBoardPresenter;
<<<<<<< HEAD
import Business.StartpagePresenter;
=======
import Business.LoginViewPagePresenter;
>>>>>>> origin/Roland_Login
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
<<<<<<< HEAD
        StartpagePresenter presenter = StartpagePresenter.getInstance();
        setContent(presenter.getStartView());
=======
        //ChallengeBoardPresenter presenter = ChallengeBoardPresenter.getInstance();
        //setContent(presenter.getBoardView());

        LoginViewPagePresenter presenter = LoginViewPagePresenter.getInstance();
        setContent(presenter.getloginView());

>>>>>>> origin/Roland_Login
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
