package servlets;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        final HttpSession session = request.getSession();
        request.setAttribute("message", "");
        User user = UserService.getInstance().getUserByLogin(login);
        String role = "";

        if (user != null) {
            if (!user.getPassword().equals(password)) {
                request.setAttribute("message", "password uncorrected");
                doGet(request, response);
            } else {
                session.setAttribute("user", user);
                //request.getRequestDispatcher("/admin/read").forward(request, response);
            }
        } else {
            if (login != null) {
                request.setAttribute("message", "login unknown");
            }
            doGet(request, response);
        }
        //requestDispatcher;
        session.setAttribute("user", user);
        response.sendRedirect("/admin");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }
}
