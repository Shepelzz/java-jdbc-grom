package hibernate.lesson8.homework8_1.dao;

import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Hotel;
import hibernate.lesson8.homework8_1.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class UserDAO extends GeneralDAO<User>{
    private static final String SQL_FIND_USER_BY_NAME_AND_PASS = "SELECT * FROM FP_USER WHERE USER_NAME = :userName AND PASSWORD = :password";

    public User registerUser(User user) throws InternalServerError {
        return save(user);
    }

    public User getUserByLoginAndPassword(String userName, String password) throws InternalServerError {
        try (Session session = createSessionFactory().openSession()) {

            return (User) session.createSQLQuery(SQL_FIND_USER_BY_NAME_AND_PASS)
                    .setParameter("userName", userName)
                    .setParameter("password", password)
                    .addEntity(User.class).getSingleResult();

        } catch (HibernateException e) {
            throw new InternalServerError(getClass().getName()+"-getUserByLoginAndPassword "+userName+" failed. "+e.getMessage());
        }
    }

    @Override
    User findById(long id) throws InternalServerError {
        try (Session session = createSessionFactory().openSession()) {

            return session.get(User.class, id);

        } catch (HibernateException e) {
            throw new InternalServerError(getClass().getName()+"-findById: "+id+" failed. "+e.getMessage());
        }
    }
}