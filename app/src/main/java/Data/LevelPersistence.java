package Data;

import Business.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class to manage Level objects on database layer
 *
 * @date 01.06.2018
 *
 * @author Fridolin Zurlinden
 *
 * @version 1.0
 */
public class LevelPersistence extends GenericPersistence<Level, Long>{
    //we inherit the basic CRUD operations from the GenericRepository

    private static final Logger logger = LogManager.getLogger(LevelPersistence.class);
    private static LevelPersistence singleton;

    private LevelPersistence(){

    }

    //returns the current instance of LevelPersistence
    public static LevelPersistence getInstance() {
        if (singleton == null) {
            singleton = new LevelPersistence();
        }
        return singleton;
    }

    @Override
    public Level getById(Long id) {
        return super.getByID(id);
    }

}
