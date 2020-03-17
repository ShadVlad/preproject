package servlets;

//import dao.UserJdbcDAO;
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
import java.util.List;

@WebServlet("/admin")
public class GetIndexPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        List<User> allUsers = UserService.getInstance().getAllUsers();
//        req.setAttribute("users", allUsers);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/index.jsp");
//        try {
//            requestDispatcher.forward(req, resp);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

//        if (isLoginPasswordEmpty(login, password)) {
//            UserService service = UserService.getInstance();
//            if (service.validateUser(login, password)) {
//                User user = service.getUserByLogin(login);
//                resp.setContentType("text/html");
//                HttpSession session = req.getSession();
//                session.setMaxInactiveInterval(1800);
//                session.setAttribute("user", user);
//                session.setAttribute("message", "");
//                String path = req.getContextPath() + "/user";
//                resp.sendRedirect(path);
//            } else {
//                try {
//                    req.setAttribute("message", readProperty("invalidPass"));
//                } catch (ExceptionFromReadMethod exceptionFromReadMethod) {
//                    exceptionFromReadMethod.printStackTrace();
//                }
//                doGet(req, resp);
//            }
//        } else {
//            try {
//                req.setAttribute("message", readProperty("invalidData"));
//            } catch (ExceptionFromReadMethod exceptionFromReadMethod) {
//                exceptionFromReadMethod.printStackTrace();
//            }
//            doGet(req, resp);
//        }
    }

    private boolean isLoginPasswordEmpty(String login, String password) {
        return login != null && !login.isEmpty() &&
                password != null && !password.isEmpty();
    }
}

