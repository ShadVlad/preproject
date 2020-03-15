package servlets;

import model.User;
import service.UserService;
import utils.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        if (Util.requestIsValid(req)) {

            final String name = req.getParameter("name");
            final String surName = req.getParameter("surname");
            final String age = req.getParameter("age");
            final String email = req.getParameter("email");

            User user = new User();

            user.setAge(Integer.valueOf(age));
            user.setName(name);
            user.setSurname(surName);
            user.setEmail(email);

            UserService.getInstance().addUser(user);
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }
}
