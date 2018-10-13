package hibernate.lesson8.homework8_1.controller;

import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.User;
import hibernate.lesson8.homework8_1.service.UserService;

public class UserController {
    private UserService userService;

    public UserController() throws InternalServerError {
        userService = new UserService();
    }

    public User registerUser(User user) throws InternalServerError {
//        return userService.registerUser(user);
        return null;
    }

    public void login(String userName, String password) throws InternalServerError {
//        userService.login(userName, password);
    }

    public void logout(){
//        userService.logout();
    }

}
