package UserInterface;

public interface ChallengeBoard {

    interface ChallengeBoardViewListener {
        void newChallenge(String levelTitle, String cTitle, String cDesc, int lOfAx) ;
    }
}