package hibernate.lesson8.homework8_1.demo;


import hibernate.lesson8.homework8_1.controller.HotelController;
import hibernate.lesson8.homework8_1.controller.UserController;
import hibernate.lesson8.homework8_1.dao.HotelDAO;
import hibernate.lesson8.homework8_1.dao.RoomDAO;

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

        HotelDAO hotelDAO = new HotelDAO();
        System.out.println(hotelDAO.findById(3).toString());

        RoomDAO roomDAO = new RoomDAO();
        System.out.println(roomDAO.findById(13).toString());
    }
}