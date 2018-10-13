package hibernate.lesson8.homework8_1.dao;

import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Filter;
import hibernate.lesson8.homework8_1.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;
import java.util.stream.Collectors;

public class RoomDAO extends GeneralDAO<Room>{

    //ADMIN
    public Room addRoom(Room room) throws InternalServerError {
        return save(room);
    }

    //ADMIN
    public void deleteRoom(Room room) throws InternalServerError {
        delete(room);
    }

    public Set<Room> findRooms(Filter filter) throws InternalServerError {
        return null;
    }

    @Override
    Room findById(long id) throws InternalServerError {
        try (Session session = createSessionFactory().openSession()) {

            return session.get(Room.class, id);

        } catch (HibernateException e) {
            throw new InternalServerError(getClass().getName()+"-findById: "+id+" failed. "+e.getMessage());
        }
    }
}