package UserInterface;

import Business.ChallengeBoardPresenter;
import com.vaadin.ui.Button;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestUserInterface {

    @Ignore("Vaadin components not loaded")
    @Test
    public void testUI (){
        List<String> lvls = new ArrayList<>();
        AddChallenge addChallenge = new AddChallenge(lvls);
        addChallenge.addListener(ChallengeBoardPresenter.getInstance());
        addChallenge.buttonClick(new Button.ClickEvent(new Button()), "Level", "Test", "Test", 1);

        AddJournalEntry entry = new AddJournalEntry(lvls);
        //entry.buttonClick(new Button.ClickEvent(new Button()), "Level", "Test", "Test", 1);
    }
}
