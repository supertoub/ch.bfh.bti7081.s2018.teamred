package Data;

import Business.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.Query;


/**
 * Class to manage Challenge objects on database layer
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
    static LevelPersistence singleton;

    //returns the current instance of ChallengePersistence
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

    public Level getByTitle(String title) {
        logger.debug("Beginn transaction for getByTitle");
        super.getEntityManager().getTransaction().begin();
        Query q = super.getEntityManager().createQuery("SELECT l FROM Level l WHERE l.levelLabel = :title");
        Level level = (Level) q.setParameter("title", title).getSingleResult();
        logger.debug("Finished query getByTitle");
        super.getEntityManager().getTransaction().commit();
        logger.debug("Transaction completed for getByTitle");
        return level;
    }

}
