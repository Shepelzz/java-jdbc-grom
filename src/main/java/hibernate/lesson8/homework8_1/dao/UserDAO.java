package hibernate.lesson8.homework8_1.dao;

import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.User;

public class UserDAO extends GeneralDAO<User>{
    private static final String path = "files/UserDb.txt";

    public UserDAO() throws InternalServerError {
        super(path);
    }

    public User registerUser(User user) throws InternalServerError {
        return writeToFile(user);
    }

    public User getUserByLoginAndPassword(String userName, String password) throws InternalServerError {
        for(User user : getAll())
            if(user.getUserName().equals(userName) && user.getPassword().equals(password))
                return user;
        return null;
    }

    @Override
    public User parseStringToObject(String input) throws InternalServerError {
        return new User().parseStringToObject(input);
    }
}