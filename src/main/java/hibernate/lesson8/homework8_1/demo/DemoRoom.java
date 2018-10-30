package hibernate.lesson8.homework8_1.demo;

import hibernate.lesson8.homework8_1.controller.RoomController;
import hibernate.lesson8.homework8_1.controller.UserController;
import hibernate.lesson8.homework8_1.model.Filter;
import hibernate.lesson8.homework8_1.model.Room;

import java.util.Date;

public class DemoRoom {
    public static void main(String[] args) throws Exception{
        RoomController roomController = new RoomController();
        UserController userController = new UserController();


        //добавление комнаты
//            userController.login("admin", "1");
//            Room room = new Room();
//                room.setPrice(870);
//                room.setPetsAllowed(false);
//                room.setBreakfastIncluded(true);
//                room.setDateAvailableFrom(new Date());
//                room.setNumberOfGuests(6);
//                room.setHotel(new HotelDAO().findById(4));
//
//        System.out.println(roomController.addRoom(room));


        //удаление комнаты

            userController.login("admin", "1");
//            roomController.deleteRoom(new RoomDAO().findById(21));

        //поиск по фильтру


            Filter filter = new Filter();
            filter.setBreakfastIncluded(true);
            filter.setNumberOfGuests(2);
            filter.setPrice(1000);
            filter.setDateAvailableFrom(new Date());

        for(Room r : roomController.findRooms(filter))
            System.out.println(r.toString());

    }
}
