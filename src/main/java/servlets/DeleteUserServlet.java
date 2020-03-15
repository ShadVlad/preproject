package servlets;

import service.UserService;
import utils.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        if (Util.idIsNumber(req)) {
            boolean status = UserService.getInstance().deleteUser(Integer.valueOf(req.getParameter("id")));
            resp.sendRedirect(req.getContextPath() + "/");
//            try {
//                boolean status = UserJdbcDAO.deleteUser(Integer.valueOf(req.getParameter("id")));
//                resp.sendRedirect(req.getContextPath() + "/");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }

    }
}
