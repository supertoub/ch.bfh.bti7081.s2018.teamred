package Business;

import UserInterface.*;
import ch.bfh.MyUI;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;


public class JournalLibraryPresenter extends JournalViewPage implements View {



    //region Variablen

    private static JournalLibraryPresenter instance;

    private JournalViewPage JournalViewPage;
    private JournalLibrary jourLibrary;
    private Journal currentEntry;

    //endregion



    public JournalViewPage getJournalView() {
        return JournalViewPage;
    }

    public static JournalLibraryPresenter getInstance() {
        if (instance == null) {
            instance = new JournalLibraryPresenter();
        }

        return instance;
    }
    void addClick(){}

    void deleteClick(Object sender){}

    void changeClick(){}

    private JournalLibraryPresenter() {
        super();
        JournalViewPage = new JournalViewPage();
        backButton.addClickListener(this::backButtonClick);
        newEntryButton.addClickListener(this::newEntryButtonClick);
        //JournalView.addListener(this);
        //JournalView.addButtons();
        //StartView.setHeight("100%");
        //StartView.setWidth("1000%");

    }

    public void backButtonClick(Button.ClickEvent event) {
        UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
    }

    public void newEntryButtonClick(Button.ClickEvent event) {
        newWindowAddEntry();
    }


    public void addJournalEntry(String title, String desc) {
        Panel journal = new Panel(title);
        final VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.addComponent(new Label(desc));
        journal.setContent(contentLayout);
        journal.setHeight("100%");
        journal.setWidth("100%");
    }
    public void newWindowAddEntry() {
        List<String> entrys = new ArrayList<>();

        AddJournalEntry aJ = new AddJournalEntry(entrys);

        // Add it to the root component
        UI.getCurrent().addWindow(aJ);
    }


}
