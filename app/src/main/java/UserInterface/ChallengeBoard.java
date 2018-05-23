package UserInterface;

import com.vaadin.ui.Button;

public interface ChallengeBoard {

    interface ChallengeBoardViewListener {
        void buttonClick(Button button);
    }
    public void addListener(ChallengeBoardViewListener listener);

}
