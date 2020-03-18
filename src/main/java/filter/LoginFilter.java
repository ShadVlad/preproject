package filter;

import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

@WebFilter("/")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)

            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        final HttpSession session = req.getSession();
        req.setAttribute("message", "");
        User user = UserService.getInstance().getUserByLogin(login);
        String role = "";
        //Logged user.
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {
            role = String.valueOf(session.getAttribute("role"));

        }
        if (user == null) {
            if (login != null) {
                req.setAttribute("message", "login unknown");
            }
        } else if (!user.getPassword().equals(password)) {
            req.setAttribute("message", "password uncorrected");
        } else {
            role = user.getRole();
        }
        req.setAttribute("user", user);

        moveToRole(req, res, role);
    }


    private void moveToRole(final HttpServletRequest req,
                            final HttpServletResponse res,
                            final String role)
            throws ServletException, IOException {


        if (role.equals("admin")) {

            //res.sendRedirect( "/admin");
            req.getRequestDispatcher("/admin").forward(req, res);

        } else if (role.equals("user")) {

            //res.sendRedirect("/user");
            req.getRequestDispatcher("/WEB-INF/view/user.jsp").forward(req, res);

        } else {

            //res.sendRedirect("/login");
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
        }
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }



}
