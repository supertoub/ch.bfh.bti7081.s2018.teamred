package UserInterface;

import com.vaadin.ui.Button;

public interface IUI {

    interface IUIListener {
        void buttonClick(String buttonTitle);
        void JournalClick();
        void LogoutClick();
    }
    public void addListener(IUIListener listener);


}

