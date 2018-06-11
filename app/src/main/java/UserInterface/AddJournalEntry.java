package UserInterface;

import com.vaadin.server.Page;
import com.vaadin.server.UserError;
import com.vaadin.shared.Position;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class AddJournalEntry extends Window  implements Journal{
    //region Variablen

    private TextField tfTitle;
    private InlineDateField idfDate;
    private TextArea tADesc;
    private Label counterTitle;
    private Label counterDesc;
    private int lenTitle;
    private int lenDesc;
    private String selectedDate;
    //endregion

    //region Getter
    //endregion

    //region Setter
    //endregion

    //region Konstruktoren

    public AddJournalEntry(List<String> lvls) {
        createWindow(lvls);
        this.center();
    }


    //endregion

    //region Methoden
    private void createWindow(List<String> lvls){
        VerticalLayout subContent = new VerticalLayout();
        HorizontalLayout titleLayout = new HorizontalLayout();
        HorizontalLayout descLayout = new HorizontalLayout();

        createInlineDateField();
        createTextField();
        createTextArea();


        setContent(subContent);
        subContent.addComponent(new Label("Add new Journal entry"));

        subContent.addComponent(titleLayout);
        titleLayout.addComponent(tfTitle);
        titleLayout.addComponent(counterTitle);
        subContent.addComponent(descLayout);
        descLayout.addComponent(tADesc);
        descLayout.addComponent(counterDesc);
        subContent.addComponent(idfDate);
        subContent.addComponent(new Button("Add Entry", event -> buttonClick(event, selectedDate, tfTitle.getValue(),tADesc.getValue())));
        subContent.addComponent(new Button("Close", event -> close()));


    }

    private void createInlineDateField() {
        idfDate = new InlineDateField();
        idfDate.setValue(LocalDate.now());
        idfDate.setLocale(new Locale("de", "DE"));
        idfDate.addValueChangeListener(event -> selectedDate = (event.getValue().toString()));
    }

    private void createTextField() {
        tfTitle = new TextField();
        counterTitle = new Label();
        tfTitle.setPlaceholder("Title");
        tfTitle.setMaxLength(15);
        // Counter for input length
        counterTitle.setValue(tfTitle.getValue().length() +
                " of " + tfTitle.getMaxLength());
        // Display the current length interactively in the counter
        tfTitle.addValueChangeListener(event -> {
            lenTitle = event.getValue().length();
            counterTitle.setValue(lenTitle + " of " + tfTitle.getMaxLength());
        });
        tfTitle.setValueChangeMode(ValueChangeMode.EAGER);
    }

    private void createTextArea(){
        tADesc = new TextArea();
        counterDesc = new Label();
        tADesc.setPlaceholder("Description");
        tADesc.setMaxLength(200);
        tADesc.setValueChangeMode(ValueChangeMode.EAGER);
        // Counter for input length
        counterDesc = new Label();
        counterDesc.setValue(tADesc.getValue().length() +
                " of " + tADesc.getMaxLength());
        // Display the current length interactively in the counter
        tADesc.addValueChangeListener(event -> {
            lenDesc = event.getValue().length();
            counterDesc.setValue(lenDesc + " of " + tADesc.getMaxLength());
        });
    }
    private List<JournalViewListener> listeners =
            new ArrayList<>();

    public void addListener(JournalViewListener listener) {
        listeners.add(listener);
    }
    private void createNotification(String mainMessage, String subMessage, Notification.Type notificationType, int ms) {
        Notification notif = new Notification(mainMessage,subMessage,notificationType);
        notif.setDelayMsec(ms);
        notif.setPosition(Position.MIDDLE_CENTER);
        notif.show(Page.getCurrent());
    }

    //endregion

    //region Events

    public void buttonClick(Button.ClickEvent event, String selectedDate, String cTitle, String cDesc) {


        tfTitle.setComponentError(null);
        tADesc.setComponentError(null);

         if (cTitle == null || lenTitle < 1){
            createNotification("No Title Entered","please add title",Notification.Type.ERROR_MESSAGE, 2000);
            tfTitle.setComponentError(new UserError("No Title Entered"));
        }
        else if (cDesc == null || lenDesc < 1){
            createNotification("No Description Entered","please add description",Notification.Type.ERROR_MESSAGE, 2000);
            tADesc.setComponentError(new UserError("No Title Entered"));
        }
        else{
            createNotification("Add Journal entry to "+selectedDate,cTitle,Notification.Type.HUMANIZED_MESSAGE, 1500);
            for (JournalViewListener listener: listeners)
                listener.buttonClick(selectedDate,cTitle,cDesc);
            close();
        }

    }




    //endregion

}
