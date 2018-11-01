package hibernate.lesson8.homework8_1.demo;

import hibernate.lesson8.homework8_1.controller.OrderController;
import hibernate.lesson8.homework8_1.controller.UserController;

public class DemoOrder {
    public static void main(String[] args) throws Exception{
        OrderController orderController = new OrderController();
        UserController userController = new UserController();

        //резервация
        userController.login("user", "1");
        orderController.bookRoom(16, 3, 21040);

//        RoomDAO roomDAO = new RoomDAO();
//        System.out.println(roomDAO.findById(16));

        //отмена резервации

//        userController.login("admin", "1");
//        orderController.cancelReservation(16, 3);

    }
}
