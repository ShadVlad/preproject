package service;

import dao.UserHibernateDAO;
import model.User;
import org.hibernate.SessionFactory;
import utils.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserService userService;
    private SessionFactory sessionFactory;

    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService(DBHelper.getSessionFactory());
        }
        return userService;
    }

    public List<User> getAllUsers() {
        List<User> getAllUsers = null;
        try {
            getAllUsers = new UserHibernateDAO(sessionFactory.openSession()).selectAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getAllUsers;
    }

    public User getUserById(int id) {
        User user = null;
        try {
            user = new UserHibernateDAO(sessionFactory.openSession()).selectUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addUser(User user) {
        try {
            new UserHibernateDAO(sessionFactory.openSession()).addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        boolean updateUser = false;
        try {
            new UserHibernateDAO(sessionFactory.openSession()).updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return updateUser;
    }

    public boolean deleteUser(int id) {
        boolean deleteUser = false;
        try {
            deleteUser = new UserHibernateDAO(sessionFactory.openSession()).deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleteUser;
    }
}
