package service;

import dao.UserDAO;
import dao.UserDAOFactory;
import dao.UserHibernateDAO;
import model.User;
import org.hibernate.SessionFactory;
import utils.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserService instance;
    //private SessionFactory sessionFactory;
    private static UserDAO userDAO;

    public UserService() {
    }

//    public UserService(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    public static UserService getInstance() {
        if (instance == null  || userDAO == null) {
            instance = new UserService();
            userDAO = new UserDAOFactory().getDAO();
        }
        return instance;
    }

    public List<User> getAllUsers() {
        List<User> getAllUsers = null;
        try {
            getAllUsers = userDAO.selectAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getAllUsers;
    }

    public User getUserById(int id) {
        User user = null;
        try {
            user = userDAO.selectUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addUser(User user) {
        try {
            userDAO.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateUser(User user) {
        boolean updateUser = false;
        try {
            updateUser = userDAO.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateUser;
    }

    public boolean deleteUser(int id) {
        boolean deleteUser = false;
        try {
            deleteUser = userDAO.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleteUser;
    }
}
