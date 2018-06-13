package Data;

import Business.LevelLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class to manage LevelLibrary objects on database layer
 *
 * @date 01.06.2018
 *
 * @author Fridolin Zurlinden
 *
 * @version 1.0
 */
public class LevelLibraryPersistence extends GenericPersistence<LevelLibrary, Long>{
    //we inherit the basic CRUD operations from the GenericRepository

    private static final Logger logger = LogManager.getLogger(LevelLibraryPersistence.class);
    private static LevelLibraryPersistence singleton;

    //returns the current instance of ChallengePersistence
    public static LevelLibraryPersistence getInstance() {
        if (singleton == null) {
            singleton = new LevelLibraryPersistence();
        }
        return singleton;
    }

    @Override
    public LevelLibrary getById(Long id) {
        return super.getByID(id);
    }

}
