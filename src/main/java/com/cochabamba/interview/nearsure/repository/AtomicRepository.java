package com.cochabamba.interview.nearsure.repository;

//package com.codesignal.repository;


import com.cochabamba.interview.nearsure.model.Account;

import java.util.Optional;

/**
 * An interface of an atomic repository.
 *
 * @param <ID> type of the repository id.
 * @param <V>  type of the stored values.
 */
public interface AtomicRepository<ID, V> {

    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the entity instance
     * completely.
     *
     * @param value must not be null.
     * @return the saved entity; will never be null.
     */
    V save(V value);

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be null.
     * @return the entity with the given id or {@link Optional#empty()} if none found.
     */
    Optional<Account> findById(ID id);

    /**
     * Checks if value for the given [id] is equal to the [oldValue] and if so, updates it with [value].
     *
     * @param id       must not be null.
     * @param oldValue must not be null.
     * @param value    must not be null.
     * @return `true` if value was updated, `false` otherwise.
     */
    boolean compareAndSet(ID id, V oldValue, V value);
}
