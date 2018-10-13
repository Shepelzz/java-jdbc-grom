package hibernate.lesson8.homework8_1.dao;

import hibernate.lesson8.homework8_1.exception.BadRequestException;
import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.exception.PermissionError;
import hibernate.lesson8.homework8_1.model.User;
import hibernate.lesson8.homework8_1.model.types.UserType;

public class Session {
    private static User loggedUser = null;

    public static void login(String userName, String password) throws InternalServerError {
        User user = new UserDAO().getUserByLoginAndPassword(userName, password);
        if(user == null)
            throw  new BadRequestException("login", "User with name: "+userName+" was not found, or password is incorrect");
        if(loggedUser != null)
            throw new BadRequestException("login", "You are already logged as user: "+loggedUser.getUserName());
        Session.loggedUser = user;
    }

    public static void logout(){
        if(loggedUser == null)
            throw new BadRequestException("logout", "No user is logged in.");
        loggedUser = null;
    }

    public static void checkAuthorization(String action) throws BadRequestException {
        if(loggedUser == null)
            throw new BadRequestException(action, "You must be logged in system for perform this operation");
    }

    public static void checkAuthorization(String action, UserType userType){
        checkAuthorization(action);
        if(!loggedUser.getUserType().equals(userType))
            throw new PermissionError(action, "User must have "+userType.getName()+" permissions to perform this operation");
    }


}
