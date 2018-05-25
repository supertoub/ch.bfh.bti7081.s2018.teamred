package UserInterface;

import com.vaadin.data.Binder;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;


public class AddChallenge extends Window  implements ChallengeBoard{
    //region Variablen

    private TextField tfTitle;
    private TextArea tADesc;
    private ComboBox<String> select;
    private RadioButtonGroup<String> rbglOA;
    private Label counterTitle;
    private Label counterDesc;
    private Label selectL;
    private Binder<String> b;
    private String validate="";

    //endregion

    //region Getter
    //endregion

    //region Setter
    //endregion

    //region Konstruktoren

    public AddChallenge(List<String> lvls) {
        createWindow(lvls);
        createBinders();
        this.center();
    }


    //endregion

    //region Methoden
    private void createWindow(List<String> lvls){
        VerticalLayout subContent = new VerticalLayout();
        HorizontalLayout titleLayout = new HorizontalLayout();
        HorizontalLayout descLayout = new HorizontalLayout();

        createTextField();
        createTextArea();
        createComboBox(lvls);
        createRadioButton();

        setContent(subContent);
        subContent.addComponent(new Label("Add new challenge"));
        subContent.addComponent(select);
        subContent.addComponent(titleLayout);
        titleLayout.addComponent(tfTitle);
        titleLayout.addComponent(counterTitle);
        subContent.addComponent(descLayout);
        descLayout.addComponent(tADesc);
        descLayout.addComponent(counterDesc);
        subContent.addComponent(rbglOA);
        subContent.addComponent(new Button("Add Challenge", event -> buttonClick(event,select.getValue(),tfTitle.getValue(),tADesc.getValue(),Integer.valueOf(rbglOA.getSelectedItem().get()))));
        subContent.addComponent(new Button("Close", event -> close()));
        subContent.addComponent(selectL);

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
            int len = event.getValue().length();
            counterTitle.setValue(len + " of " + tfTitle.getMaxLength());
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
            int len = event.getValue().length();
            counterDesc.setValue(len + " of " + tADesc.getMaxLength());
        });
    }
    private void createComboBox(List<String> lvls) {
        selectL = new Label();
        // Create a selection component with some items
        select = new ComboBox<>("Select Level");
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
    }

    private void createBinders() {
        b = new Binder();
        b.forField(tfTitle)
                .withValidator(new StringLengthValidator("Must be between 1 and 20 characters long", 2, 20))
                .bind(s -> this.validate, (s, v) -> this.validate = v);
        b.forField(tADesc)
                .withValidator(new StringLengthValidator("Must be between 1 and 200 characters long", 2, 200))
                .bind(s -> this.validate, (s, v) -> this.validate = v);
    }


    private List<ChallengeBoardViewListener> listeners =
            new ArrayList<ChallengeBoardViewListener>();

    public void addListener(ChallengeBoardViewListener listener) {
        listeners.add(listener);
    }

    //endregion

    //region Events

    public void buttonClick(Button.ClickEvent event, String levelTitle, String cTitle, String cDesc, int lOfAx) {
        if(b.validate().hasErrors()){
            Notification.show("asdf",
                    cTitle,
                    Notification.Type.HUMANIZED_MESSAGE);
        }
        else{
            for (ChallengeBoardViewListener listener: listeners)
                listener.buttonClick(levelTitle,cTitle,cDesc,lOfAx);
            close();
            Notification.show("Add challenge to "+levelTitle,
                    cTitle,
                    Notification.Type.HUMANIZED_MESSAGE);
        }

    }
    //endregion

}
