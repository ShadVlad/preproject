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

    public List<User> selectAllUsers() throws SQLException {
        Transaction transaction = session.beginTransaction();
        List<User> allUsers = new ArrayList<>(session.createQuery("from users").list());
        transaction.commit();
        session.close();
        return allUsers;
    }
    public void addUser(User user) throws SQLException {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdate;
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update users set " +
                "name = :paramName," +
                "surname = :paramSurname," +
                "age = :paramAge," +
                "email = :paramEmail," +
                "where id = :paramId");
        query.setParameter("name", user.getName());
        query.setParameter("surname", user.getSurname());
        query.setParameter("age", user.getAge());
        query.setParameter("email", user.getEmail());
        rowUpdate = query.executeUpdate() > 0;
        transaction.commit();
        session.close();
        return rowUpdate;
    }

    public User selectUserById(long id) throws SQLException {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from users where id = :paramId");
        User user = (User) query.setParameter("paramId", id);
        transaction.commit();
        session.close();
        return user;
    }
    public boolean deleteUser(long id) throws SQLException {
        boolean rowDelete;
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete users where id = :paramId");
        query.setParameter("paramId", id);
        rowDelete = query.executeUpdate() > 0;
        transaction.commit();
        session.close();
        return rowDelete;
    }

}
