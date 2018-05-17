package ch.bfh;

import javax.servlet.annotation.WebServlet;

import Business.ChallengeBoardPresenter;

import Business.JournalLibraryPresenter;
import Business.StartpagePresenter;

import Business.LoginViewPagePresenter;

import UserInterface.ChallengeBoardView;
import UserInterface.NavigatorUI;
import UserInterface.StartpageView;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

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
   //public static final String LOGINVIEW ="Logout";

    @Override
    protected void init(VaadinRequest request) {

        ChallengeBoardPresenter presenter2 = ChallengeBoardPresenter.getInstance();
        StartpagePresenter presenter = StartpagePresenter.getInstance();
        //JournalLibraryPresenter presenter3 = JournalLibraryPresenter.getInstance();
        //LoginViewPagePresenter presenter4 = LoginViewPagePresenter.getInstance();
        setContent(presenter.getStartView());
        //ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(presenter.getStartView());
        //navigator = new Navigator(UI.getCurrent(), presenter.getStartView());
        navigator = new Navigator(this, this);
        navigator.addView(STARTPAGEVIEW, presenter.getStartView());
        navigator.addView(CHALLENGEVIEW, presenter2.getBoardView());
        //navigator.addView(JOURNALVIEW, presenter3.getJournalView());
        //navigator.addView(LOGINVIEW, presenter4.getLoginViewPage());

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
