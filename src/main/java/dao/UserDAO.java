package dao;

import model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    static List<User> selectAllUsers() throws SQLException {
        return null;
    }

    static boolean addUser(User user) throws SQLException {
        return false;
    }

    static boolean updateUser(User user) throws SQLException {
        return false;
    }

    static User selectUserById(long id) throws SQLException {
        return null;
    }

    static boolean deleteUser(long id) throws SQLException {
        return false;
    }
}