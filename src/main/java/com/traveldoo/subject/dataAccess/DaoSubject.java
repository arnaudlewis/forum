package com.traveldoo.subject.dataAccess;

import com.traveldoo.common.dataAccess.Dao;
import com.traveldoo.subject.Subject;
import com.traveldoo.subject.dto.SubjectResponseDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by arnaud on 27/01/2014.
 */
public class DaoSubject extends Dao<Subject> {

    private static DaoSubject instance = new DaoSubject();

    private DaoSubject() {
    }

    public static DaoSubject getInstance() {
        return instance;
    }


    @Override
    public int insert(Subject obj) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.persist(obj);
            em.flush();
            int id = obj.getId_subject();
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
    public void update(Subject obj) {
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
    public void delete(Subject obj) {
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
    public Subject find(int id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            Subject responseSubject = em.find(Subject.class, id);
            t.commit();
            return responseSubject;
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
    public List<Subject> findAll() {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        List<Subject> listSubject;

        try {
            t.begin();
            String sql = "select e from Subject e";
            TypedQuery<Subject> query = em.createQuery(sql, Subject.class);
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
}
