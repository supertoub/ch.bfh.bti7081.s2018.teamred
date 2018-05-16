package UserInterface;


import com.vaadin.ui.Button;

public interface IUI {

    interface IUIListener {
        void ChallengesClick();
        void JournalClick();
        void LogoutClick();
    }
        public void addListener(IUIListener listener);


}

