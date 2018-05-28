package UserInterface;

import com.vaadin.ui.Button;

public interface ChallengeBoard {

    interface ChallengeBoardViewListener {
        void buttonClick(Button button);
        void buttonClick(String levelTitle, String cTitle, String cDesc, int lOfAx) ;
    }
    void addListener(ChallengeBoardViewListener listener);

}
