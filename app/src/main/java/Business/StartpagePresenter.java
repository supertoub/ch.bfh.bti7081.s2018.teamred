package Business;

import UserInterface.IUI;
import UserInterface.NavigatorUI;
import UserInterface.StartpageView;
import ch.bfh.MyUI;
import com.vaadin.ui.UI;

;

public class StartpagePresenter implements IUI.IUIListener {
/*
    public void buttonClick() {
            ChallengesClick();
    }
*/
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
        StartView.addButtons();

    }

    @Override
    public void buttonClick(String buttonTitle) {
        if(buttonTitle.equals("Challenges")){
            UI.getCurrent().getNavigator().navigateTo(MyUI.CHALLENGEVIEW);
        }
    }

    @Override
    public void JournalClick() {

    }

    @Override
    public void LogoutClick() {

    }
}
