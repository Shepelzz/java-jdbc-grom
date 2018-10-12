package hibernate.lesson8.homework8_1.model;

import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.types.UserType;


public class User extends Entity{
    private String userName;
    private String password;
    private String country;
    private UserType userType;

    public User() {}

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public User parseStringToObject(String input) throws InternalServerError {
        String[] data = input.split(",");
        try {
            setId(Long.valueOf(data[0]));
            userName = data[1];
            password = data[2];
            country = data[3];
            userType = UserType.valueOf(data[4]);
            return this;
        }catch (Exception e){
            throw new InternalServerError(getClass().getName(), "parseStringToObject","error parsing text data ["+input+"]", e.getMessage());
        }
    }

    @Override
    public String toString() {
        return
                (getId() == 0 ? "" : getId()+",")+
                        userName+","+
                        password+","+
                        country+","+
                        userType.toString();
    }
}