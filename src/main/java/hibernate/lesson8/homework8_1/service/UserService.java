package hibernate.lesson8.homework8_1.service;

import hibernate.lesson8.homework8_1.dao.UserDAO;
import hibernate.lesson8.homework8_1.dao.UserSession;
import hibernate.lesson8.homework8_1.exception.BadRequestException;
import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.User;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public User registerUser(User user) throws InternalServerError {
        if (user.getUserName().equals("") || user.getPassword().equals("") || user.getCountry().equals(""))
            throw new BadRequestException(getClass().getSimpleName()+"-registerUser. Values can not be empty");
        if(userDAO.getUserByLoginAndPassword(user.getUserName(), user.getPassword()) != null)
            throw new BadRequestException(getClass().getSimpleName()+"-registerUser. User with user name: "+user.getUserName()+" is already registered.");

        return userDAO.registerUser(user);
    }

    public void login(String userName, String password) throws InternalServerError {
        UserSession.login(userName, password);
    }

    public void logout(){
        UserSession.logout();
    }

}
