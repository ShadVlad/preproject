package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.DBHelper;
import utils.ReaderOfProperties;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class UserDAOFactory {
    private static UserDAOFactory instance;
    private static UserDAO dao;

    public UserDAOFactory() {
    }

    public static UserDAOFactory getInstance() {
        if (instance == null) {
            instance = new UserDAOFactory();
        }
        return instance;
    }


    public static UserDAO getDAO() {
        dao = null;
        Properties properties = ReaderOfProperties.getProperties("config.properties");
        String typeOfConnect = properties.getProperty("TypeOfConnect");
        if (typeOfConnect.equalsIgnoreCase("hibernate")) {
            Session session = DBHelper.getSessionFactory().openSession();
            dao = UserHibernateDAO.getInstance(session);

        } else //if (DBHelper.readProperty("MethodToConnectDB").equalsIgnoreCase("JDBC"))
        {
            Connection connection = DBHelper.getConnection();
            dao = UserJdbcDAO.getInstance(connection);

        }
        return dao;
    }

}

