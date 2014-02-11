package com.traveldoo.common.dataAccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arnaud on 19/01/2014.
 */
public abstract class Dao<T> {

    static Map<String, Object> configOverrides = new HashMap<String, Object>() {{
        put("hibernate.hbm2ddl.auto", "create");
    }};
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ForumUnit", configOverrides);

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public abstract int insert(T obj);

    public abstract void update(T obj);

    public abstract void delete(T obj);

    public abstract T find(int id);

    public abstract List<T> findAll();


}
