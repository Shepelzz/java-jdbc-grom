package hibernate.lesson8.homework8_1.service;

import hibernate.lesson8.homework8_1.dao.RoomDAO;
import hibernate.lesson8.homework8_1.exception.BadRequestException;
import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Filter;
import hibernate.lesson8.homework8_1.model.Room;

import java.util.List;

public class RoomService {
    private RoomDAO roomDAO;

    public RoomService() {
        roomDAO = new RoomDAO();
    }

    //ADMIN
    public Room addRoom(Room room) throws InternalServerError {
        if(room.getNumberOfGuests() <= 0 || room.getPrice() <= 0 || room.getDateAvailableFrom() == null)
            throw new BadRequestException(getClass().getSimpleName()+"-addRoom. Values can not be empty");

        return roomDAO.addRoom(room);
    }

    //ADMIN
    public void deleteRoom(Room room) throws InternalServerError {
        roomDAO.deleteRoom(room);
    }

    public List<Room> findRooms(Filter filter) throws InternalServerError {
//        if(filter.getDateAvailableFrom().after(new Date()))
//            throw new BadRequestException(getClass().getSimpleName()+"-findRooms. Date can not be earlier than current");

        return roomDAO.findRooms(filter);
    }
}
