package hibernate.lesson8.homework8_1.controller;

import hibernate.lesson8.homework8_1.dao.UserSession;
import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Filter;
import hibernate.lesson8.homework8_1.model.Room;
import hibernate.lesson8.homework8_1.model.types.UserType;
import hibernate.lesson8.homework8_1.service.RoomService;

import java.util.List;
import java.util.Set;

public class RoomController {
    private RoomService roomService;

    public RoomController() {
        roomService = new RoomService();
    }

    //ADMIN
    public Room addRoom(Room room) throws InternalServerError {
        UserSession.checkAuthorization("addRoom", UserType.ADMIN);
        return roomService.addRoom(room);
    }

    //ADMIN
    public void deleteRoom(Room room) throws InternalServerError {
        UserSession.checkAuthorization("deleteRoom", UserType.ADMIN);
        roomService.deleteRoom(room);
    }

    public List<Room> findRooms(Filter filter) throws InternalServerError {
        UserSession.checkAuthorization("findRooms");
        return roomService.findRooms(filter);
    }

}
