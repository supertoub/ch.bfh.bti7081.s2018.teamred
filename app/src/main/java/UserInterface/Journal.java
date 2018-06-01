package UserInterface;

import com.vaadin.ui.Button;

public interface Journal {

    interface JournalViewListener {
        void buttonClick(Button button);
        void buttonClick(String levelTitle, String cTitle, String cDesc, int lOfAx) ;
    }
    public void addListener(JournalViewListener listener);

}
