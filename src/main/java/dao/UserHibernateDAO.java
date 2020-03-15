package dao;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserHibernateDAO implements UserDAO {

    private Session session;
    public UserHibernateDAO(Session session) {
        this.session = session;
    }

    private static UserHibernateDAO instance;
    static UserHibernateDAO getInstance(Session session) {
        if (instance == null) {
            instance = new UserHibernateDAO(session);
        }
        return instance;
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        Transaction transaction = session.beginTransaction();
        List<User> allUsers = new ArrayList<>(session.createQuery("from users").list());
        transaction.commit();
        //session.close();
        return allUsers;
    }

    @Override
    public void addUser(User user) throws SQLException {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        //session.close();
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdate;
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        //session.close();
        return true;
    }

    @Override
    public User selectUserById(int id) throws SQLException {
        //Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from users where id = :paramId");
        List<User> userList = query.setParameter("paramId", id).list();
        User user = null;
        for (User u : userList) {
            if (u.getId() == id) {
                user = u;
            }
        }
        transaction.commit();
        //session.close();
        return user;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDelete;
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete users where id = :paramId");
        query.setParameter("paramId", id);
        rowDelete = query.executeUpdate() > 0;
        transaction.commit();
        //session.close();
        return rowDelete;
    }

}
