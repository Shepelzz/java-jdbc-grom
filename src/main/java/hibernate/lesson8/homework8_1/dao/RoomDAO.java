package hibernate.lesson8.homework8_1.dao;

import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Filter;
import hibernate.lesson8.homework8_1.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class RoomDAO extends GeneralDAO<Room>{
    private static final String SQL_FOND_BY_PARAMETERS = "SELECT r.* FROM FP_ROOM r\n" +
            "    LEFT JOIN FP_HOTEL h ON r.HOTEL_ID = h.ID\n" +
            "   WHERE (:NumberOfGuests = 0 OR r.NUMBER_OF_GUESTS = :numberOfGuests)\n" +
            "    AND (:price = 0 OR r.PRICE <= :price)\n" +
            "    AND (:breakfastIncluded = r.BREAKFAST_INCLUDED)\n" +
            "    AND (:petsAllowed = r.PETS_ALLOWED)\n" +
            "    AND (:dateAvailableFrom >= r.DATE_AVAILABLE_FROM)\n" +
            "    AND (:hotelName IS NULL OR h.HOTEL_NAME = :hotelName)\n" +
            "    AND (:hotelCountry IS NULL OR h.HOTEL_COUNTRY = :hotelCountry)\n" +
            "    AND (:hotelCity IS NULL OR h.HOTEL_CITY = :hotelCity)";

    public RoomDAO() {
        setClazz(Room.class);
    }

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

//            return (List<Room>) session.createSQLQuery(SQL_FOND_BY_PARAMETERS)
//                    .setParameter("NumberOfGuests", filter.getNumberOfGuests())
//                    .setParameter("price", filter.getPrice())
//                    .setParameter("breakfastIncluded", filter.isBreakfastIncluded() ? 1 : 0)
//                    .setParameter("petsAllowed", filter.isPetsAllowed() ? 1 : 0)
//                    .setParameter("dateAvailableFrom", filter.getDateAvailableFrom())
//                    .setParameter("hotelName", filter.getName())
//                    .setParameter("hotelCountry", filter.getCountry())
//                    .setParameter("hotelCity", filter.getCity())
//                    .addEntity(Room.class).list();

//        Criteria criteria = session.createCriteria(Room.class, "room");
//        if(filter.getNumberOfGuests()!=null)
//            criteria.add(Restrictions.eq("numberOfGuests", filter.getNumberOfGuests()));
//        if(filter.getPrice()!=null)
//            criteria.add(Restrictions.le("price", filter.getPrice()));
//        if(filter.getBreakfastIncluded()!=null)
//            criteria.add(Restrictions.eq("breakfastIncluded", filter.getBreakfastIncluded()));
//        if(filter.getPetsAllowed()!=null)
//            criteria.add(Restrictions.eq("petsAllowed", filter.getPetsAllowed()));
//        if(filter.getDateAvailableFrom()!=null)
//            criteria.add(Restrictions.le("dateAvailableFrom", filter.getDateAvailableFrom()));
//
//        criteria.createAlias("room.hotel", "hotel");
//        if(filter.getName()!=null)
//            criteria.add(Restrictions.eq("hotel.name", filter.getName()));
//        if(filter.getCountry()!=null)
//            criteria.add(Restrictions.eq("hotel.country", filter.getCountry()));
//        if(filter.getCity()!=null)
//            criteria.add(Restrictions.eq("hotel.city", filter.getCity()));
//
//        return criteria.list();

            return null;


        } catch (HibernateException e) {
            throw new InternalServerError(getClass().getSimpleName()+"-findRooms failed. "+e.getMessage());
        }
    }

//    @Override
//    public Room findById(long id) throws InternalServerError {
//        try (Session session = createSessionFactory().openSession()) {
//
//            return session.get(Room.class, id);
//
//        } catch (HibernateException e) {
//            throw new InternalServerError(getClass().getSimpleName()+"-findById: "+id+" failed. "+e.getMessage());
//        } catch (NoResultException noe){
//            return null;
//        }
//    }
}