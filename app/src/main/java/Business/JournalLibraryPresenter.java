package Business;

import Data.JournalLibraryPersistence;
import Data.JournalPersistence;
import Data.PatientPersistence;
import UserInterface.*;
import ch.bfh.MyUI;
import com.vaadin.data.HasValue;
import com.vaadin.event.ContextClickEvent;
import com.vaadin.event.FieldEvents;
import com.vaadin.navigator.View;
import com.vaadin.shared.ui.datefield.AbstractDateFieldState;
import com.vaadin.ui.*;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;


public class JournalLibraryPresenter extends JournalViewPage implements View, Journal.JournalViewListener {

    //region Variablen
    private static final Logger logger = LogManager.getLogger(JournalLibraryPresenter.class);

    private static JournalLibraryPresenter instance;
    private JournalLibrary jourLibrary;

    //endregion

    //region Getter
    public static JournalLibraryPresenter getInstance() {
        if (instance == null) {
            instance = new JournalLibraryPresenter();
        }

        return instance;
    }
    //endregion

    //region Setter
    //endregion

    //region Konstruktoren
    private JournalLibraryPresenter() {
        super();
        // Get patient from session and fetch it from persistence
        Patient patient = PatientPersistence.getInstance().getByName(UI.getCurrent().getSession().getAttribute("user").toString());

        this.jourLibrary = JournalLibraryPersistence.getInstance().getById(patient.getJournalLibrary().getId());

        this.backButton.addClickListener(this::backButtonClick);
        this.newEntryButton.addClickListener(this::newEntryButtonClick);

        this.journalDate.setValue(LocalDate.now());
        this.journalDate.setLocale(new Locale("en", "UK"));
        this.journalDate.addValueChangeListener(this::dateValueChange);

        Date today = java.sql.Date.valueOf(LocalDate.now());

        updateJournalView(today);


    }
    //endregion

    //region Methoden


    public void addJournalEntry(Date Date, String title, String desc) {
        Panel journal = new Panel(title);
        journal.setCaption(title);
        final VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.addComponent(new Label(Date.toString()));
        contentLayout.addComponent(new Label(desc));
        journal.setContent(contentLayout);
        journal.setWidth("100%");

        this.journalEntrysLayout.addComponent(journal);
        journal.setEnabled(true);
        journal.addStyleName("captionPassive");
        Button details = new Button("Details", this::detailsClick);
        details.setId("details");
        contentLayout.addComponent(details);
    }


    public void addJournalDetails(JournalEntry journal) {
        this.details.setWidth("100%");
        this.details.setCaption(journal.getTitle());
        final VerticalLayout content = new VerticalLayout();
        content.setWidth("100%");
        this.details.setContent(content);
        this.journalDetailsLayout.addComponent(this.details);
        content.addComponent(new Label(journal.getTitle().toUpperCase()));
        content.addComponent(new Label(journal.getDate().toString()));
        Label Description = new Label(journal.getDesc());
        Description.setWidth("100%");
        content.addComponent(Description);
        this.details.setDescription("Journal Entry Details");

    }


    private void updateJournalView(Date date) {

        int jourCount = this.journalEntrysLayout.getComponentCount();
        for (int i = --jourCount; i >= 0; i--) {
            this.journalEntrysLayout.removeComponent(this.journalEntrysLayout.getComponent(i));
        }
        List<JournalEntry> entries = this.jourLibrary.getJournalEntries().stream().filter(x -> DateUtils.isSameDay(x.getDate(), date)).collect(Collectors.toList());
        for (JournalEntry journalEntry : entries) {
            addJournalEntry(journalEntry.getDate(), journalEntry.getTitle(), journalEntry.getDesc());
        }
    }

    public void newWindowAddEntry() {
        List<String> entrys = new ArrayList<>();

        AddJournalEntry aJ = new AddJournalEntry(entrys);
        aJ.addListener(this::buttonClick);

        if (UI.getCurrent() == null) {
            return;
        }
        // Add it to the root component
        UI.getCurrent().addWindow(aJ);
    }

    private JournalEntry findJournalEntry(String entryTitle) {
        try {
            for (int i = 0; i < jourLibrary.getJournalEntries().size(); i++) {
                if (jourLibrary.getJournalEntries().get(i).getTitle().equals(entryTitle)) {
                    return jourLibrary.getJournalEntries().get(i);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.print("findChallenge: too much challenges in list");
        } catch (NullPointerException e) {
            System.out.print("findChallenge: currentLevel cannot be null at this point");
        }
        return null;
    }
    //endregion

    //region Events
    public void detailsClick(Button.ClickEvent event) {
        addJournalDetails(findJournalEntry(event.getButton().getParent().getParent().getCaption()));
    }

    @Override
    public void buttonClick(String selectedDate, String cTitle, String cDesc) throws ParseException {
        //this event adds an new entry to JournalLibrary. It binds to the Add button in the new entry window
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(selectedDate);

            JournalEntry journalEntry = new JournalEntry(date, cTitle, cDesc, jourLibrary);
            JournalPersistence.getInstance().persist(journalEntry);
            JournalLibraryPersistence.getInstance().getEntityManager().refresh(jourLibrary);
            this.getJournalDate().setValue(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            this.updateJournalView(date);
        } catch (Exception ex) {
            throw ex;
        }
    }
    public void dateValueChange(HasValue.ValueChangeEvent<LocalDate> event) {
        //this event updates Journalview everytime a new Date get's clicked in Inline Date Field
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.updateJournalView(formatter.parse(event.getValue().toString()));
        } catch (Exception ex) {
            return;
        }
    }

    public void backButtonClick(Button.ClickEvent event) {
        if (UI.getCurrent() == null) {
            return;
        }

        UI.getCurrent().getNavigator().navigateTo(MyUI.STARTPAGEVIEW);
    }

    public void newEntryButtonClick(Button.ClickEvent event) {
        newWindowAddEntry();
    }
    void deleteClick(Object sender) {
    }
    //endregion
}