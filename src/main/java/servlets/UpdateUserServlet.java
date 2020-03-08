package ru.javamentor.servlets;

import ru.javamentor.dao.UserDAO;
import ru.javamentor.model.User;
import ru.javamentor.utils.Util;

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
    private Map<Integer, User> users;

    @Override
    public void init() throws ServletException {

        final Object users = getServletContext().getAttribute("users");

        if (users == null || !(users instanceof ConcurrentHashMap)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {

            this.users = (ConcurrentHashMap<Integer, User>) users;
        }
    }

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
            // users.remove(Integer.valueOf(req.getParameter("id")));
        }
        //resp.sendRedirect(req.getContextPath() + "/");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final String id = req.getParameter("id");

//        if (Util.idIsInvalid(id, users)) {
//            resp.sendRedirect(req.getContextPath() + "/");
//            return;
//        }

        final User user = UserDAO.selectUserById(Integer.parseInt(id));
        req.setAttribute("user", user);

        req.getRequestDispatcher("/WEB-INF/view/update.jsp")
                .forward(req, resp);
    }
}
