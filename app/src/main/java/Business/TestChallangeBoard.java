package Business;

import UserInterface.ChallengeBoard;
import com.vaadin.ui.Button;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestChallangeBoard {

    //region User

    @Test
    public void testArzt(){
        List<Patient> patienten = new ArrayList<>();
        patienten.add(new Patient("Test", "Patient", "TestPWD", new Date(), new JournalLibrary(), new LevelLibrary(ChallengeBoardPresenter.getInstance())));
        Arzt arzt = new Arzt("Test", "Arzt", "Test", patienten);

        assert arzt.getPatients().size() == 1;

        patienten.add(new Patient("Test 2", "Patient", "TestPWD", new Date(), new JournalLibrary(), new LevelLibrary(ChallengeBoardPresenter.getInstance())));
        arzt.setPatients(patienten);

        assert arzt.getPatients().size() == 2;
    }

    @Test
    public void testPatient(){
        Patient patient = new Patient("Test", "Patient", "TestPWD", new Date(), new JournalLibrary(), new LevelLibrary(ChallengeBoardPresenter.getInstance()));
        patient.setJournalLibrary(new JournalLibrary());
        assert patient.getJournalLibrary() != null;
        patient.setLastEntryWritten(new Date());
        assert patient.getLastEntryWritten() != null;
        patient.setLevelLibrary(new LevelLibrary(ChallengeBoardPresenter.getInstance()));
        assert patient.getLevelLibrary() != null;
    }

    //endregion

    //region Challange

    @Test
    public void testChallange(){
        Level lvl = new Level("Test", 1, ChallengeBoardPresenter.getInstance());
        Challenge currentChallenge = new Challenge("Test", "Test", ChallengeState.open,1,  lvl);
        assert currentChallenge.getLevelOfAnxiety() == 1;
        assert currentChallenge.getChallengeState().equals(ChallengeState.open);
        assert currentChallenge.getDesc().equals("Test");
        assert currentChallenge.getTitle().equals("Test");
        long someId = currentChallenge.getId();

        currentChallenge.setChallengeState(ChallengeState.closed);
        assert currentChallenge.getChallengeState().equals(ChallengeState.closed);
        currentChallenge.setDesc("Test 2");
        assert currentChallenge.getDesc().equals("Test 2");
        currentChallenge.setLevelOfAnxiety(2);
        assert currentChallenge.getLevelOfAnxiety() == 2;
        currentChallenge.setTitle("Test 2");
        assert currentChallenge.getTitle().equals("Test 2");
    }

    //endregion

    //region ChallangeBoard ChallangeBoardPresenter

    @Test
    public void testChallengeBoardPresenter(){
        ChallengeBoardPresenter presenter = ChallengeBoardPresenter.getInstance();
        presenter.setLevelInfoLabel(1, 2, 3);
        presenter.addLevel("Test", LevelState.open);
        presenter.clearLevels();
        presenter.addChallengeDetails(new Challenge("Test", "Test", ChallengeState.closed, 1, ChallengeBoardPresenter.getInstance()));
        presenter.removeChallengeDetails();
        presenter.removeChallenges();
        //presenter.detailsClick(new Button.ClickEvent(new Button()));
        presenter.AddLevelButtonClick(new Button.ClickEvent(new Button()));
        //presenter.AddLevelClick(new Button.ClickEvent(new Button()));
        //presenter.BackClick(new Button.ClickEvent(new Button()));
        //presenter.closeClick(new Button.ClickEvent(new Button()));
        //presenter.NewChallClick(new Button.ClickEvent(new Button()));
        //presenter.reOpenClick(new Button.ClickEvent(new Button()));
        //presenter.buttonClick("Test", "Test Ch", "Desc Ch", 1);
        presenter.update(new Level("Test", 1, presenter), new Object());
    }

    //endregion

    //region LevelLibrary Level

    @Test
    public void levelHandling(){
        LevelLibrary lib = new LevelLibrary(ChallengeBoardPresenter.getInstance());
        lib.createNewLevel(LevelState.open);
        assert lib.getLevels().size() == 1;
        assert lib.getLevels().get(0).getLevelState().equals(LevelState.open);
        lib.getLevels().get(0).setLevelState(LevelState.closed);
        assert lib.getLevels().get(0).getLevelState().equals(LevelState.closed);

        Level currentLevel = new Level("Test", 1, lib);
        currentLevel.createChallenge("Test", "Test", "blabla", 1);

        List<Challenge> challenges = currentLevel.getChallenges();
        assert challenges.size() == 1;
    }

    //endregion

    //region JournalLibrary Journal

    @Test
    public void testJournalLibrary(){
        JournalLibrary lib = new JournalLibrary();
        lib.createEntry();

        List<JournalEntry> entries = lib.getJournalEntries();
        assert lib.getJournalEntries().size() == 1;
        lib.createEntry();
        assert lib.getJournalEntries().size() == 2;
        lib.deleteEntry(lib.getJournalEntries().get(1));
        assert lib.getJournalEntries().size() == 1;
        assert lib.getId() > 0;
    }

    //endregion

}
