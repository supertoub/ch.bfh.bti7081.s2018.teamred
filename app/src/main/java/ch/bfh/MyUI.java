package ch.bfh;

import javax.servlet.annotation.WebServlet;

import UserInterface.ChallangeBoardView;
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
       /* final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue()
                    + ", it works!"));
        });

        layout.addComponents(name, button);
        */
       ChallangeBoardView cbv = new ChallangeBoardView();
        Panel activeP = new Panel("1. Active Challenge");
        activeP.setContent(new Label("blablabla"));
        activeP.setSizeFull();
        Panel activeP2 = new Panel("2. Active Challenge");
        activeP2.setContent(new Label("blablabla"));
        activeP2.setSizeFull();
        Panel passiveP = new Panel("1. Passive Challenge");
        passiveP.setContent(new Label("blablablaBlubberrr"));
        cbv.getChallBoaChallActiveLayout().addComponent(activeP);
        cbv.getChallBoaChallActiveLayout().setComponentAlignment(activeP,Alignment.TOP_LEFT);
        cbv.getChallBoaChallActiveLayout().addComponent(activeP2);
        cbv.getChallBoaChallPassiveLayout().addComponent(passiveP);
        cbv.getChallBoaChallPassiveLayout().setComponentAlignment(passiveP,Alignment.TOP_CENTER);
        setContent(cbv);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
