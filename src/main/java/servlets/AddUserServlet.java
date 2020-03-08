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
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    private Map<Integer, User> users;

    private AtomicInteger id;

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
//
//        id = new AtomicInteger(2);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        if (Util.requestIsValid(req)) {

            final String name = req.getParameter("name");
            final String surName = req.getParameter("surname");
            final String age = req.getParameter("age");
            final String email = req.getParameter("email");

            User user = new User();

//            final User user = new User();
            //final int id = this.id.getAndIncrement();
            //user.setId(id);
            user.setAge(Integer.valueOf(age));
            user.setName(name);
            user.setSurname(surName);
            user.setEmail(email);
//
//            users.put(id, user);

            try {
                boolean status = UserDAO.addUser(user);
                resp.sendRedirect(req.getContextPath() + "/");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
