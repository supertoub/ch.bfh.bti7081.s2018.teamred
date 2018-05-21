package ch.bfh;

import javax.servlet.annotation.WebServlet;

import Business.ChallengeBoardPresenter;


import Business.StartpagePresenter;

import Business.LoginViewPagePresenter;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    public Navigator navigator;

    public static final String STARTPAGEVIEW = "Start";
    public static final String CHALLENGEVIEW = "Challenge";
   // public static final String JOURNALVIEW ="Journal";
    public static final String LOGINVIEW ="Logout";

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Social Anxiety APP");
        navigator = new Navigator(this, this);
        ChallengeBoardPresenter presenter2 = ChallengeBoardPresenter.getInstance();
        StartpagePresenter presenter = StartpagePresenter.getInstance();
        //JournalLibraryPresenter presenter3 = JournalLibraryPresenter.getInstance();
        LoginViewPagePresenter presenter4 = LoginViewPagePresenter.getInstance();
      //  setContent(presenter4.getLoginViewPage());
        //ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(presenter.getStartView());
        //navigator = new Navigator(UI.getCurrent(), presenter.getStartView());
        navigator.addView(STARTPAGEVIEW, presenter.getStartView());
        navigator.addView(CHALLENGEVIEW, presenter2.getBoardView());
        //navigator.addView(JOURNALVIEW, presenter3.getJournalView());
        navigator.addView(LOGINVIEW, presenter4.getLoginViewPage());
        navigator.navigateTo(CHALLENGEVIEW);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    /*
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
    */
}
