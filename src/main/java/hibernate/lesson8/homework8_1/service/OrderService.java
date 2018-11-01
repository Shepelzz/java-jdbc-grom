package hibernate.lesson8.homework8_1.service;

import hibernate.lesson8.homework8_1.dao.OrderDAO;
import hibernate.lesson8.homework8_1.dao.RoomDAO;
import hibernate.lesson8.homework8_1.exception.BadRequestException;
import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Order;
import hibernate.lesson8.homework8_1.model.Room;
import hibernate.lesson8.homework8_1.model.User;

import java.util.Calendar;
import java.util.Date;

public class OrderService {
    private OrderDAO orderDao;
    private RoomDAO roomDAO;

    public OrderService() {
        orderDao = new OrderDAO();
        roomDAO = new RoomDAO();
    }

    public void bookRoom(long roomId, long userId, double moneyPaid) throws InternalServerError {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 3);

        Room room = roomDAO.findById(roomId);
        User user = new User();
        user.setId(userId);

        Order order = new Order();
            order.setUser(user);
            order.setRoom(room);
            order.setDateFrom(new Date());
            order.setDateTo(c.getTime());
            order.setMoneyPaid(moneyPaid);

        validateNewOrder(order);
        room.setDateAvailableFrom(c.getTime());

        orderDao.bookRoom(order, room);
    }

    public void cancelReservation(long roomId, long userId) throws InternalServerError {
        if(orderDao.getOrderByRoomAndUser(roomId, userId) == null)
            throw new BadRequestException(getClass().getSimpleName()+"-cancelReservation. There is no order for room id:"+roomId+" and user id:"+userId);

        orderDao.cancelReservation(roomId, userId);
    }

    private void validateNewOrder(Order order) throws InternalServerError {
        long roomId = order.getRoom().getId();
        long userId = order.getUser().getId();

        if(orderDao.getOrderByRoomAndUser(order.getRoom().getId(), order.getUser().getId()) != null)
            throw new BadRequestException(getClass().getSimpleName()+"-bookRoom. Order room id:"+roomId+" is already booked by user id:"+userId+"");

        if(order.getRoom() == null)
            throw new BadRequestException(getClass().getSimpleName()+"-bookRoom. Room with id:"+roomId+" was not found");
        if(order.getRoom().getDateAvailableFrom().after(new Date()))
            throw new BadRequestException(getClass().getSimpleName()+"-bookRoom. Order room id:"+roomId+" is reserved from"+order.getRoom().getDateAvailableFrom());
        if(order.getRoom().getPrice() > order.getMoneyPaid())
            throw new BadRequestException(getClass().getSimpleName()+"-bookRoom. Order money paid is not enough");
    }
}
