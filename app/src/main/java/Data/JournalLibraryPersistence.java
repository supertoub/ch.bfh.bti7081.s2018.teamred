package Data;

import Business.JournalLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class to manage JournalLibrary objects on database layer
 *
 * @date 01.06.2018
 *
 * @author Fridolin Zurlinden
 *
 * @version 1.0
 */
public class JournalLibraryPersistence extends GenericPersistence<JournalLibrary, Long> {
    //we inherit the basic CRUD operations from the GenericRepository

    private static final Logger logger = LogManager.getLogger(JournalLibraryPersistence.class);
    static JournalLibraryPersistence singleton;

    //returns the current instance of ChallengePersistence
    public static JournalLibraryPersistence getInstance() {
        if (singleton == null) {
            singleton = new JournalLibraryPersistence();
        }
        return singleton;
    }

    @Override
    public JournalLibrary getById(Long id) {
        return super.getByID(id);
    }

}
