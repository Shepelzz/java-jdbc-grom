package hibernate.lesson8.homework8_1.dao;

import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.GeneralModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.NoResultException;

public abstract class GeneralDAO<T extends GeneralModel>{
    private Class<T> clazz;
    private SessionFactory sessionFactory;

    public final void setClazz( Class<T> clazzToSet ){
        this.clazz = clazzToSet;
    }

    public T findById(long id) throws InternalServerError{
        try (Session session = createSessionFactory().openSession()) {

            return session.get(clazz, id);

        } catch (HibernateException e) {
            throw new InternalServerError(getClass().getSimpleName()+"-findById: "+id+" failed. "+e.getMessage());
        } catch (NoResultException noe){
            return null;
        }
    }

    T save(T t) throws InternalServerError {
        Transaction transaction = null;
        try (Session session = createSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            session.save(t);

            session.getTransaction().commit();
            System.out.println(t.getClass().getName()+" saved with id:"+t.getId());
            return t;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw new InternalServerError("Save "+t.getClass().getSimpleName()+": "+t.toString()+" failed"+e.getMessage());
        }
    }

    T delete(T t) throws InternalServerError {
        Transaction transaction = null;
        try (Session session = createSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            session.delete(t);

            session.getTransaction().commit();
            System.out.println(t.getClass().getName()+" id:"+t.getId()+" was deleted");
            return t;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw new InternalServerError("Delete "+t.getClass().getSimpleName()+": "+t.toString()+" failed"+e.getMessage());
        }
    }

    T update(T t) throws InternalServerError {
        Transaction transaction = null;
        try (Session session = createSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            session.update(t);

            session.getTransaction().commit();
            System.out.println(t.getClass().getName()+" updated");
            return t;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw new InternalServerError("Update "+t.getClass().getSimpleName()+": "+t.toString()+" failed"+e.getMessage());
        }
    }

    SessionFactory createSessionFactory(){
        if(sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
