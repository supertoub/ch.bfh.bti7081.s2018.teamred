package UserInterface;

import com.vaadin.ui.Button;

import java.text.ParseException;

public interface Journal {

    interface JournalViewListener {
        void buttonClick(String selectedDate, String cTitle, String cDesc) throws ParseException;
    }
    public void addListener(JournalViewListener listener);

}
