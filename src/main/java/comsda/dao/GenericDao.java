package comsda.dao;


import comsda.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDao<T> {

    public void createEntity (T entity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(entity);
        transaction.commit();
        session.close();
    }

    public T getEntityById( Class<T> cls, Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        T entity = session.get(cls, id);
        transaction.commit();
        return entity;
    }

    public T deleteEntity (T entity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
        return entity;
    }

    public T update(T entity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return entity;
    }

}
