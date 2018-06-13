package Data;

import Business.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Class to manage Patient objects on database layer
 *
 * @date 01.06.2018
 *
 * @author Fridolin Zurlinden
 *
 * @version 1.0
 */
public class PatientPersistence extends GenericPersistence<Patient, Long>{
    //we inherit the basic CRUD operations from the GenericRepository

    private static final Logger logger = LogManager.getLogger(PatientPersistence.class);
    private static PatientPersistence singleton;

    //returns the current instance of PatientPersistence
    public static PatientPersistence getInstance() {
        if (singleton == null) {
            singleton = new PatientPersistence();
        }
        return singleton;
    }

    @Override
    public Patient getById(Long id) {
        return super.getByID(id);
    }

    public Patient getByName(String name) throws NoResultException {
        logger.debug("Beginn transaction for getByTitle");
        super.getEntityManager().getTransaction().begin();
        Query q = super.getEntityManager().createQuery("SELECT p FROM Patient p WHERE p.name = :name");
        Patient patient = (Patient) q.setParameter("name", name).getSingleResult();
        logger.debug("Finished query getByTitle");
        super.getEntityManager().getTransaction().commit();
        logger.debug("Transaction completed for getByTitle");
        return patient;
    }

    /* Prepared for username feature:
    public Patient getByUserName(String username) {
        logger.debug("Beginn transaction for getByTitle");
        super.getEntityManager().getTransaction().begin();
        Query q = super.getEntityManager().createQuery("SELECT p FROM Patient p WHERE p.name = :name");
        Patient patient = (Patient) q.setParameter("username", username).getSingleResult();
        logger.debug("Finished query getByTitle");
        super.getEntityManager().getTransaction().commit();
        logger.debug("Transaction completed for getByTitle");
        return patient;
    }*/
}
