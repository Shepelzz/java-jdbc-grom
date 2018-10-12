package hibernate.lesson8.homework8_1.dao;

import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Entity;
import hibernate.lesson8.homework8_1.model.Order;
import hibernate.lesson8.homework8_1.model.Room;
import hibernate.lesson8.homework8_1.model.User;

import java.util.Calendar;
import java.util.Date;

public class OrderDAO extends GeneralDAO<Order>{
    private static final String path = "files/OrderDb.txt";

    public OrderDAO() throws InternalServerError {
        super(path);
    }

    public void bookRoom(long roomId, long userId, double moneyPaid) throws InternalServerError {
        RoomDAO roomDAO = new RoomDAO();

        Calendar c = Calendar.getInstance();
        Date currentDate = new Date();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 3);

        Entity user = new User().setId(userId);
        Entity room = new Room().setId(roomId);
        Room updatedRoom = roomDAO.getEntityById(roomId);

        Order order = new Order();
        order.setUser((User) user);
        order.setRoom((Room) room);
        order.setDateFrom(new Date());
        order.setDateTo(c.getTime());
        order.setMoneyPaid(moneyPaid);
        writeToFile(order);

        updatedRoom.setDateAvailableFrom(c.getTime());
        roomDAO.updateEntity(updatedRoom);
    }

    public void cancelReservation(long roomId, long userId) throws InternalServerError {
        RoomDAO roomDAO = new RoomDAO();

        Room updatedRoom = roomDAO.getEntityById(roomId);
        updatedRoom.setDateAvailableFrom(new Date());

        roomDAO.updateEntity(updatedRoom);
        deleteFromFileById(getOrderByRoomAndUser(roomId, userId).getId());
    }

    public Order getOrderByRoomAndUser(long roomId, long userId) throws InternalServerError {
        for(Order order : getAll())
            if(order.getRoom().getId() == roomId && order.getUser().getId() == userId)
                return order;
        return null;
    }

    @Override
    public Order parseStringToObject(String input) throws InternalServerError {
        return new Order().parseStringToObject(input);
    }
}