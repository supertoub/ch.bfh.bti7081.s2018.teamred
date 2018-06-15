package Data;

import Business.JournalEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.Query;

/**
 * Class to manage JournalLibrary objects on database layer
 *
 * @date 01.06.2018
 *
 * @author Fridolin Zurlinden
 *
 * @version 1.0
 */
public class JournalPersistence extends GenericPersistence<JournalEntry, Long> {
//we inherit the basic CRUD operations from the GenericRepository

        private static final Logger logger = LogManager.getLogger(JournalPersistence.class);
        private static JournalPersistence singleton;

        //returns the current instance of ChallengePersistence
        public static JournalPersistence getInstance() {
                if (singleton == null) {
                        singleton = new JournalPersistence();
                }
                return singleton;
        }

        @Override
        public JournalEntry getById(Long id) {
                return super.getByID(id);
        }

        public JournalEntry getByTitle(String title) {
                logger.debug("Beginn transaction for getByTitle");
                super.getEntityManager().getTransaction().begin();
                Query q = super.getEntityManager().createQuery("SELECT j FROM JournalEntry j WHERE j.title = :title");
                JournalEntry journalEntry = (JournalEntry) q.setParameter("title", title).getSingleResult();
                logger.debug("Finished query getByTitle");
                super.getEntityManager().getTransaction().commit();
                logger.debug("Transaction completed for getByTitle");
                return journalEntry;
        }

}
