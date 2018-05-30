package Business;

import UserInterface.AddJournalEntry;
import UserInterface.Journal;
import UserInterface.JournalView;
import ch.bfh.MyUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;


public class JournalLibraryPresenter implements Journal.JournalViewListener {



    //region Variablen

    private static JournalLibraryPresenter instance;

    private JournalView JournalView;
    private JournalLibrary jourLibrary;
    private Journal currentEntry;

    //endregion



    public JournalView getJournalView() {
        return JournalView;
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
        JournalView = new JournalView();
        JournalView.addListener(this);
        JournalView.addBackButton();
        //JournalView.addListener(this);
        //JournalView.addButtons();
        //StartView.setHeight("100%");
        //StartView.setWidth("1000%");

    }

    private void newWindowAddEntry() {
        List<String> entrys = new ArrayList<>();

        AddJournalEntry aJ = new AddJournalEntry(entrys);
        aJ.addListener(this);
        // Add it to the root component
        UI.getCurrent().addWindow(aJ);
    }
    @Override
    public void buttonClick(Button button) {
        if (button.getId().equals("back")) {
            UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
        }else if (button.getId().equals("newEntryButton")) {
            newWindowAddEntry();
        }
    }

    @Override
    public void buttonClick(String levelTitle, String cTitle, String cDesc, int lOfAx) {

    }
}
