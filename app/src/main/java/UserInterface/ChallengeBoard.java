package UserInterface;

public interface ChallengeBoard {

    interface ChallengeBoardViewListener {
        void buttonClick(char operation);
    }
    public void addListener(ChallengeBoardViewListener listener);

}
