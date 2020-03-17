package dao;

import model.User;
import utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, surname, age, email) VALUES "
            + " (?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,surname,age,email,login,password,role from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name=?,surname=?,age=?,email=?,login=?, "
            + "password=?,role=? where id = ?";

    private static UserJdbcDAO instance;
    private final Connection connection;

    public UserJdbcDAO(Connection connection) {
        this.connection = connection;
    }

    static UserJdbcDAO getInstance(Connection connection) {
        if (instance == null) {
            instance = new UserJdbcDAO(connection);
        }
        return instance;
    }

    private static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DBHelper.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String surname = resultSet.getString("surname");
//                Integer age = resultSet.getInt("age");
//                String email = resultSet.getString("email");
//                String login = resultSet.getString("login");
//                String password = resultSet.getString("password");
//                String role = resultSet.getString("role");
                //User user = UserFromResultSet(id, resultSet);
                users.add(UserFromResultSet(id, resultSet));
            }
            connection.close();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public void addUser(User user) throws SQLException {
        //boolean rowAdded = false;
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getLogin());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, user.getLogin());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            //rowAdded = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        //return rowAdded;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getLogin());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, user.getRole());
            preparedStatement.setInt(8, user.getId());
            //preparedStatement.executeUpdate();
            rowUpdated = preparedStatement.executeUpdate() > 0;
            connection.close();
        }
        return rowUpdated;
    }

    @Override
    public User selectUserById(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = DBHelper.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                String surname = resultSet.getString("surname");
//                Integer age = resultSet.getInt("age");
//                String email = resultSet.getString("email");
//                String login = resultSet.getString("login");
//                String password = resultSet.getString("password");
//                String role = resultSet.getString("role");
//                user = new User(id, name, surname, age, email, login, password, role);
                user = UserFromResultSet(id, resultSet);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    private User UserFromResultSet(int id, ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        Integer age = resultSet.getInt("age");
        String email = resultSet.getString("email");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        String role = resultSet.getString("role");
        return new User(id, name, surname, age, email, login, password, role);
    }
}
