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

@WebFilter("/*")
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

        final HttpSession session = req.getSession();
        String servletPath = req.getServletPath();

        //req.setAttribute("message", "");
        User user = (User) session.getAttribute("user");
        //User user = UserService.getInstance().getUserByLogin(login);
        String role = "";

        if (user != null) {
            role = user.getRole();
            if (servletPath.equals("/user")) {
                filterChain.doFilter(req, res);
            } else if (servletPath.equals("/logout")) {
                filterChain.doFilter(req, res);
            } else if (servletPath.equals("/login")) {
                filterChain.doFilter(req, res);
            }else if (role.equals("admin")) {
                filterChain.doFilter(req, res);
            } else if (role.equals("user")) {
                //req.setAttribute("user", user);
                res.sendRedirect("/user");
            }
        } else {
            req.getRequestDispatcher("/login").forward(req, res);
        }
    }



    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }



}
