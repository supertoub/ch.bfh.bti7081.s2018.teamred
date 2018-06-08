package Business;

import UserInterface.ChallengeBoard;
import com.vaadin.ui.Button;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertThat;

public class TestChallangeBoard {

    //region User

    @Test
    public void testArzt(){
        List<Patient> patienten = new ArrayList<>();
        patienten.add(new Patient("UserName","Test", "Patient", "TestPWD", new Date(), new JournalLibrary(), new LevelLibrary(ChallengeBoardPresenter.getInstance())));
        Arzt arzt = new Arzt("UserName","Test", "Arzt", "Test", patienten);

        assert arzt.getPatients().size() == 1;

        patienten.add(new Patient("UserName","Test 2", "Patient", "TestPWD", new Date(), new JournalLibrary(), new LevelLibrary(ChallengeBoardPresenter.getInstance())));
        arzt.setPatients(patienten);

        assert arzt.getPatients().size() == 2;
    }

    @Test
    public void testPatient(){
        Patient patient = new Patient("UserName","Test", "Patient", "TestPWD", new Date(), new JournalLibrary(), new LevelLibrary(ChallengeBoardPresenter.getInstance()));
        patient.setJournalLibrary(new JournalLibrary());
        assert patient.getJournalLibrary() != null;
        patient.setLastEntryWritten(new Date());
        assert patient.getLastEntryWritten() != null;
        patient.setLevelLibrary(new LevelLibrary(ChallengeBoardPresenter.getInstance()));
        assert patient.getLevelLibrary() != null;
    }

    @Test
    public void testUser(){
        List<Patient> patList = new ArrayList<>();
        User us = new Arzt("UserName","Name", "Surname", "PWD", patList);
        long id = us.getId();
        assert us.getName().equals("Name");
        assert us.getPwd().equals("PWD");
        assert us.getSurname().equals("Surname");

        us.setName("Name2");
        assert us.getName().equals("Name2");
        us.setPwd("PWD2");
        assert us.getPwd().equals("PWD2");
        us.setSurname("Surname2");
        assert us.getSurname().equals("Surname2");
        ((Arzt) us).getPatients();
        ((Arzt) us).setPatients(patList);
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
        presenter.detailsClick(new Button.ClickEvent(new Button()));
        presenter.closeClick(new Button.ClickEvent(new Button()));
        presenter.reOpenClick(new Button.ClickEvent(new Button()));
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
        lib.getId();
        List<Level> lvls = new ArrayList<>();
        Level obs = new Level();
        lvls.add(obs);
        lib.setLevels(lvls);
        lib.update(obs, new Object());
        lib.createNewLevel();

        Level currentLevel = new Level("Test", 1, lib);
        currentLevel.createChallenge("Test", "Test", "blabla", 1);
        currentLevel.setLevelState(LevelState.closed);
        assert currentLevel.getLevelState().equals(LevelState.closed);
        assert !currentLevel.isDone;
        currentLevel.getLevelLabel();
        currentLevel.getClosedChallengesCount();
        currentLevel.getLevelDoneCount();
        currentLevel.deleteChallenge(currentLevel.getChallenges().get(0));
        currentLevel.getLevelCount();
        currentLevel.getId();
        List<Challenge> chList = new ArrayList<>();
        currentLevel.setChallenges(chList);
        currentLevel.setLevelLabel("test");
        currentLevel.update(lib, new Object());
        List<Challenge> challenges = currentLevel.getChallenges();
        assert challenges.size() == 0;
    }

    //endregion

    //region JournalLibrary Journal Presenter

    @Test
    public void testJournalPresenter(){
        JournalLibraryPresenter presenter = JournalLibraryPresenter.getInstance();
        presenter.newWindowAddEntry();
        presenter.addClick();
        presenter.changeClick();
        presenter.getJournalView();
        presenter.backButtonClick(new Button.ClickEvent(new Button()));
        presenter.newEntryButtonClick(new Button.ClickEvent(new Button()));
        presenter.addJournalEntry("Test", "Test");
        presenter.deleteClick(new JournalEntry());
    }

    @Test
    public void testJournalLibrary(){
        JournalLibrary lib = new JournalLibrary();
        lib.createEntry();

        List<JournalEntry> entries = lib.getJournalEntries();
        JournalLibrary newLib = new JournalLibrary(entries);
        assert lib.getJournalEntries().size() == 1;
        lib.createEntry();
        assert lib.getJournalEntries().size() == 2;
        lib.deleteEntry(lib.getJournalEntries().get(0));
        assert lib.getJournalEntries().size() == 1;
        lib.getId();
        List<JournalEntry> items = new ArrayList<JournalEntry>() {};
        items.add(new JournalEntry());
        lib.setJournalEntries(items);
    }

    //endregion

    //region LoginView

    @Test
    public void testLoginViewPresenter(){
        LoginViewPagePresenter presenter = LoginViewPagePresenter.getInstance();
        presenter.getLoginView();
    }

    //endregion

    //region StartPage

    @Ignore("Vaadin components not loaded")
    @Test
    public void testStartPage(){
        StartpagePresenter presenter = StartpagePresenter.getInstance();
        presenter.getStartView();
        presenter.buttonClick("Test");
    }

    //endregion

}
