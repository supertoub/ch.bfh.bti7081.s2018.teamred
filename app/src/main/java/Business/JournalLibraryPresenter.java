package Business;

import UserInterface.*;
import ch.bfh.MyUI;
import com.vaadin.event.ContextClickEvent;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class JournalLibraryPresenter extends JournalViewPage implements View, Journal.JournalViewListener {

    //region Variablen

    private static JournalLibraryPresenter instance;
    private JournalViewPage journalViewPage;
    private JournalLibrary jourLibrary;
    private JournalEntry currentEntry;
    private Panel Details;
    private LocalDate selectedDate;
    //endregion
    public Panel getDetails() {
        return Details;
    }

    public JournalViewPage getJournalView() {
        return journalViewPage;
    }

    public static JournalLibraryPresenter getInstance() {
        if (instance == null) {
            instance = new JournalLibraryPresenter();
        }

        return instance;
    }

    void deleteClick(Object sender){}



    private JournalLibraryPresenter() {
        super();
        this.jourLibrary = new JournalLibrary();

        Date today = java.sql.Date.valueOf(LocalDate.now());
        this.journalViewPage = new JournalViewPage();
        this.journalViewPage.getJournalDate().setValue(LocalDate.now());
        this.journalViewPage.getJournalDate().setDateFormat("yyyy-MM-dd");
        this.journalViewPage.getJournalDate().setLocale(new Locale("de", "DE"));
        this.journalViewPage.getJournalDate().addValueChangeListener(this::dateValueClick);
        this.journalViewPage.getJournalDate().addContextClickListener(this::dateChangeClick);
        backButton.addClickListener(this::backButtonClick);
        newEntryButton.addClickListener(this::newEntryButtonClick);
        updateJournalView(today);
        //JournalView.addListener(this);
        //JournalView.addButtons();
        //StartView.setHeight("100%");
        //StartView.setWidth("1000%");

    }

    public void dateChangeClick(ContextClickEvent event){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.updateJournalView(formatter.parse(this.journalViewPage.getJournalDate().getValue().toString()));
        }
        catch (Exception ex){
            return;
        }
    }


    public void dateValueClick(InlineDateField.ValueChangeEvent event){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.updateJournalView(formatter.parse(event.getValue().toString()));
        }
        catch (Exception ex){
            return;
        }
    }

    public void backButtonClick(Button.ClickEvent event) {
        if (UI.getCurrent() == null){
            return;
        }

        UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
    }

    public void newEntryButtonClick(Button.ClickEvent event) {
        newWindowAddEntry();
    }

    public void addJournalEntry(Date Date, String title, String desc) {
        Panel journal = new Panel(title);
        journal.setCaption(title);
        final VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.addComponent(new Label(Date.toString()));
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
        this.getDetails().setCaption(journal.getTitle());
        final VerticalLayout content = new VerticalLayout();
        content.setWidth("100%");
        this.getDetails().setContent(content);
        this.getJournalDetailsLayout().addComponent(this.getDetails());
        content.addComponent(new Label(journal.getTitle().toUpperCase()));
        content.addComponent(new Label(journal.getDate().toString()));
        Label Description = new Label(journal.getDesc());
        Description.setWidth("100%");
        content.addComponent(Description);
        this.getDetails().setDescription("Journal Entry Details");

    }

    private void updateJournalView(Date date) {
        //addJournalEntry(java.sql.Date.valueOf(LocalDate.now()), "Test", "test");

        int jourCount = this.getJournalEntrysLayout().getComponentCount();
        for (int i = --jourCount; i >= 0; i--){
            this.getJournalEntrysLayout().removeComponent(this.getJournalEntrysLayout().getComponent(i));
        }

        List<JournalEntry> entries = jourLibrary.getJournalEntries().stream().filter(x -> x.getDate().equals(date)).collect(Collectors.toList());
        for (JournalEntry journalEntry : entries) {
            addJournalEntry(journalEntry.getDate(), journalEntry.getTitle(), journalEntry.getDesc());
        }
    }

    public void newWindowAddEntry() {
        List<String> entrys = new ArrayList<>();

        AddJournalEntry aJ = new AddJournalEntry(entrys);
        aJ.addListener(this::buttonClick);

        if (UI.getCurrent() == null){
            return;
        }
        // Add it to the root component
        UI.getCurrent().addWindow(aJ);
    }

    private JournalEntry findJournalEntry(String entryString) {
        int jourCount = jourLibrary.getJournalEntries().size();
        for (int i = 0; i < jourCount; i++){
            if (jourLibrary.getJournalEntries().get(i).getTitle().equals(entryString)) {
                return jourLibrary.getJournalEntries().get(i);
            }

        }

        return null;
    }

    public void detailsClick(Button.ClickEvent event) {
            removeJournalDetails();
           // addJournalDetails(findJournalEntry(currentEntry.getTitle()));
            addJournalDetails(findJournalEntry(event.getButton().getParent().getParent().getCaption()));

    }

    @Override
    public void buttonClick(String selectedDate, String cTitle, String cDesc) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(selectedDate);
            jourLibrary.createJournalEntry(date, cTitle, cDesc);
            this.updateJournalView(formatter.parse(selectedDate));
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
