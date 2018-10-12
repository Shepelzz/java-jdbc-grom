package hibernate.lesson8.test.dao;

import hibernate.lesson8.test.entity.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HotelDAO {
    private SessionFactory sessionFactory;

    public Hotel save(Hotel hotel) throws Exception{
        Transaction transaction = null;
        try (Session session = createSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            session.save(hotel);

            session.getTransaction().commit();
            System.out.println("Save done");
            return hotel;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw new Exception("Save Hotel: "+hotel.toString()+" failed"+e.getMessage());
        }
    }

    public Hotel update(Hotel hotel) throws Exception{
        Transaction transaction = null;
        try (Session session = createSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            session.update(hotel);

            session.getTransaction().commit();
            System.out.println("Update done");
            return hotel;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw new Exception("Update Hotel: "+hotel.toString()+" failed"+e.getMessage());
        }
    }

    public Hotel delete(Hotel hotel) throws Exception{
        Transaction transaction = null;
        try (Session session = createSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            session.delete(hotel);

            session.getTransaction().commit();
            System.out.println("Delete done");
            return hotel;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw new Exception("Delete Hotel: "+hotel.toString()+" failed"+e.getMessage());
        }
    }

    public Hotel findById(long id) throws Exception{
        try (Session session = createSessionFactory().openSession()) {

            return session.get(Hotel.class, id);

        } catch (HibernateException e) {
            //throw new Exception("Find by id: "+id+" failed"+e.getMessage());
            throw e;
        }
    }

    private SessionFactory createSessionFactory(){
        if(sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
