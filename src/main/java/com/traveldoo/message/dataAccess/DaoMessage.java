package com.traveldoo.message.dataAccess;

import com.traveldoo.common.dataAccess.Dao;
import com.traveldoo.message.Message;
import com.traveldoo.subject.Subject;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by arnaud on 27/01/2014.
 */
public class DaoMessage extends Dao<Message> {

    private static DaoMessage instance = new DaoMessage();

    private DaoMessage() {
    }

    public static DaoMessage getInstance() {
        return instance;
    }

    @Override
    public int insert(Message obj) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.persist(obj);
            em.flush();
            int id = obj.getId_message();
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
    public void update(Message obj) {
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
    public void delete(Message obj) {
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
    public Message find(int id) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            Message responseMessage = em.find(Message.class, id);
            t.commit();
            return responseMessage;
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
    public List<Message> findAll() {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        List<Message> listMessage;

        try {
            t.begin();
            String sql = "select e from Message e";
            TypedQuery<Message> query = em.createQuery(sql, Message.class);
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

    public List<Message> findAllBySubject(Subject obj) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        List<Message> listMessage;

        try {
            t.begin();
            String sql = "select e from Message e where e.subject = :subject";
            TypedQuery<Message> query = em.createQuery(sql, Message.class);
            query.setParameter("subject", obj);
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
