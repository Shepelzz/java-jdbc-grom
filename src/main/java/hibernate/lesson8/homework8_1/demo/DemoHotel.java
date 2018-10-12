package hibernate.lesson8.homework8_1.demo;


import hibernate.lesson8.homework8_1.controller.HotelController;

public class DemoHotel {
    public static void main(String[] args){


        //добавление отеля
        try{
//            HotelController hotelController = new HotelController();
//            UserController userController = new UserController();
//            userController.login("admin", "admin");
            //hotelController.addHotel(new Hotel("", "Russia", "Moscow", "testStreet"));

        }catch (Exception e){
            System.err.println(e.toString());
        }


        //удаление отеля
        try{
//            HotelController hotelController = new HotelController();
//            UserController userController = new UserController();
//            userController.login("admin", "admin");
            //hotelController.deleteHotel(26540059603440722L);

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        //поиск отеля по имени
        try{
            HotelController hotelController = new HotelController();
            System.out.println(hotelController.findHotelByName("Mot"));
        }catch (Exception e){
            System.err.println(e.getMessage());
        }


        //поиск отелей по городу
        try{

//            HotelController hotelController = new HotelController();
//            System.out.println(hotelController.findHotelByCity("Odessa"));

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}