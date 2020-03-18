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
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        final String role = req.getParameter("role");

        final User user = UserService.getInstance().getUserById(Integer.parseInt(id));
        user.setName(name);
        user.setSurname(surName);
        user.setAge(Integer.parseInt(age));
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);

        if (Util.idIsNumber(req)) {
            //boolean status =
            UserService.getInstance().updateUser(user);
            resp.sendRedirect(req.getContextPath() + "/admin");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final String id = req.getParameter("id");

        final User user = UserService.getInstance().getUserById(Integer.parseInt(id));
        //final User user = UserJdbcDAO.selectUserById(Integer.parseInt(id));
        req.setAttribute("user", user);

        req.getRequestDispatcher("/WEB-INF/view/update.jsp")
                .forward(req, resp);
    }
}
