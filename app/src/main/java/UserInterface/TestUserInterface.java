/*package UserInterface;

import Business.ChallengeBoardPresenter;
import Business.JournalLibraryPresenter;
import Business.Level;
import com.vaadin.ui.Button;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestUserInterface {

    @Test
    public void testUI (){
        List<String> lvls = new ArrayList<>();
        AddChallenge addChallenge = new AddChallenge(lvls);
        addChallenge.addListener(ChallengeBoardPresenter.getInstance());
        addChallenge.buttonClick(new Button.ClickEvent(new Button()), "Level", "Test", "Test", 1);

        AddJournalEntry entry = new AddJournalEntry(lvls);
        entry.buttonClick(new Button.ClickEvent(new Button()), "Level", "Test", "Test", 1);
    }
}
*/