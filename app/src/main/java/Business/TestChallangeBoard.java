package Business;

import Data.ChallengePersistence;
import Data.LevelPersistence;
import UserInterface.ChallengeBoard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestChallangeBoard {

    //region Challange
    // TODO: Rewrite tests with persistence methods
    /*@Test
    public void createChallenge(){
        ChallengeBoardPresenter presenter = ChallengeBoardPresenter.getInstance();
        Challenge currentChallenge = new Challenge("", "Test", ChallengeState.open, 1, presenter);
        currentChallenge = new Challenge("Test", "", ChallengeState.open, 1, presenter);
        currentChallenge = new Challenge("Test", "Test", ChallengeState.open, 2147483647, presenter);
        currentChallenge = new Challenge("Test", "Test", ChallengeState.open, -2147483647, presenter);
    }*/

    /*@Test
    public void setChallengeState(){
        ChallengeBoardPresenter presenter = ChallengeBoardPresenter.getInstance();
        Challenge currentChallenge = new Challenge("Title", "Description", ChallengeState.closed, 1, presenter);
        currentChallenge.setChallengeState(ChallengeState.open);
        assert currentChallenge.getChallengeState() == ChallengeState.open;

        currentChallenge.setChallengeState(ChallengeState.open);
        assert currentChallenge.getChallengeState() == ChallengeState.open;
    }*/

    //endregion

    //region ChallangeBoardPresenter

    /*@Test
    public void challengeHandling(){
        ChallengeBoardPresenter presenter = ChallengeBoardPresenter.getInstance();
        presenter.removeChallenges();
        presenter.removeChallengeDetails();
        presenter.clearLevels();

        presenter.addLevel("", LevelState.open);
        presenter.addLevel("Test", LevelState.open);
        // Crazy
        presenter.addLevel("<script>alet('test');</script>", LevelState.open);

        presenter.setLevelInfoLabel(1, 1, 1);
        presenter.setLevelInfoLabel(2147483647, 1, 1);
        presenter.setLevelInfoLabel(1, 2147483647, 1);
        presenter.setLevelInfoLabel(1, 1, 2147483647);
        presenter.setLevelInfoLabel(2147483647, 2147483647, 2147483647);

        Challenge currentChallenge = new Challenge("", "Test", ChallengeState.open, 1, presenter);
        presenter.addChallengeDetails(currentChallenge);
        currentChallenge = new Challenge("Test", "", ChallengeState.open, 1, presenter);
        presenter.addChallengeDetails(currentChallenge);
        currentChallenge = new Challenge("Test", "Test", ChallengeState.open, 2147483647, presenter);
        presenter.addChallengeDetails(currentChallenge);

        presenter.addChallenge("", "Test", ChallengeState.open, 1);
        presenter.addChallenge("Test", "", ChallengeState.open, 1);
        presenter.addChallenge("Test", "Test", ChallengeState.open, 1);
        presenter.addChallenge("Test", "Test", ChallengeState.open, 2147483647);

        presenter.removeChallengeDetails();
        presenter.removeChallenges();
        presenter.clearLevels();
    }*/

    //endregion

    //region LevelLibrary Level

    @Test
    public void levelHandling(){
        List<Level> levels = new ArrayList<>();
        LevelLibrary lib = new LevelLibrary(levels,ChallengeBoardPresenter.getInstance());
        /*lib.createNewLevel(LevelState.open);
        lib.createNewLevel();*/

        //assert lib.getLevels().size() == 3;

        Level currentLevel = new Level("Test", 1, lib, lib);
        LevelPersistence.getInstance().persist(currentLevel);
        Challenge currentChallenge = new Challenge("blablabla", "blablabla", ChallengeState.open, currentLevel, 1);
        ChallengePersistence.getInstance().persist(currentChallenge);


        /*currentLevel.createChallenge("blablabla");
        currentLevel.createChallenge("");
        currentLevel.createChallenge("blablabla", "blablabla", "blabla", 1);
        currentLevel.createChallenge("", "blablabla", "blabla", 1);
        currentLevel.createChallenge("Test", "", "blabla", 1);
        currentLevel.createChallenge("Test", "Test", "", 1);
        currentLevel.createChallenge("Test", "Test", "Test", 2147483647);
        currentLevel.createChallenge("Test", "Test", "Test", -2147483647);*/

        /*List<Challenge> challenges = currentLevel.getChallenges();
        assert challenges.size() == 8;
        assert challenges.stream().filter(a -> a.getTitle() == "Test").count() == 1;*/
    }

    //endregion

}
