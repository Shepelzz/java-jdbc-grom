package hibernate.lesson8.homework8_1.dao;

import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Order;
import hibernate.lesson8.homework8_1.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.util.Date;

public class OrderDAO extends GeneralDAO<Order>{
    private static final String SQL_GET_ORDER_BY_ROOM_AND_USER = "SELECT * FROM FP_ORDER WHERE USER_ID = :userId AND ROOM_ID = :roomId";

    public OrderDAO() {
        setClazz(Order.class);
    }

    public void bookRoom(Order order, Room room) throws InternalServerError {
        Transaction transaction = null;

        try (Session session = createSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            session.save(order);
            session.update(room);

            session.getTransaction().commit();
            System.out.println("Reservation for roomId: "+room.getId()+" and was created by user id: "+order.getUser().getId());
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw new InternalServerError("Save Order for userId: "+UserSession.getLoggedUser().getId()+" and roomId: "+room.getId()+" failed"+e.getMessage());
        }
    }

    public void cancelReservation(long roomId, long userId) throws InternalServerError {
        Transaction transaction = null;
        RoomDAO roomDAO = new RoomDAO();

        Room room = roomDAO.findById(roomId);
        room.setDateAvailableFrom(new Date());

        try (Session session = createSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            session.delete(getOrderByRoomAndUser(roomId, userId));
            session.update(room);

            session.getTransaction().commit();
            System.out.println("Reservation for roomId: "+roomId+" and userId: "+userId+" was canceled");
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw new InternalServerError("Delete Order for userId: "+userId+" and roomId: "+roomId+" failed"+e.getMessage());
        }
    }

    public Order getOrderByRoomAndUser(long roomId, long userId) throws InternalServerError {
        try (Session session = createSessionFactory().openSession()) {

            return (Order) session.createSQLQuery(SQL_GET_ORDER_BY_ROOM_AND_USER)
                    .setParameter("userId", userId)
                    .setParameter("roomId", roomId)
                    .addEntity(Order.class).getSingleResult();

        } catch (HibernateException e) {
            throw new InternalServerError(getClass().getSimpleName()+"-getOrderByRoomAndUser roomId: "+roomId+", userId: "+userId+" failed. "+e.getMessage());
        } catch (NoResultException noe){
            return null;
        }
    }
}