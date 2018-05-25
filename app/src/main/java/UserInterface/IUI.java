package UserInterface;

public interface IUI {

    interface IUIListener {
        void buttonClick(String buttonTitle);
        void JournalClick();
        void LogoutClick();
    }

    void addListener(IUIListener listener);

}

