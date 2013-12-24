package distributed.durak;

import distributed.durak.dao.DurakDao;
import distributed.durak.datamodel.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Максим on 15.12.13.
 */
@WebServlet(name="RegisterServlet", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DurakDao dao = new DurakDao();
        String username = request.getParameter("login");
        String password = request.getParameter("password");
        User usr = dao.registerUser(username, password, 0, 0);
        if (usr != null) {
            request.getSession().setAttribute("user", usr);
            //request.getRequestDispatcher("lk.jsp").forward(request, response);
            response.sendRedirect("/lk.jsp");
        } else {
            request.getSession().setAttribute("message", "User is already created.");
            response.sendRedirect("/error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
