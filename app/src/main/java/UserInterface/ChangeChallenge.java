package UserInterface;

import Business.Challenge;
import com.vaadin.server.Page;
import com.vaadin.server.UserError;
import com.vaadin.shared.Position;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;


public class ChangeChallenge extends Window  implements ChallengeBoard{
    //region Variablen

    private TextField tfTitle;
    private TextArea tADesc;
    //private ComboBox<String> select;
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

    public ChangeChallenge(List<String> lvls, Challenge challenge) {
        createWindow(lvls,challenge);
        this.center();
    }


    //endregion

    //region Methoden
    private void createWindow(List<String> lvls,Challenge challenge){
        VerticalLayout subContent = new VerticalLayout();
        HorizontalLayout titleLayout = new HorizontalLayout();
        HorizontalLayout descLayout = new HorizontalLayout();

        createTextField(challenge.getTitle());
        createTextArea(challenge.getDesc());
        //createComboBox(lvls);
        createRadioButton(challenge.getLevelOfAnxiety());

        setContent(subContent);
        subContent.addComponent(new Label("Change Challenge"));
        //subContent.addComponent(select);
        subContent.addComponent(titleLayout);
        titleLayout.addComponent(tfTitle);
        titleLayout.addComponent(counterTitle);
        subContent.addComponent(descLayout);
        descLayout.addComponent(tADesc);
        descLayout.addComponent(counterDesc);
        subContent.addComponent(rbglOA);
        subContent.addComponent(new Button("Save", event -> changeChallengeClick(event, String.valueOf(challenge.getId()), challenge.getTitle(),tfTitle.getValue(),tADesc.getValue(),Integer.valueOf(rbglOA.getSelectedItem().get()))));
        subContent.addComponent(new Button("Close", event -> close()));
        //subContent.addComponent(selectL);

    }

    private void createTextField(String title) {
        tfTitle = new TextField();
        tfTitle.setValue(title);
        counterTitle = new Label();
        //tfTitle.setPlaceholder("Title");
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

    private void createTextArea(String Desc){
        tADesc = new TextArea();
        tADesc.setValue(Desc);
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
    /*
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
*/
    private void createRadioButton(Integer levelOfAnxiety){
        rbglOA =
                new RadioButtonGroup<>("Level of Anxiety");
        rbglOA.setItems("1", "2", "3","4","5");
        rbglOA.setSelectedItem(levelOfAnxiety.toString());
    }

    private void createNotification(String mainMessage, String subMessage, Notification.Type notificationType, int ms) {
        Notification notif = new Notification(mainMessage,subMessage,notificationType);
        notif.setDelayMsec(ms);
        notif.setPosition(Position.MIDDLE_CENTER);
        notif.show(Page.getCurrent());
    }


    private List<ChallengeBoardViewListener> listeners =
            new ArrayList<ChallengeBoardViewListener>();

    public void addListener(ChallengeBoardViewListener listener) {
        listeners.add(listener);
    }

    //endregion

    //region Events

    public void changeChallengeClick(Button.ClickEvent event, String cId,String cTitleOld,String cTitle, String cDesc, int lOfAx) {

        //select.setComponentError(null);
        tfTitle.setComponentError(null);
        tADesc.setComponentError(null);
        /*
        if(levelTitle == null){
            createNotification("No Level Chosen","please select a level",Notification.Type.ERROR_MESSAGE, 2000);
            select.setComponentError(new UserError("No Level Chosen"));
        }
        */
        // TODO: elseif Abfrage erstellen, die überprüft ob es den Titel schon mal gibt
        if (cTitle == null || cTitle.length()==0){
            createNotification("No Title Entered","please add title",Notification.Type.ERROR_MESSAGE, 2000);
            tfTitle.setComponentError(new UserError("No Title Entered"));
        }
        else if (cDesc == null || cDesc.length()==0){
            createNotification("No Description Entered","please add description",Notification.Type.ERROR_MESSAGE, 2000);
            tADesc.setComponentError(new UserError("No Title Entered"));
        }
        else{
            createNotification("Changes saved",cTitle,Notification.Type.HUMANIZED_MESSAGE, 1500);
            for (ChallengeBoardViewListener listener: listeners)
                listener.changeChallengeClick(cId, cTitleOld,cTitle,cDesc,lOfAx);
            close();
        }

    }
    //endregion

}