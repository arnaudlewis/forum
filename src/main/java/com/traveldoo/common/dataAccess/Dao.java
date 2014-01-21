package com.traveldoo.common.dataAccess;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by arnaud on 19/01/2014.
 */
public abstract class Dao<T> {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public abstract int insert(T obj);

    public abstract void update(T obj);

    public abstract void delete(T obj);

    public abstract T find(int id);

    public abstract List<T> findAll();



}
