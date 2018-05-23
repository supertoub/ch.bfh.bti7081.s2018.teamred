package UserInterface;

import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;


public class AddChallenge extends Window  implements ChallengeBoard{
    private TextField tfTitle;
    private TextArea tADesc;
    private ComboBox<String> select;
    private RadioButtonGroup<String> rbglOA;

    public AddChallenge(List<String> lvls) {
        VerticalLayout subContent = new VerticalLayout();
        HorizontalLayout titleLayout = new HorizontalLayout();
        HorizontalLayout descLayout = new HorizontalLayout();
        tfTitle = new TextField();
        tfTitle.setPlaceholder("Title");
        tfTitle.setMaxLength(15);

        // Counter for input length
        Label counterTitle = new Label();
        counterTitle.setValue(tfTitle.getValue().length() +
                " of " + tfTitle.getMaxLength());

        // Display the current length interactively in the counter
        tfTitle.addValueChangeListener(event -> {
            int len = event.getValue().length();
            counterTitle.setValue(len + " of " + tfTitle.getMaxLength());
        });

        tfTitle.setValueChangeMode(ValueChangeMode.EAGER);
        tADesc = new TextArea();
        tADesc.setPlaceholder("Description");
        tADesc.setMaxLength(200);
        tADesc.setValueChangeMode(ValueChangeMode.EAGER);

        // Counter for input length
        Label counterDesc = new Label();
        counterDesc.setValue(tADesc.getValue().length() +
                " of " + tADesc.getMaxLength());
        // Display the current length interactively in the counter
        tADesc.addValueChangeListener(event -> {
            int len = event.getValue().length();
            counterDesc.setValue(len + " of " + tADesc.getMaxLength());
        });

        Label selectL = new Label();
        // Create a selection component with some items
         select = new ComboBox<>("Select Level");
        select.setItems(lvls);
       // Handle selection event
        select.addSelectionListener(event ->
                selectL.setValue(("Selected " +
                        event.getSelectedItem().orElse("none"))));
        rbglOA =
                new RadioButtonGroup<>("Level of Anxiety");
        rbglOA.setItems("1", "2", "3","4","5");
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

        this.center();

    }

    private List<ChallengeBoardViewListener> listeners =
            new ArrayList<ChallengeBoardViewListener>();

    public void addListener(ChallengeBoardViewListener listener) {
        listeners.add(listener);
    }


    public void buttonClick(Button.ClickEvent event, String levelTitle, String cTitle, String cDesc, int lOfAx) {
        for (ChallengeBoardViewListener listener: listeners)
            listener.buttonClick(levelTitle,cTitle,cDesc,lOfAx);
        close();
        Notification.show("Add challenge to "+levelTitle,
                cTitle,
                Notification.Type.HUMANIZED_MESSAGE);

    }
}
