package Business;

import UserInterface.*;
import ch.bfh.MyUI;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observer;


public class JournalLibraryPresenter extends JournalViewPage implements View {

    //region Variablen

    private static JournalLibraryPresenter instance;

    private JournalViewPage JournalViewPage;
    private JournalLibrary jourLibrary;
    private JournalLibrary currentEntry;
    private Panel Details;
    //endregion
    public Panel getDetails() {
        return Details;
    }

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

    public void addJournalEntry(Date Date, String title, String desc) {
        String stringDate = Date.toString();
        Panel journal = new Panel(stringDate);
        final VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.addComponent(new Label(title));
        contentLayout.addComponent(new Label(desc));
        journal.setContent(contentLayout);
        journal.setHeight("100%");
        journal.setWidth("100%");

        this.getJournalEntrysLayout().addComponent(journal);
        journal.setEnabled(true);
        journal.addStyleName("captionPassive");
        Button details = new Button("Details",this::detailsClick);
        details.setId("details");
        contentLayout.addComponent(details);
    }
    public void removeJournalDetails(){
        this.getJournalDetailsLayout().removeComponent(this.getDetails());
    }

    public void addJournalDetails(JournalEntry journal) {
        this.getDetails().setWidth("100%");
        final VerticalLayout content = new VerticalLayout();
        content.setWidth("100%");
        this.getDetails().setContent(content);
        this.getJournalDetailsLayout().addComponent(this.getDetails());
        content.addComponent(new Label(journal.getTitle().toUpperCase()));
        content.addComponent(new Label(journal.getDate().toString()));
        //content.addComponent(new Label(challenge.getDesc(), ContentMode.TEXT));
        //content.addComponent(new Label(challenge.getChallengeState().toString()));
        //String levelAnx = Integer.toString(challenge.getLevelOfAnxiety());
        //content.addComponent(new Label("Level of Anxiety: "+levelAnx));
        Label Description = new Label(journal.getDesc());
        Description.setWidth("100%");
        //Description.setHeight("100%");
        content.addComponent(Description);
        //content.setExpandRatio(Description,2);
        this.getDetails().setDescription("Journal Entry Details");

    }
    private void updateJournalView(Date date) {
        List<JournalEntry> entries = JournalLibrary.getJournalEntries();
        for (JournalEntry journalEntry : entries) {
            addJournalEntry(journalEntry.getDate(), journalEntry.getTitle(), journalEntry.getDesc());
        }
    }
    public void newWindowAddEntry() {
        List<String> entrys = new ArrayList<>();

        AddJournalEntry aJ = new AddJournalEntry(entrys);

        // Add it to the root component
        UI.getCurrent().addWindow(aJ);
    }
    private JournalEntry findJournalEntry(String panelName) {
       return currentEntry.getJournalEntries().getDate().equals(panelName);
       /* for (int i = 0; i < currentLevel.getChallenges().size(); i++) {
            if (currentLevel.getChallenges().get(i).getTitle().equals(panelName)) {
                return currentLevel.getChallenges().get(i);
            }
        }
        return null; //hier Exception machen falls es das challenge nicht findet */
    }
    public void detailsClick(Button.ClickEvent event) {
        removeJournalDetails();
        addJournalDetails(findJournalEntry(event.getButton().getParent().getParent().getCaption()));
    }

}
