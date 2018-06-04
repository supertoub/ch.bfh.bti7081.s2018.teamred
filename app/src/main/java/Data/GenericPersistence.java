package Data;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * Abstract class to use and manage a database with JPA
 *
 * @date 30.03.2016
 *
 * @author Elias Eggenschwiler
 *
 * @param <T>
 *            Generic Type of a persistence class
 * @param <ID>
 *            Long
 */

@PersistenceContext(unitName="social-anxiety-db")
public abstract class GenericPersistence<T, ID extends Serializable> implements GenericRepository<T, ID> {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private Class<T> persistenceClass;
    private static final Logger logger = LogManager.getLogger(GenericPersistence.class);

    @PostConstruct
    public void init(){

    }

    /**
     * Constructors
     */
    @SuppressWarnings("unchecked")
    public GenericPersistence() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("social-anxiety-db");
            em = emf.createEntityManager();
            //em.setFlushMode(FlushModeType.COMMIT); // If you want JPA/Hibernate to auto-flush (auto-save) changed entities, remove this line!
            logger.debug("Entity manager has been created.");
        }
        persistenceClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public GenericPersistence(final Class<T> persistentClass) {
        super();
        this.persistenceClass = persistentClass;
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("social-anxiety-db");
            em = emf.createEntityManager();
            logger.debug("Entity manager has been created.");
        }
    }


    /**
     * get all persistence classes
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        logger.debug("getAll, called by: "+persistenceClass.getSimpleName());
        return (List<T>) em.createQuery("from " + persistenceClass.getSimpleName())
                .getResultList();
    }

    /**
     * Find by id of persistence class
     * @param id
     * @return
     */
    public T getByID(ID id) {
        logger.debug("getByID called by: "+persistenceClass.getSimpleName()+", with param-id: "+id);
        return em.find(persistenceClass, id);
    }

    /**
     * Persist entity
     * @param entity
     * @return
     */
    public T persist(T entity) {
        logger.debug("persist called - Try to save entity of: "+persistenceClass.getSimpleName());
        em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        em.refresh(entity);
        return entity;
    }

    /**
     * Remove entity
     * @param id
     * @return
     */
    public void remove(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    /**
     * Search by value of attribute from persistence class
     * @param attribute
     * @param searchString
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> findByString(String attribute, String searchPattern) {
        logger.debug("findByString - Search by value: "+ searchPattern + " of attribute " + attribute + " from " + persistenceClass.getSimpleName());
        em.getTransaction().begin();
        Query q = em.createQuery("from " + persistenceClass.getSimpleName()
                + " where " + attribute + " like :search");
        q.setParameter("search", searchPattern + "%");
        em.getTransaction().commit();
        return q.getResultList();
    }

    public Class<T> getEntityClass() {
        return persistenceClass;
    }

    public void flush() {
        em.flush();
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
