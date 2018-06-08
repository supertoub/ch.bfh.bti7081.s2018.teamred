package Data;

import java.io.Serializable;
import java.util.List;

/**
 * Generic Repository, providing basic CRUD operations
 *
 * @date 01.06.2018
 *
 * @author Fridolin Zurlinden
 *
 * @param <T> the entity type
 * @param <ID> the primary key type
 */
public interface GenericRepository<T, ID extends Serializable> {
    /**
     * Get the Class of the entity.
     *
     * @return the class
     */
    Class<T> getEntityClass();

    /**
     * Find an entity by its primary key
     *
     * @param id the primary key
     * @return the entity
     */
    T getById(final ID id);

    /**
     * Load all entities.
     *
     * @return the list of entities
     */
    List<T> getAll();

    /**
     * Find entity by searching for a String in provided attribute
     *
     * @param attribute the name of the attribute
     * @param searchPattern the String to be searched for
     *
     * @return the list of entities
     */
    List<T> findByString(String attribute, String searchPattern);

    /**
     * save an entity. This can be either a INSERT or UPDATE in the database.
     *
     * @param entity the entity to save
     *
     * @return the saved entity
     */
    T persist(final T entity);

    /**
     * delete an entity from the database.
     *
     * @param entity the entity to delete
     */
    void remove(final T entity);
}

