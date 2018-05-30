package UserInterface;

import com.vaadin.data.Binder;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Page;
import com.vaadin.server.UserError;
import com.vaadin.shared.Position;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;


public class AddJournalEntry extends Window  implements Journal{
    //region Variablen

    private TextField tfTitle;
    private InlineDateField idfDate;
    private TextArea tADesc;
    private ComboBox<String> select;
    private RadioButtonGroup<String> rbglOA;
    private Label counterTitle;
    private Label counterDesc;
    private Label selectL;
    private int lenTitle;
    private int lenDesc;
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
        createComboBox(lvls);
        createRadioButton();

        setContent(subContent);
        subContent.addComponent(new Label("Add new Journal entry"));
        subContent.addComponent(select);
        subContent.addComponent(titleLayout);
        titleLayout.addComponent(tfTitle);
        titleLayout.addComponent(counterTitle);
        subContent.addComponent(descLayout);
        descLayout.addComponent(tADesc);
        descLayout.addComponent(counterDesc);
        subContent.addComponent(rbglOA);
        subContent.addComponent(new Button("Add Entry", event -> buttonClick(event,select.getValue(),tfTitle.getValue(),tADesc.getValue(),Integer.valueOf(rbglOA.getSelectedItem().get()))));
        subContent.addComponent(new Button("Close", event -> close()));
        subContent.addComponent(selectL);

    }

    private void createInlineDateField() {
        idfDate = new InlineDateField();

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
    private void createComboBox(List<String> lvls) {
        selectL = new Label();
        // Create a selection component with some items
        select = new ComboBox<>("Select Level");
        select.setEmptySelectionAllowed(false);
        select.setItems(lvls);
        // Handle selection event
        select.addSelectionListener(event ->
                selectL.setValue(("Selected " +
                        event.getSelectedItem().orElse("none"))));
    }

    private void createRadioButton(){
        rbglOA =
                new RadioButtonGroup<>("Level of Anxiety");
        rbglOA.setItems("1", "2", "3","4","5");
        rbglOA.setSelectedItem("1");
    }

    private void createNotification(String mainMessage, String subMessage, Notification.Type notificationType, int ms) {
        Notification notif = new Notification(mainMessage,subMessage,notificationType);
        notif.setDelayMsec(ms);
        notif.setPosition(Position.MIDDLE_CENTER);
        notif.show(Page.getCurrent());
    }


    private List<JournalViewListener> listeners =
            new ArrayList<>();

    public void addListener(JournalViewListener listener) {
        listeners.add(listener);
    }

    //endregion

    //region Events

    public void buttonClick(Button.ClickEvent event, String levelTitle, String cTitle, String cDesc, int lOfAx) {

        select.setComponentError(null);
        tfTitle.setComponentError(null);
        tADesc.setComponentError(null);

        if(levelTitle == null){
            createNotification("No Level Chosen","please select a level",Notification.Type.ERROR_MESSAGE, 2000);
            select.setComponentError(new UserError("No Level Chosen"));
        }
        else if (cTitle == null || lenTitle < 1){
            createNotification("No Title Entered","please add title",Notification.Type.ERROR_MESSAGE, 2000);
            tfTitle.setComponentError(new UserError("No Title Entered"));
        }
        else if (cDesc == null || lenDesc < 1){
            createNotification("No Description Entered","please add description",Notification.Type.ERROR_MESSAGE, 2000);
            tADesc.setComponentError(new UserError("No Title Entered"));
        }
        else{
            createNotification("Add challenge to "+levelTitle,cTitle,Notification.Type.HUMANIZED_MESSAGE, 1500);
            for (JournalViewListener listener: listeners)
                listener.buttonClick(levelTitle,cTitle,cDesc,lOfAx);
            close();
        }

    }




    //endregion

}
