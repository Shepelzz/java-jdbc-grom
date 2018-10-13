package hibernate.lesson8.homework8_1.service;

import hibernate.lesson8.homework8_1.dao.Session;
import hibernate.lesson8.homework8_1.dao.UserDAO;
import hibernate.lesson8.homework8_1.exception.BadRequestException;
import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.User;

public class UserService {
    private UserDAO userDAO;

    public UserService() throws InternalServerError {
        userDAO = new UserDAO();
    }

    public User registerUser(User user) throws InternalServerError {
//        if (user.getUserName().equals("") || user.getPassword().equals("") || user.getCountry().equals(""))
//            throw new BadRequestException("registerUser", "values can not be empty");
//        if(userDAO.getUserByLoginAndPassword(user.getUserName(), user.getPassword()) != null)
//            throw new BadRequestException("registerUser", "User with user name: "+user.getUserName()+" is already registered.");
//
//        return userDAO.registerUser(user);
        return null;
    }

    public void login(String userName, String password) throws InternalServerError {
//        Session.login(userName, password);
    }

    public void logout(){
//        Session.logout();
    }

}
