package hibernate.lesson8.homework8_1.dao;
import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class HotelDAO extends GeneralDAO<Hotel>{
    private static final String SQL_FIND_HOTELS_BY_NAME = "SELECT * FROM FP_HOTEL WHERE HOTEL_NAME = :name";
    private static final String SQL_FIND_HOTELS_BY_CITY = "SELECT * FROM FP_HOTEL WHERE HOTEL_CITY = :name";

    public HotelDAO() {
        setClazz(Hotel.class);
    }

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws InternalServerError {
        return save(hotel);
    }

    //ADMIN
    public void deleteHotel(Hotel hotel) throws InternalServerError {
        delete(hotel);
    }

    public List<Hotel> findHotelByName(String name) throws InternalServerError {
        try (Session session = createSessionFactory().openSession()) {

            return (List<Hotel>) session.createSQLQuery(SQL_FIND_HOTELS_BY_NAME)
                    .setParameter("name", name)
                    .addEntity(Hotel.class).list();

        } catch (HibernateException e) {
            throw new InternalServerError(getClass().getSimpleName()+"-findHotelByName "+name+" failed. "+e.getMessage());
        }
    }

    public List<Hotel> findHotelByCity(String name) throws InternalServerError {
        try (Session session = createSessionFactory().openSession()) {

            return (List<Hotel>) session.createSQLQuery(SQL_FIND_HOTELS_BY_CITY)
                    .setParameter("name", name)
                    .addEntity(Hotel.class).list();

        } catch (HibernateException e) {
            throw new InternalServerError(getClass().getSimpleName()+"-findHotelByCity "+name+" failed. "+e.getMessage());
        }
    }

//    @Override
//    public Hotel findById(long id) throws InternalServerError {
//        try (Session session = createSessionFactory().openSession()) {
//
//            return session.get(Hotel.class, id);
//
//        } catch (HibernateException e) {
//            throw new InternalServerError(getClass().getSimpleName()+"-findById: "+id+" failed. "+e.getMessage());
//        } catch (NoResultException noe){
//            return null;
//        }
//    }
}