package Business;

import UserInterface.IUI;
import UserInterface.StartpageView;
import com.vaadin.ui.UI;

;

public class StartpagePresenter implements IUI.IUIListener {
    public void buttonClick() {
            ChallengesClick();

    }
    private static StartpagePresenter instance;
    private StartpageView StartView;

    public StartpageView getStartView() {
        return StartView;
    }

    public static StartpagePresenter getInstance() {
        if (instance == null) {
            instance = new StartpagePresenter();
        }

        return instance;
    }
    private StartpagePresenter() {
        StartView = new StartpageView();
        StartView.addListener(this);

    }
    @Override
    public void ChallengesClick() {
        UI.getCurrent().getNavigator().navigateTo("ChallengeBoardView)");
    }

    @Override
    public void JournalClick() {

    }

    @Override
    public void LogoutClick() {

    }
}
