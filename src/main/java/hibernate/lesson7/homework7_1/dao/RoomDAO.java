package hibernate.lesson7.homework7_1.dao;

import hibernate.lesson7.homework7_1.entity.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RoomDAO {
    private SessionFactory sessionFactory;

    public Room save(Room room) throws Exception{
        Transaction transaction = null;
        try (Session session = createSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            session.save(room);

            session.getTransaction().commit();
            System.out.println("Save done");
            return room;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw new Exception("Save Room: "+room.toString()+" failed"+e.getMessage());
        }
    }

    public Room update(Room room) throws Exception{
        Transaction transaction = null;
        try (Session session = createSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            session.update(room);

            session.getTransaction().commit();
            System.out.println("Update done");
            return room;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw new Exception("Update Room: "+room.toString()+" failed"+e.getMessage());
        }
    }

    public Room delete(Room room) throws Exception{
        Transaction transaction = null;
        try (Session session = createSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            session.delete(room);

            session.getTransaction().commit();
            System.out.println("Delete done");
            return room;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw new Exception("Delete Room: "+room.toString()+" failed"+e.getMessage());
        }
    }

    public Room findById(long id) throws Exception{
        try (Session session = createSessionFactory().openSession()) {

            return session.get(Room.class, id);

        } catch (HibernateException e) {
            throw new Exception("Find by id: "+id+" failed"+e.getMessage());
        }
    }

    private SessionFactory createSessionFactory(){
        if(sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
