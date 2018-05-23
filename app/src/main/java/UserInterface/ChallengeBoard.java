package UserInterface;

import com.vaadin.ui.Button;

public interface ChallengeBoard {

    interface ChallengeBoardViewListener {
        void buttonClick(String buttonTitle);
        void buttonClick(Button button);
        void buttonClick(String levelTitle, String cTitle, String cDesc, int lOfAx) ;
    }
<<<<<<< HEAD
    public void addListener(ChallengeBoardViewListener listener);
=======

    void addListener(ChallengeBoardViewListener listener);

>>>>>>> master
}
