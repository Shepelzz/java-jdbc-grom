package hibernate.lesson8.homework8_1.demo;

import hibernate.lesson8.homework8_1.controller.OrderController;
import hibernate.lesson8.homework8_1.controller.UserController;

public class DemoOrder {
    public static void main(String[] args){
                //резервация
        try{
            OrderController orderController = new OrderController();
            new UserController().login("Vasya1", "1111");
//
//            orderController.bookRoom(7844817112075325089L, 6899483617267971553L, 5800);
        }catch (Exception e){
            System.err.println(e.toString());
        }

        //отмена резервации
        try{
            OrderController orderController = new OrderController();
            UserController userController = new UserController();
            //userController.login("Vasya", "1111");

            //orderController.cancelReservation(7713581945862736410L, UserDAO.getLoggedUser().getId());

        }catch (Exception e){
            System.err.println(e.toString());
        }
    }
}
