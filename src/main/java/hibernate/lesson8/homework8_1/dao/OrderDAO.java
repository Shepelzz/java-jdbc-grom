package hibernate.lesson8.homework8_1.dao;

import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.GeneralModel;
import hibernate.lesson8.homework8_1.model.Order;
import hibernate.lesson8.homework8_1.model.Room;
import hibernate.lesson8.homework8_1.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Calendar;
import java.util.Date;

public class OrderDAO extends GeneralDAO<Order>{
    private static final String SQL_GET_ORDER_BY_ROOM_AND_USER = "SELECT * FROM FP_ORDER WHERE USER_ID = :userId AND ROOM_ID = :roomId";

    public void bookRoom(long roomId, long userId, double moneyPaid) throws InternalServerError {
        Transaction transaction = null;
        RoomDAO roomDAO = new RoomDAO();
        UserDAO userDAO = new UserDAO();

        Calendar c = Calendar.getInstance();
        Date currentDate = new Date();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 3);

        try (Session session = createSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            User user = userDAO.findById(userId);
            Room room = roomDAO.findById(roomId);

            Order order = new Order();
                order.setUser(user);
                order.setRoom(room);
                order.setDateFrom(new Date());
                order.setDateTo(c.getTime());
                order.setMoneyPaid(moneyPaid);

            save(order, transaction); //TODO ??????

            room.setDateAvailableFrom(c.getTime());
            roomDAO.update(room);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
        }
    }

    public void cancelReservation(long roomId, long userId) throws InternalServerError {

    }

    public Order getOrderByRoomAndUser(long roomId, long userId) throws InternalServerError {
        try (Session session = createSessionFactory().openSession()) {

            return (Order) session.createSQLQuery(SQL_GET_ORDER_BY_ROOM_AND_USER)
                    .setParameter("userId", userId)
                    .setParameter("roomId", roomId)
                    .addEntity(Order.class).getSingleResult();

        } catch (HibernateException e) {
            throw new InternalServerError(getClass().getName()+"-getOrderByRoomAndUser roomId: "+roomId+", userId: "+userId+" failed. "+e.getMessage());
        }
    }

    @Override
    Order findById(long id) throws InternalServerError {
        try (Session session = createSessionFactory().openSession()) {

            return session.get(Order.class, id);

        } catch (HibernateException e) {
            throw new InternalServerError(getClass().getName()+"-findById: "+id+" failed. "+e.getMessage());
        }
    }
}