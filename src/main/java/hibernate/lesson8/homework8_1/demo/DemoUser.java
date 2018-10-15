package hibernate.lesson8.homework8_1.demo;

import hibernate.lesson8.homework8_1.controller.UserController;
import hibernate.lesson8.homework8_1.dao.UserSession;
import hibernate.lesson8.homework8_1.model.User;
import hibernate.lesson8.homework8_1.model.types.UserType;
import org.hibernate.Session;

public class DemoUser {
    public static void main(String[] args) throws Exception{
        UserController userController = new UserController();

        //регистрация юзера
//            User user = new User();
//            user.setUserName("Test12");
//            user.setCountry("UR");
//            user.setPassword("1111");
//            user.setUserType(UserType.ADMIN);
//
//            System.out.println(userController.registerUser(user));

        //логин

            //userController.login("Zhenya", "qwer1111");


        //System.out.println(UserDAO.getLoggedUser());

        //логаут
        //userController.logout();


    }
}
