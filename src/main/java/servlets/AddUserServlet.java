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

@WebServlet("/admin/add")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //req.setAttribute("message", "");
        req.getRequestDispatcher("/WEB-INF/view/add.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        final String login = req.getParameter("login");
        if (login == "") {
            req.setAttribute("message", "login not be empty");
            doGet(req, resp);
        } else {
            User user = UserService.getInstance().getUserByLogin(login);
            if (user != null) {
                req.setAttribute("message", "login already exists");
                doGet(req, resp);
            } else {
                req.setCharacterEncoding("UTF-8");
                final String name = req.getParameter("name");
                final String surName = req.getParameter("surname");
                final String age = req.getParameter("age");
                final String email = req.getParameter("email");
                final String password = req.getParameter("password");
                final String role = req.getParameter("role");

                user = new User();
                user.setAge(Integer.valueOf(age));
                user.setName(name);
                user.setSurname(surName);
                user.setEmail(email);
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(role);

                UserService.getInstance().addUser(user);
                resp.sendRedirect("/admin");
            }
        }
    }
}
