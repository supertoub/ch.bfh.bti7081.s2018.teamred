package Data;

import org.junit.Test;

public class TestPersistance {
    @Test
    public void testPers(){
        ChallengePersistence chPers = ChallengePersistence.getInstance();
        chPers.getById((long) 2);

        LevelPersistence lvlPers = LevelPersistence.getInstance();
        lvlPers.getById((long) 2);
    }
}
