package hibernate.lesson8.homework8_1.dao;

import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Filter;
import hibernate.lesson8.homework8_1.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RoomDAO extends GeneralDAO<Room>{
    private static final String SQL_FOND_BY_PARAMETERS = "SELECT r.* FROM FP_ROOM r\n" +
            "    LEFT JOIN FP_HOTEL h ON r.HOTEL_ID = h.ID\n" +
            "   WHERE (:NumberOfGuests = 0 OR r.NUMBER_OF_GUESTS = :NumberOfGuests)\n" +
            "    AND (:price = 0 OR r.PRICE <= :price)\n" +
            "    AND (:breakfastIncluded = r.BREAKFAST_INCLUDED)\n" +
            "    AND (:petsAllowed = r.PETS_ALLOWED)\n" +
            "    AND (:dateAvailableFrom >= r.DATE_AVAILABLE_FROM)\n" +
            "    AND (:hotelName IS NULL OR h.HOTEL_NAME = :hotelName)\n" +
            "    AND (:hotelCountry IS NULL OR h.HOTEL_COUNTRY = :hotelCountry)\n" +
            "    AND (:hotelCity IS NULL OR h.HOTEL_CITY = :hotelCity)";

    //ADMIN
    public Room addRoom(Room room) throws InternalServerError {
        return save(room);
    }

    //ADMIN
    public void deleteRoom(Room room) throws InternalServerError {
        delete(room);
    }

    public List<Room> findRooms(Filter filter) throws InternalServerError {
        try (Session session = createSessionFactory().openSession()) {

            return (List<Room>) session.createSQLQuery(SQL_FOND_BY_PARAMETERS)
                    .setParameter("NumberOfGuests", filter.getNumberOfGuests())
                    .setParameter("price", filter.getPrice())
                    .setParameter("breakfastIncluded", filter.isBreakfastIncluded() ? 1 : 0)
                    .setParameter("petsAllowed", filter.isPetsAllowed() ? 1 : 0)
                    .setParameter("dateAvailableFrom", filter.getDateAvailableFrom())
                    .setParameter("hotelName", filter.getName())
                    .setParameter("hotelCountry", filter.getCountry())
                    .setParameter("hotelCity", filter.getCity())
                    .addEntity(Room.class).list();

        } catch (HibernateException e) {
            throw new InternalServerError(getClass().getSimpleName()+"-findRooms failed. "+e.getMessage());
        }
    }

    @Override
    public Room findById(long id) throws InternalServerError {
        try (Session session = createSessionFactory().openSession()) {

            return session.get(Room.class, id);

        } catch (HibernateException e) {
            throw new InternalServerError(getClass().getSimpleName()+"-findById: "+id+" failed. "+e.getMessage());
        } catch (NoResultException noe){
            return null;
        }
    }
}