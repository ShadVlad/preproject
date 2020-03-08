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

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final String id = req.getParameter("id");
        final String name = req.getParameter("name");
        final String surName = req.getParameter("surname");
        final String age = req.getParameter("age");
        final String email = req.getParameter("email");

        final User user = UserDAO.selectUserById(Integer.parseInt(id));
        user.setName(name);
        user.setSurname(surName);
        user.setAge(Integer.parseInt(age));
        user.setEmail(email);
        if (Util.idIsNumber(req)) {
            try {
                boolean status = UserDAO.updateUser(user);
                resp.sendRedirect(req.getContextPath() + "/");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final String id = req.getParameter("id");

        final User user = UserDAO.selectUserById(Integer.parseInt(id));
        req.setAttribute("user", user);

        req.getRequestDispatcher("/WEB-INF/view/update.jsp")
                .forward(req, resp);
    }
}
