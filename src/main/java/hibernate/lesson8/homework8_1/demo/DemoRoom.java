package hibernate.lesson8.homework8_1.demo;

import hibernate.lesson8.homework8_1.controller.RoomController;
import hibernate.lesson8.homework8_1.controller.UserController;

public class DemoRoom {
    public static void main(String[] args){


        //добавление комнаты
        try{
            RoomController roomController = new RoomController();
            UserController userController = new UserController();
            //userController.login("admin1", "admin");
            //Room room = new Room(2, 700, true, true, new Date(), new HotelDAO().getEntityById(1376800431651742536L));

            //roomController.addRoom(room);

        }catch (Exception e){
            System.err.println(e.toString());
        }

        //удаление комнаты
        try{
            RoomController roomController = new RoomController();
            UserController userController = new UserController();
            //userController.login("admin1", "admin");

            //roomController.deleteRoom(1410327107726515362L);

        }catch (Exception e){
            System.err.println(e.toString());
        }

        //поиск по фильтру
        try{
            RoomController roomController = new RoomController();
            UserController userController = new UserController();
            userController.login("user2", "pass2");

//            Filter filter = Filter.newFilterBuilder()
//                    .setNumberOfGuests(2)
//                    .setPrice(900)
//                    .setBreakfastIncluded(true)
//                    .setPetsAllowed(true)
//                    .setDateAvailableFrom(new Date())
//                    .build();
//            roomController.findRooms(filter).forEach(x -> System.out.println(x.toString()));

        }catch (Exception e){
            System.err.println(e.toString());
        }

    }
}
