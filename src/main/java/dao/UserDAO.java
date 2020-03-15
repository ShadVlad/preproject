package dao;

import model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    List<User> selectAllUsers() throws SQLException ;

    void addUser(User user) throws SQLException ;

    boolean updateUser(User user) throws SQLException;

    User selectUserById(int id) throws SQLException;

    boolean deleteUser(int id) throws SQLException;
}