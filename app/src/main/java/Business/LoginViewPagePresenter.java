package Business;

import UserInterface.LoginView;

public class LoginViewPagePresenter implements LoginView.ChallengeBoardViewListener {
    @Override
    public void buttonClick(String buttonTitle) {
        // same Button was clicked before
        //check the login credentials given

        if(clickedLevel.getLevelLabel().equals(buttonTitle)){
            boardView.removeChallanges();
            clickedLevel=new Level("");
        }
        else{
            boardView.removeChallanges();
            clickedLevel = findClickedLevel(buttonTitle);
            updateChallengeView(clickedLevel);
        }
    }
}
