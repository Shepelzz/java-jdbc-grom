package hibernate.lesson8.homework8_1.demo;


import hibernate.lesson8.homework8_1.controller.HotelController;
import hibernate.lesson8.homework8_1.controller.OrderController;
import hibernate.lesson8.homework8_1.controller.UserController;
import hibernate.lesson8.homework8_1.dao.*;
import hibernate.lesson8.homework8_1.model.Hotel;
import hibernate.lesson8.homework8_1.model.Room;
import hibernate.lesson8.homework8_1.model.User;
import hibernate.lesson8.homework8_1.model.types.UserType;

import java.util.Arrays;
import java.util.Date;

public class DemoHotel {
    public static void main(String[] args) throws Exception{
        HotelController hotelController = new HotelController();
        UserController userController = new UserController();

        //добавление отеля
//        userController.login("admin", "1");
//        Hotel hotel = new Hotel();
//            hotel.setName("test");
//            hotel.setCountry("RU");
//            hotel.setCity("test");
//            hotel.setStreet("test");
//        hotelController.addHotel(hotel);


        //удаление отеля
        //userController.login("admin", "1");
        //hotelController.deleteHotel(new HotelDAO().findById(21));

        //поиск отеля по имени
//        userController.login("user", "1");
//        System.out.println(hotelController.findHotelByName("test"));


        //поиск отелей по городу
//        userController.login("user", "1");
//        System.out.println(hotelController.findHotelByCity("Odessa"));



    }
}