package hibernate.lesson8.homework8_1.controller;

import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Filter;
import hibernate.lesson8.homework8_1.model.Room;
import hibernate.lesson8.homework8_1.service.RoomService;

import java.util.Set;

public class RoomController {
    private RoomService roomService;

    public RoomController() throws InternalServerError {
        roomService = new RoomService();
    }

    //ADMIN
    public Room addRoom(Room room) throws InternalServerError {
//        Session.checkAuthorization("addRoom", UserType.ADMIN);
//        return roomService.addRoom(room);
        return null;
    }

    //ADMIN
    public void deleteRoom(Room room) throws InternalServerError {
//        Session.checkAuthorization("deleteRoom", UserType.ADMIN);
//        roomService.deleteRoom(roomId);
    }

    public Set<Room> findRooms(Filter filter) throws InternalServerError {
//        Session.checkAuthorization("findRooms");
//        return roomService.findRooms(filter);
        return null;
    }

}
