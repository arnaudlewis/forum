package com.traveldoo.user.dataAccess;

import com.traveldoo.common.dataAccess.Dao;
import com.traveldoo.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by arnaud on 19/01/2014.
 */
public class DaoUser extends Dao<User> {

    private static DaoUser instance = new DaoUser();

    private DaoUser() {
    }

    public static DaoUser getInstance() {
        return instance;
    }

    @Override
    public int insert(User obj) {

        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {

            t.begin();
            em.persist(obj);
            em.flush();
            int id = obj.getId_user();
            t.commit();
            return id;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;

        } finally {

            if (t.isActive()) {

                t.rollback();
                em.close();
            }
        }
    }

    @Override
    public void update(User obj) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.persist(obj);
            t.commit();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (t.isActive()) {
                t.rollback();
                em.close();
            }
        }


    }

    @Override
    public void delete(User obj) {

        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.remove(obj);
            t.commit();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (t.isActive()) {
                t.rollback();
                em.close();
            }
        }

    }

    @Override
    public User find(int id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            User responseUser = em.find(User.class, id);
            t.commit();
            return responseUser;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            if (t.isActive()) {
                t.rollback();
                em.close();
            }
        }
    }

    @Override
    public List<User> findAll() {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            String sql = "Select e from User e";
            TypedQuery<User> query = em.createQuery(sql, User.class);
            t.commit();
            return query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            if (t.isActive()) {
                t.rollback();
                em.close();
            }
        }
    }

    public User authentication(String username, String password) {

        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            String sql = "select e from User e where e.username = :username and e.password = :password";
            TypedQuery<User> query = em.createQuery(sql, User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            if (t.isActive()) {
                t.rollback();
                em.close();
            }
        }
    }

}
