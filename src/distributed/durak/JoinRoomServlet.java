package distributed.durak;

import distributed.durak.dao.OnlineRooms;
import distributed.durak.datamodel.Room;
import distributed.durak.datamodel.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Максим on 24.12.13.
 */
@WebServlet(name="JoinRoomServlet", urlPatterns={"/joinroom"})
public class JoinRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String owner = request.getParameter("roomOwner");
        User u = (User) request.getSession().getAttribute("user");

        if (u != null) {
            List<Room> rooms = OnlineRooms.getAllRooms();
            for (Room r : rooms) {
                if (r.getOwner().equals(u.getName())) {
                    rooms.remove(r);
                    break;
                }
            }

            for (Room r : rooms) {
                if (r.getOwner().equals(owner)) {
                    r.user2 = u.getName();
                    break;
                }
            }

            response.sendRedirect("/rooms");

        } else {
            request.getSession().setAttribute("message", "You must login.");
            response.sendRedirect("/error.jsp");
        }
    }
}
