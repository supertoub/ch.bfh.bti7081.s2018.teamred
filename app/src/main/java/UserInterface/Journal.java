package UserInterface;

import com.vaadin.ui.Button;

public interface Journal {

    interface JournalViewListener {
        void buttonClick(Button button);
        void buttonClick(String selectedDate, String cTitle, String cDesc) ;
    }
    public void addListener(JournalViewListener listener);

}
