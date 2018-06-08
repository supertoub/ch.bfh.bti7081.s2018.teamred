package Data;

import Business.Challenge;
import Business.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

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
public class ChallengePersistence extends GenericPersistence<Challenge, Long>{
    //we inherit the basic CRUD operations from the GenericRepository

    private static final Logger logger = LogManager.getLogger(ChallengePersistence.class);
    static ChallengePersistence singleton;

    //returns the current instance of ChallengePersistence
    public static ChallengePersistence getInstance() {
        if (singleton == null) {
            singleton = new ChallengePersistence();
        }
        return singleton;
    }

    @Override
    public Challenge getById(Long id) {
        return super.getByID(id);
    }

    public Challenge getByTitle(String title) {
        logger.debug("Beginn transaction for getByTitle");
        super.getEntityManager().getTransaction().begin();
        Query q = super.getEntityManager().createQuery("SELECT c FROM Challenge c WHERE c.title = :title");
        Challenge challenge = (Challenge) q.setParameter("title", title).getSingleResult();
        logger.debug("Finished query getByTitle");
        super.getEntityManager().getTransaction().commit();
        logger.debug("Transaction completed for getByTitle");
        return challenge;
    }

}
