package servlets;

import dao.UserDAO;
import model.User;
import utils.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    //private Map<Integer, User> users;

    @Override
    public void init() throws ServletException {

//        final Object users = getServletContext().getAttribute("users");
//
//        if (users == null || !(users instanceof ConcurrentHashMap)) {
//
//            throw new IllegalStateException("You're repo does not initialize!");
//        } else {
//
//            this.users = (ConcurrentHashMap<Integer, User>) users;
//        }
    }

//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//        throws ServletException, IOException {
//
//    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        if (Util.idIsNumber(req)) {
            try {
                boolean status = UserDAO.deleteUser(Integer.valueOf(req.getParameter("id")));
                resp.sendRedirect(req.getContextPath() + "/");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // users.remove(Integer.valueOf(req.getParameter("id")));
        }

    }
}
