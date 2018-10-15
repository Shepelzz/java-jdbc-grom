package hibernate.lesson8.homework8_1.service;

import hibernate.lesson8.homework8_1.dao.OrderDAO;
import hibernate.lesson8.homework8_1.dao.RoomDAO;
import hibernate.lesson8.homework8_1.exception.BadRequestException;
import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Room;

import java.util.Date;

public class OrderService {
    private OrderDAO orderDao;

    public OrderService() {
        orderDao = new OrderDAO();
    }

    public void bookRoom(long roomId, long userId, double moneyPaid) throws InternalServerError {
        if(orderDao.getOrderByRoomAndUser(roomId, userId) != null)
            throw new BadRequestException(getClass().getSimpleName()+"-bookRoom. Order room id:"+roomId+" is already booked by user id:"+userId+"");

        Room room = new RoomDAO().findById(roomId);
        if(room == null)
            throw new BadRequestException(getClass().getSimpleName()+"-bookRoom. Room with id:"+roomId+" was not found");
        if(room.getDateAvailableFrom().after(new Date()))
            throw new BadRequestException(getClass().getSimpleName()+"-bookRoom. Order room id:"+roomId+" is reserved from"+room.getDateAvailableFrom());
        if(room.getPrice() > moneyPaid)
            throw new BadRequestException(getClass().getSimpleName()+"-bookRoom. Order money paid is not enough");

        orderDao.bookRoom(roomId, userId, moneyPaid);
    }

    public void cancelReservation(long roomId, long userId) throws InternalServerError {
        if(orderDao.getOrderByRoomAndUser(roomId, userId) == null)
            throw new BadRequestException(getClass().getSimpleName()+"-cancelReservation. There is no order for room id:"+roomId+" and user id:"+userId);

        orderDao.cancelReservation(roomId, userId);
    }
}
